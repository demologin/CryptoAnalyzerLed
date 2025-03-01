package com.javarush.mikhailov;


import java.io.File;
import java.nio.file.Path;

public class FileRead {
    File file = new File("C:\\Users\\Дмитрий\\IdeaProjects\\CryptoAnalyzerLed\\text\\text.txt");
    Path file1 = Path.of(file.toURI());

}
