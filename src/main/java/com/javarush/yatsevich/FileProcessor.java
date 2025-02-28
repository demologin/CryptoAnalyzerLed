package com.javarush.yatsevich;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileProcessor {

    //static String inputPath = "C:\\Users\\user\\IdeaProjects\\CryptoAnalyzerLed\\text\\text.txt";
    //static String outputPath = "C:\\Users\\user\\IdeaProjects\\CryptoAnalyzerLed\\text\\todofile.txt";
    static char[] textFromFile;


    public void readFile(String filePath) {
        try {
            textFromFile = Files.readString(Path.of(filePath)).toCharArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public void writeFile(String content, String filePath) {

    }





}
