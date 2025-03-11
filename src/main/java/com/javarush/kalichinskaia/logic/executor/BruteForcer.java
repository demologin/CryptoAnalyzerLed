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

public class BruteForcer extends AbstractExecutor {

    @Override
    public Result execute(List<String> parameters) {
        String encryptedFile = parameters.get(1); // зашифрованный файл
        String decryptedFile = parameters.get(2); // расшифрованный файл методом BruteForce
        int bestKeyDecrypt = 0;
        int bestCountOfPopular = 0;
        char popularSymbol = ' ';

        for (int keyDecrypt = 0; keyDecrypt < CHARS.length; keyDecrypt++) {
            int countPopular = getCountOfPopular(encryptedFile, keyDecrypt, popularSymbol);
            if (countPopular > bestCountOfPopular){
                bestCountOfPopular = countPopular;
                bestKeyDecrypt = keyDecrypt;
            }
        }

        Path destination = Paths.get(decryptedFile).toAbsolutePath();

        try (BufferedWriter writer = Files.newBufferedWriter(destination)) {
            char[] fileChars = readFile(encryptedFile).toCharArray();

            for (char fileChar : fileChars) {
                if (INDEX_CHAR.containsKey(fileChar)) {
                    int currentPosition = INDEX_CHAR.get(fileChar);
                    int shiftedPosition = (currentPosition - bestKeyDecrypt) % CHARS.length;
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

        return new Result(ResultCode.SUCCESS, String.format(SUCCESS_MESSAGE, decryptedFile));
    }

    public int getCountOfPopular(String encryptedFile, int keyDecrypt, char popularSymbol) {
        try {
            int countSpace = 0;
            char[] fileChars = readFile(encryptedFile).toCharArray();
            for (char fileChar : fileChars) {
                if (!INDEX_CHAR.containsKey(fileChar)) continue;
                int currentPosition = INDEX_CHAR.get(fileChar);
                int shiftedPosition = (currentPosition - keyDecrypt) % CHARS.length;
                if (shiftedPosition < 0) {
                    shiftedPosition = CHARS.length + shiftedPosition;
                }
                char newChar = CHARS[shiftedPosition];
                if (newChar == popularSymbol) {
                    countSpace++;
                }
            }
            return countSpace;
        } catch (IOException e) {
            throw new AppExeption(Messages.INCORRECT_FILE + e.getMessage(), e);
        }
    }
}
