package com.javarush.yatsevich;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileProcessor {

    //static String inputPath = "C:\\Users\\user\\IdeaProjects\\CryptoAnalyzerLed\\text\\text.txt";
    //static String outputPath = "C:\\Users\\user\\IdeaProjects\\CryptoAnalyzerLed\\text\\todofile.txt";




    public  char[] readFile(String filePath) {
        char [] textFromFile = new char[0];
        try {
            textFromFile = Files.readString(Path.of(filePath)).toCharArray();
        }
        catch (IOException e) {
            System.out.println("Error while reading the file. " + e.getMessage());
        }
        return textFromFile;
    }

    public  void writeFile(char[] content, String filePath) {
        try{
            Files.writeString(Path.of(filePath), new String (content));

        } catch (IOException e) {
            System.out.println("Error writing file. " + e.getMessage());
        }
        System.out.println("File written to " + filePath);
    }





}
