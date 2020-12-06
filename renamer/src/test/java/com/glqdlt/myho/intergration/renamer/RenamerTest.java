package com.glqdlt.myho.intergration.renamer;


import org.junit.jupiter.api.Test;

import java.io.File;

public class RenamerTest {

    @Test
    public void test() {
        Renamer renamer
                = new Renamer();
        renamer.getFileAttributes(new File("F:/D/CANON/IMG_3415.JPG"));
    }
}
