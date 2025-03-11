package com.javarush.halubkova.ui;

import java.nio.file.Files;
import java.nio.file.Path;

public class Validator {
    public boolean isValidKey(int key, char[] alphabet) {
        if (key < 0 || key >= alphabet.length) {
            return false;
        }
        return true;
    }

    public boolean isFileExists(String filePath) {
        return Files.exists(Path.of(filePath));
    }

    public boolean isFileNameValid(String fileName) {
        return fileName.endsWith(".txt");
    }

}
