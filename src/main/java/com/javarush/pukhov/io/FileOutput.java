package com.javarush.pukhov.io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileOutput<T,J> implements Output<OutputStream, BufferedWriter> {

    private Path path;

    /**
     * @param path
     */
    public FileOutput(Path path) {
        this.path = path;
    }

    @Override
    public void print(String message) {
        try {
            Files.writeString(path, message);
        } catch (IOException e) {
            throw new com.javarush.pukhov.exception.IOException(e.getMessage(), e);
        }
    }

    @Override
    public OutputStream getOutputStream() {
        try {
            return Files.newOutputStream(path);
        } catch (IOException e) {
            throw new com.javarush.pukhov.exception.IOException(e.getMessage(), e);
        }
    }

    @Override
    public BufferedWriter getWriter() {
        try {
            return Files.newBufferedWriter(path);
        } catch (IOException e) {
            throw new com.javarush.pukhov.exception.IOException(e.getMessage(), e);
        }
    }

}
