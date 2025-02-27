package com.javarush.kazakov.core.files;

import com.javarush.kazakov.core.exceptions.CryptoAnalyzerException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileValidator {
    private final Path[] paths;

    public FileValidator(Path... paths) {
        this.paths = paths;
    }

    public void validate() {
        for (Path path : paths) {
            isTxtFile(path);
            createDirectoryIfNotPresent(path);
        }
    }

    private void createDirectoryIfNotPresent(Path path) {
        Path parent = path.getParent();
        if (!Files.isDirectory(parent)) {
            try {
                Files.createDirectories(parent);
            } catch (IOException e) {
                throw new CryptoAnalyzerException("Unable to create directory" + parent + ". " + e.getCause());
            }
        }
    }

    private void isTxtFile(Path path) {
        if (!path.getFileName().toString().endsWith(".txt")) {
            throw new CryptoAnalyzerException(path + " is not a txt file.");
        }
    }
}
