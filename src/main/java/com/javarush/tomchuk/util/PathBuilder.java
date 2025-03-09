package com.javarush.tomchuk.util;

import java.io.File;
import java.nio.file.Path;
import java.util.Objects;

public class PathBuilder {

    private static final String standartPathName = System.getProperty("user.dir") + File.separator + "text";
    private static final String standartResultFileName = "result.txt";
    private static final String standartSourceFileName = "text.txt";

    private PathBuilder() {

    }

    public static Path getPath(String fileName) {
        if (!Objects.equals(fileName, "")) {
            Path filePath = Path.of(fileName);
            if (filePath.isAbsolute()) {
                return filePath;
            }
        }
        return Path.of(standartPathName + File.separator + fileName);
    }

    public static String getStandartSourceFileName() {
        return standartSourceFileName;
    }

    public static String getStandartResultFileName() {
        return standartResultFileName;
    }
}
