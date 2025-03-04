package com.javarush.bulimova;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileManager {

    String pathRead;
    String pathCreate;

    public FileManager(String pathRead, String pathCreate) {
        this.pathRead = pathRead;
        this.pathCreate = pathCreate;
    }

    public List<Character> readFile() {
        // Логика чтения файла

         List<Character> words = new ArrayList<>();

        char character = 0;
        try (
                BufferedReader reader = Files.newBufferedReader(Path.of(this.pathRead))) {
            int value;
            while ((value = reader.read()) > -1) {
                words.add((char) value);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return words;
    }


}
