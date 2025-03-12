package com.javarush.pukhov.util;

import java.net.URI;
import java.nio.file.Path;

import com.javarush.pukhov.constant.Constants;

public final class BuilderPath {
    private BuilderPath() {
    }

    public static Path buildPath(String pathString) {
        Path file = Path.of(pathString);
        Path repository = Path.of(URI.create(Constants.PATH_REPOSITORY));
        return file.isAbsolute()
                ? file
                : repository.resolve(pathString);
    }
}
