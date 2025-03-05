package com.javarush.kazakov.core.files;

import com.javarush.kazakov.core.exceptions.CryptoAnalyzerException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * The {@code FileValidator} class validates file paths. Throws exceptions if something goes wrong.
 * <p>
 * {@code FileValidator} includes public constructor that accepts the file paths awaiting validation.
 *
 */
public class FileValidator {
    private final Path[] paths;

    /**
     * Creates an object of {@code FileValidator}.
     *
     * @param paths paths for validation
     */
    public FileValidator(Path... paths) {
        this.paths = paths;
    }

    /**
     * This method checks file is an {@code txt} file and creates the necessary directories if they do not exist.
     *
     * @throws CryptoAnalyzerException
     */
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
        if (!path.getFileName().toString().toLowerCase().endsWith(".txt")) {
            throw new CryptoAnalyzerException(path + " is not a txt file.");
        }
    }
}
