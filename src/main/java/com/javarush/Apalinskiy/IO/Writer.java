package com.javarush.Apalinskiy.IO;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;

public class Writer {
    public Writer(char[] chars) throws IOException {
        FilePathResolver pathResolver = new FilePathResolver();
        BufferedWriter writer = Files.newBufferedWriter(pathResolver.getOutputPath());
        writer.write(chars);
        writer.close();
    }
}
