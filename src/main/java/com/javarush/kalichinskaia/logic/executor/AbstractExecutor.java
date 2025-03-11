package com.javarush.kalichinskaia.logic.executor;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class AbstractExecutor implements Executor {
    public static String readFile(String filePath) throws IOException {
        Path path = Paths.get(filePath).toAbsolutePath();
        byte[] bytes = Files.readAllBytes(path);
        return new String(bytes, StandardCharsets.UTF_8).toLowerCase();
    }
}
