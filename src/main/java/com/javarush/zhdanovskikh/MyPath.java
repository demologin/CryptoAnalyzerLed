package com.javarush.zhdanovskikh;

public class MyPath {
    private MyPath() {
    }

    public static java.nio.file.Path get(String filename) {
        java.nio.file.Path path = java.nio.file.Path.of(filename);
        return path.isAbsolute()
                ? path
                : java.nio.file.Path.of(Constants.TXT_FOLDER + filename);
    }
}
