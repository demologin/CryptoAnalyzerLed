package com.javarush.Apalinskiy.IO;

import java.nio.file.Files;
import java.nio.file.Path;


public class FilePathResolver {

    private final Path inputPath;
    private final Path outputPath;

    public FilePathResolver(String input, String output) {
        this.inputPath = Path.of(input);
        this.outputPath = Path.of(output).toAbsolutePath();

        if (!Files.exists(inputPath)) {
            throw new IllegalArgumentException("Файл ввода не существует: " + inputPath);
        }
        if (Files.isDirectory(outputPath)) {
            throw new IllegalArgumentException("Путь вывода не может быть папкой: " + outputPath);
        }
    }

    public Path getInputPath() {
        return inputPath;
    }

    public Path getOutputPath() {
        return outputPath;
    }

}
