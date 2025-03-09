package com.javarush.lepeshinskiy;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Validator {

    public boolean isFileExists(String filePath) {
        if (filePath == null || filePath.trim().isEmpty()) {
            return false;
        }
        
        Path path = Paths.get(filePath);
        return Files.exists(path) && Files.isRegularFile(path);
    }
    
    public boolean isKeyValid(int key, int alphabetSize) {
        return key >= 0 && key < alphabetSize;
    }
}