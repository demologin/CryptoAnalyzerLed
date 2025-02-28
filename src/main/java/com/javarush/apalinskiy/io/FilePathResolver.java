package com.javarush.apalinskiy.io;

import com.javarush.apalinskiy.constants.Const;

import java.nio.file.Path;
import java.util.Scanner;


public class FilePathResolver {
    Scanner scanner = new Scanner(System.in);
    private final Path inputPath = Path.of(scanner.nextLine());
    private final Path outputPath = Path.of(Const.txtPath).toAbsolutePath();

    public Path getInputPath() {
        return inputPath;
    }

    public Path getOutputPath() {
        return outputPath;
    }

}
