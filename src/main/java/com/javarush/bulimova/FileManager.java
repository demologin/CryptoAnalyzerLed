package com.javarush.bulimova;

import com.javarush.khmelov.constant.Const;
import com.javarush.khmelov.exception.AppException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
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
                character = (char) value;
                character = Character.toLowerCase(character);
                words.add(character);
            }
        } catch (IOException e) {
            System.out.println("файл не найден");
           // throw new RuntimeException(e);
        }
        return words;
    }


    public void writeFile(List<Character> words) {
        // Логика записи файла

        try (BufferedWriter writer = Files.newBufferedWriter(Path.of(this.pathCreate))) {
            for (Character word : words) {
                writer.write(word);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
