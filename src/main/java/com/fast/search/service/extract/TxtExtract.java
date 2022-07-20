package com.fast.search.service.extract;

import org.springframework.stereotype.Service;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@Service
public class TxtExtract implements Extract{
    final String SOURCE_FILE_PATH = "C:/testdata/00003.txt";

    @Override
    public String extract() {

        final int bufferMaxSize = 1024 * 1024;

        Path sourceFilePath = Paths.get(SOURCE_FILE_PATH);

        Charset charset = Charset.defaultCharset();
        StringBuilder sb = new StringBuilder();

        try (FileChannel sourceChannel = FileChannel.open(sourceFilePath, StandardOpenOption.READ);)
        {
            ByteBuffer buffer = ByteBuffer.allocateDirect(bufferMaxSize);

            while (sourceChannel.read(buffer) >= 0)
            {
                buffer.flip();

                sb.append(charset.decode(buffer).toString());

                buffer.clear();
            }
            System.out.println(sb.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
