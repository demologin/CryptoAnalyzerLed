package com.javarush.apalinskiy.logic;

import com.javarush.apalinskiy.constants.Alphabet;
import com.javarush.apalinskiy.exceptions.AppException;
import com.javarush.apalinskiy.exceptions.ExceptionMessage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;

public class Decryption {
    public void decryption(int key, Path inputPath, Path outputPath) throws IOException {
        if (key > 80 || key <= 0) {
            throw new AppException(ExceptionMessage.getMessage());
        }
        try (BufferedReader reader = Files.newBufferedReader(inputPath);
             BufferedWriter writer = Files.newBufferedWriter(outputPath)) {
            ArrayList<Character> alphabet = Alphabet.getAlphabet();
            int symbol;
            while ((symbol = reader.read()) > -1) {
                if (alphabet.contains((char) symbol)) {
                    int index = alphabet.indexOf((char) symbol) - key;
                    if (index < 0) {
                        writer.write(alphabet.get(index + alphabet.size()));
                    } else writer.write(alphabet.get(index));
                }
            }
        } catch (NoSuchFileException e) {
            throw new AppException(ExceptionMessage.getSuchFileExc(inputPath));
        }
    }
}
