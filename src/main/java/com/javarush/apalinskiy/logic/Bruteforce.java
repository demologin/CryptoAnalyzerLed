package com.javarush.apalinskiy.logic;

import com.javarush.apalinskiy.constants.MostUsageWords;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Bruteforce {

    public void bruteforce(String inputPath, String outputPath) throws IOException {
        List<String> words = MostUsageWords.getWORDS();
        Decryption decryption = new Decryption();
        int count = 0;
        for (int i = 1; i < 81; i++) {
            decryption.decryption(i, inputPath, outputPath);
            String decryptedText = Files.readString(Path.of(outputPath));
            for (String word : words) {
                if (decryptedText.contains(word)) {
                    count++;
                }
            }
            if (count >= 37) {
                try (BufferedWriter writer = Files.newBufferedWriter(Path.of(outputPath))) {
                    writer.write(decryptedText);
                }
                return;
            }
            count = 0;
        }
    }
}
