package com.javarush.apalinskiy.logic;

import com.javarush.apalinskiy.constants.Alphabet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Encryption {
    public void encryption(int key, String inputPath, String outputPath) throws IOException {
        try(BufferedReader reader = Files.newBufferedReader(Path.of(inputPath));
        BufferedWriter writer = Files.newBufferedWriter(Path.of(outputPath))) {
            ArrayList<Character> alphabet = Alphabet.getAlphabet();
            int symbol;
            while ((symbol = reader.read()) > -1) {
                if (alphabet.contains((char) symbol)) {
                    int index = alphabet.indexOf((char) symbol) + key;
                    if (index >= alphabet.size()) {
                        writer.write(alphabet.get(index - alphabet.size()));
                    } else writer.write(alphabet.get(index));
                }
            }
        }
    }
}
