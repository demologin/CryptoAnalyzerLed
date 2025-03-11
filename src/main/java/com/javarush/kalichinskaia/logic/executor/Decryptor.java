package com.javarush.kalichinskaia.logic.executor;

import com.javarush.kalichinskaia.exception.AppExeption;
import com.javarush.kalichinskaia.logic.Result;
import com.javarush.kalichinskaia.logic.ResultCode;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static com.javarush.kalichinskaia.logic.executor.Messages.SUCCESS_MESSAGE;
import static com.javarush.kalichinskaia.logic.Alphabet.CHARS;
import static com.javarush.kalichinskaia.logic.Alphabet.INDEX_CHAR;

public class Decryptor extends AbstractExecutor {

    @Override
    public Result execute(List<String> parameters) {
        String sourceDecrypt = parameters.get(1);
        String destinationDecrypt = parameters.get(2);
        int keyDecrypt = (Integer.parseInt(parameters.get(3)));

        Path destination = Paths.get(destinationDecrypt).toAbsolutePath();

        try (BufferedWriter writer = Files.newBufferedWriter(destination)) {
            char[] fileChars = readFile(sourceDecrypt).toCharArray();

            for (char fileChar : fileChars) {
                if (INDEX_CHAR.containsKey(fileChar)) {
                    int currentPosition = INDEX_CHAR.get(fileChar);
                    int shiftedPosition = (currentPosition - keyDecrypt) % CHARS.length;
                    if (shiftedPosition < 0) {
                        shiftedPosition = CHARS.length + shiftedPosition;
                    }
                    char newChar = CHARS[shiftedPosition];
                    writer.write(newChar);
                } else if (fileChar == '\n') {
                    writer.write(fileChar);
                }
            }
        } catch (IOException e) {
            throw new AppExeption(Messages.INCORRECT_FILE + e.getMessage(), e);
        }
        return new Result(ResultCode.SUCCESS, String.format(SUCCESS_MESSAGE, destinationDecrypt));
    }

}
