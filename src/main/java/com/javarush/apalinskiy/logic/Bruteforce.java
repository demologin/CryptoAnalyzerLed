package com.javarush.apalinskiy.logic;

import com.javarush.apalinskiy.constants.MostUsageWords;
import com.javarush.apalinskiy.exceptions.AppException;
import com.javarush.apalinskiy.exceptions.ExceptionMessage;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Bruteforce {

    public void bruteforce(Path inputPath, Path outputPath) throws IOException {
        List<String> words = MostUsageWords.getWORDS();
        Decryption decryption = new Decryption();
        int count = 0;
        for (int i = 1; i < 81; i++) {
            decryption.decryption(i, inputPath, outputPath);
            String decryptedText = Files.readString(outputPath);
            for (String word : words) {
                if (decryptedText.contains(word)) {
                    count++;
                }
            }
            if (i == 80 && count < 37) {
                throw new AppException(ExceptionMessage.getBruteforceMessage());
            } else if (count >= 37) {
                try (BufferedWriter writer = Files.newBufferedWriter(outputPath)) {
                    writer.write(decryptedText);
                }
                return;
            }
            count = 0;
        }
    }
}
