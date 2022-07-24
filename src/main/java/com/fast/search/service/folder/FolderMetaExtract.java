package com.fast.search.service.folder;

import java.io.File;

public class FolderMetaExtract {

    public void showFilesInDIr(String dirPath) {
        File dir = new File(dirPath);
        File files[] = dir.listFiles();

        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            if (file.isDirectory()) {
                showFilesInDIr(file.getPath());
            } else {
                System.out.println("file: " + file);
            }
        }
    }
}
