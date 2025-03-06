package com.javarush.apalinskiy.io;

import com.javarush.apalinskiy.constants.Const;

import java.io.File;
import java.nio.file.Path;


public class FilePathResolver {
    private final Path inputPath = Path.of(Const.txtPathInput).toAbsolutePath();
    private final Path outputPath = Path.of(Const.txtPathOutput).toAbsolutePath();
    private final Path freshPath = Path.of(Const.freshTxt).toAbsolutePath();

    public Path getFreshPath() {
        return freshPath;
    }

    public Path getInputPath() {
        return inputPath;
    }

    public Path getOutputPath() {
        return outputPath;
    }


    public Path buildPath(String input, Path path){
        if (input.isEmpty()) {
            return path;
        } else if (!input.contains(File.separator)) {
            return Path.of(Const.txtPath + input).toAbsolutePath();
        } else {
            return Path.of(input);
        }
    }
}
