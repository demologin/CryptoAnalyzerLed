package com.javarush.pukhov.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileInput implements Input<InputStream, BufferedReader> {

    private final Path path;

    /**
     * @param path
     */
    public FileInput(Path path) {
        this.path = path;
    }

    @Override
    public String read() {
        return "";
    }

    @Override
    public InputStream getInputStream() {
        try {
            return Files.newInputStream(path);
        } catch (IOException e) {
            throw new com.javarush.pukhov.exception.IOException(e.getMessage(), e);
        }
    }

    @Override
    public BufferedReader getReader() {
        try {
            return Files.newBufferedReader(path);
        } catch (IOException e) {
            throw new com.javarush.pukhov.exception.IOException(e.getMessage(), e);
        }
    }

}
