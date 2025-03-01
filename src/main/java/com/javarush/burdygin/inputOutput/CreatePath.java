package com.javarush.burdygin.inputOutput;

import java.io.File;
import java.nio.file.Path;

public class CreatePath {
    /**
     * "pathBuilder" is occupied with you
     */

    private CreatePath() {
    }

    public static Path get(String file){
        return Path.of("text" + File.separator + file);
    }
}
