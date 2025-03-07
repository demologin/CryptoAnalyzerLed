package com.javarush.tomchuk.util;

import java.io.File;
import java.nio.file.Path;

public class PathBuilder {

    private PathBuilder() {

    }

    public static Path getPath(String fileName) {
        Path filePath = Path.of(fileName);
        if (filePath.isAbsolute()) {
            return filePath;
        }
        return Path.of(System.getProperty("user.dir") + File.separator + "text" + File.separator + fileName);
    }
}
