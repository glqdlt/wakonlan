package com.glqdlt.myho.intergration.renamer;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributeView;

public class Renamer {
    public void getFileAttributes(File f) {

        BasicFileAttributeView zzz = Files.getFileAttributeView(f.toPath(), BasicFileAttributeView.class, null);
        System.out.println(zzz);
    }
}
