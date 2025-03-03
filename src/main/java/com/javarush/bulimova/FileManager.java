package com.javarush.bulimova;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileManager {

    String pathRead;
    String pathCreate;

    public FileManager(String pathRead, String pathCreate) {
        this.pathRead = pathRead;
        this.pathCreate = pathCreate;
    }

    public List<String> readFile() {
        // Логика чтения файла

        List<String> words;
        try {
            Path path = Path.of(this.pathRead);
            words = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        for (String str : words) {
//            System.out.println(str);
//            //выпилить  System.out.println("++");
//        }


        return words;
    }


}
