package com.javarush.Apalinskiy.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class Reader {
    public char[] reader() throws IOException {
        char[] buffer = new char[16 * 1024];
        FilePathResolver pathResolver = new FilePathResolver();
        BufferedReader bufferedReader =Files.newBufferedReader(pathResolver.getInputPath());
        int read = bufferedReader.read(buffer);
        bufferedReader.close();
        return Arrays.copyOf(buffer, read);
    }

}
