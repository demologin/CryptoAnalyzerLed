package com.javarush.burkhanova;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.javarush.burkhanova.Cipher.decrypt;
import static com.javarush.burkhanova.Cipher.encrypt;
import static com.javarush.burkhanova.FileManager.writeFile;
import static com.javarush.burkhanova.Validator.countValidWords;

public class FileProcessor {
    public static void encryptFile(String inputPath, String outputPath, int key) throws IOException {

        String input = FileManager.readFile(inputPath);
        String encryptedText = encrypt(input, key);
        writeFile(encryptedText, outputPath);
    }

    public static void decryptFile(String inputPath, String outputPath, int key) throws IOException {

        String input = FileManager.readFile(inputPath);
        String decryptedText = decrypt(input, key);
        writeFile(decryptedText, outputPath);
    }

    public static void bruteForceFile(String inputPath, String outputPath) throws IOException {
        String input = FileManager.readFile(inputPath);
        String bestMatch = "";
        int bestMatchScore = Integer.MIN_VALUE;
        int foundKey = -1;

        for (int key = 1; key < 43; key++) {
            String decryptedText = decrypt(input, key);
            int validWords = countValidWords(decryptedText);

            if (validWords > bestMatchScore) {
                bestMatchScore = validWords;
                bestMatch = decryptedText;
                foundKey = key;
            }
        }
        File outputFile = new File(outputPath);
        if (!outputFile.exists()) {
            Files.createDirectories(Paths.get(outputPath).getParent());
            Files.createFile(Paths.get(outputPath));
        }

        writeFile(bestMatch, outputPath);
        System.out.println("Brute force complete! Best key found: " + foundKey);
    }
}
