package com.javarush.burkhanova;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManager {


    public static String readFile(String fileInput) throws IOException {

        Path path = Paths.get(fileInput);
        byte[] bytes = Files.readAllBytes(path);

        return new String(bytes, StandardCharsets.UTF_8);


    }

    public static void writeFile(String content, String fileOutput) throws IOException {
        Path output = Paths.get(fileOutput);

        Files.write(output, content.getBytes(StandardCharsets.UTF_8));



    }
}
