package com.javarush.burdygin.inputOutput;

import java.io.File;
import java.nio.file.Path;

public class PathHelper {

    private PathHelper() {
    }

    public static Path get(String file){
        return Path.of("text" + File.separator + file).toAbsolutePath();
    }
}
