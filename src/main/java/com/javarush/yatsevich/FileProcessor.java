package com.javarush.yatsevich;

import java.io.IOException;
import java.nio.file.Files;

public class FileProcessor {



    public char[] readFile(String filePath) {
        char[] textFromFile = new char[0];
        try {
            textFromFile = Files.readString(PathBuilder.get(filePath)).toCharArray();
        } catch (IOException e) {
            System.out.println("Error while reading the file. " + e.getMessage());
        }
        return textFromFile;
    }

    public void writeFile(char[] content, String filePath) {
        try {
            Files.writeString(PathBuilder.get(filePath), new String(content));

        } catch (IOException e) {
            System.out.println("Error writing file. " + e.getMessage());
        }
        System.out.println("File written to " + filePath);
    }


}
