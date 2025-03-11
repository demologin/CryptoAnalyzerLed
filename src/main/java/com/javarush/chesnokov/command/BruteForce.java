package com.javarush.chesnokov.command;

import com.javarush.chesnokov.Alphabet;
import com.javarush.chesnokov.result.Result;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BruteForce extends AbstractCommand {

    @Override
    public Result execute(String[] parameters) {

        String source = parameters[0];
        String target = parameters[1];
        String alphabet = new Alphabet().getAlphabet();
        char[] chars = alphabet.toCharArray();

        int bestKey = 0;
        int bestSpaceCount = 0;
        char spaceChar = ' ';

        for (int key = 0; key < chars.length; key++) {
            int spaceCount = spaceCountInFile(source, key, alphabet, spaceChar);
            if (spaceCount > bestSpaceCount) {
                bestSpaceCount = spaceCount;
                bestKey = key;
            }
        }
        return copyWithKey(source, target, bestKey, alphabet);
    }

    public int spaceCountInFile(String sourceTextFile, int key, String alphabet, char spaceChar) {
        Path pathReader = Path.of(sourceTextFile);
        int spaceCount = 0;

        try (BufferedReader reader = Files.newBufferedReader(pathReader)) {
            int length = alphabet.length();
            int value;

            while ((value = reader.read()) > -1) {
                char character = (char) value;
                int index = alphabet.indexOf(character);
                if (index != -1) {
                    int newIndex = (index + key + length) % length;
                    char newChar = alphabet.charAt(newIndex);
                    if (newChar == spaceChar) {
                        spaceCount++;
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Incorrect file:" + e.getMessage(), e);
        }
        return spaceCount;
    }
}


