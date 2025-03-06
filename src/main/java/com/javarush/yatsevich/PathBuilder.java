package com.javarush.yatsevich;



import java.io.File;
import java.nio.file.Path;

public class PathBuilder {

    static String TXT_FOLDER = System.getProperty("user.dir") +
            File.separator +
            "text" +
            File.separator;

    public static Path get(String filename) {
        Path path = Path.of(filename);
        return path.isAbsolute()
                ? path
                : Path.of(TXT_FOLDER + filename);
    }
}
