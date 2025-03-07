package com.javarush.chesnokov.command;

import com.javarush.chesnokov.Alphabet;
import com.javarush.chesnokov.result.Result;
import com.javarush.chesnokov.result.ResultCode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public abstract class AbstractCommand implements Command {

    public Result copyWithKey(String sourceTextFile, String targetTextFile, int key, String alphabet) {

        Path pathReader = Path.of(sourceTextFile);
        Path pathWriter = Path.of(targetTextFile);

        try (BufferedReader reader = Files.newBufferedReader(pathReader);
             BufferedWriter writer = Files.newBufferedWriter(pathWriter)) {

            int length = alphabet.length();
            int value;

            while ((value = reader.read()) > -1) {
                char character = (char) value;
                int index = alphabet.indexOf(character);
                if (index != -1) {
                    int newIndex = (index + key) % length;
                    writer.write(alphabet.charAt(newIndex));
                } else {
                    writer.write(character);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Incorrect file:" + e.getMessage(), e);
        }
        return new Result(ResultCode.OK, targetTextFile);
    }
}
