package com.javarush.abdulkhanovmt.functionality;

import java.nio.file.Path;

public class FileManager {

    public FileManager() {
    }

    public static Path get(String filename) {
        Path path = Path.of(filename);
        return path.isAbsolute()
                ? path
                : Path.of(Const.TXT_FOLDER + filename);
    }


}
