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

public class Encryptor extends AbstractExecutor {

    @Override
    public Result execute(List<String> parameters) {
        String sourceEncrypt = parameters.get(1);
        String destinationEncrypt = parameters.get(2);
        int keyEncrypt = Integer.parseInt(parameters.get(3));

        Path destination = Paths.get(destinationEncrypt).toAbsolutePath();

        try (BufferedWriter writer = Files.newBufferedWriter(destination)) {
            char[] fileChars = readFile(sourceEncrypt).toCharArray();

            for (char fileChar : fileChars) {
                if (INDEX_CHAR.containsKey(fileChar)) {
                    int currentPosition = INDEX_CHAR.get(fileChar);
                    int shiftedPosition = (currentPosition + (keyEncrypt % CHARS.length)) % CHARS.length;
                    char newChar = CHARS[shiftedPosition];
                    writer.write(newChar);
                } else if (fileChar == '\n') {
                    writer.write(fileChar);
                }
            }
        } catch (IOException e) {
            throw new AppExeption(Messages.INCORRECT_FILE + e.getMessage(), e);
        }
        return new Result(ResultCode.SUCCESS, String.format(SUCCESS_MESSAGE, destinationEncrypt));
    }

}
