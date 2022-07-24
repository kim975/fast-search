package com.fast.search.service.folder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FolderMetaExtractTest {

    @Test
    void showFilesInDIr() {

        FolderMetaExtract a = new FolderMetaExtract();

        a.showFilesInDIr("C:/testdata");
    }
}