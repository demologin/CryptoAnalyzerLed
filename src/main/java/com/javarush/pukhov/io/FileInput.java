package com.javarush.pukhov.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileInput<T,J> implements Input<InputStream, BufferedReader> {

    private Path path;

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
