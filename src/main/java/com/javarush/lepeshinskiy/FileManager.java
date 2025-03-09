package com.javarush.lepeshinskiy;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import static com.javarush.lepeshinskiy.AppConstants.FileOperations;

public class FileManager {

    public String readFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        return Files.readString(path, Charset.forName(FileOperations.DEFAULT_CHARSET));
    }

    public void writeFile(String filePath, String content) throws IOException {
        Path path = Paths.get(filePath);
        Files.writeString(path, content, Charset.forName(FileOperations.DEFAULT_CHARSET));
    }

    public void processFile(String inputFile, String outputFile, int key, CipherAction action) throws IOException {
        Cipher cipher = new Cipher();
        String content = readFile(inputFile);

        if (action == CipherAction.BRUTE_FORCE) {
            performBruteForce(inputFile, outputFile);
        } else {
            String result;
            if (action == CipherAction.ENCRYPT) {
                result = cipher.encrypt(content, key);
            } else {
                result = cipher.decrypt(content, key);
            }
            writeFile(outputFile, result);
        }
    }

    private void performBruteForce(String inputFile, String outputFile) throws IOException {
        Cipher cipher = new Cipher();
        String content = readFile(inputFile);
        StringBuilder resultBuilder = new StringBuilder();

        int alphabetSize = cipher.getAlphabetSize();
        int bestKey = -1;
        int highestScore = -1;
        String bestDecryption = "";

        List<String> commonWords = Arrays.asList(
                " и ", " в ", " на ", " не ", " что ", " по ", " с ", " а ", " для ", " от ", " как ", " у ", " но ", " за ", " то ",
                " я ", " к ", " мы ", " вы ", " так ", " его ", " это ", " был ", " все ", " из "
        );

        for (int key = 0; key < alphabetSize; key++) {
            String decrypted = cipher.decrypt(content, key);

            int score = 0;
            for (String word : commonWords) {
                int index = 0;
                while ((index = decrypted.indexOf(word, index)) != -1) {
                    score++;
                    index += word.length();
                }
            }

            int spaceCount = 0;
            for (char c : decrypted.toCharArray()) {
                if (c == ' ') {
                    spaceCount++;
                }
            }

            double spacePercent = (double) spaceCount / decrypted.length() * 100;
            if (spacePercent >= 13 && spacePercent <= 22) {
                score += 10;
            }

            if (score > highestScore) {
                highestScore = score;
                bestKey = key;
                bestDecryption = decrypted;
            }
        }

        if (bestKey != -1) {
            resultBuilder.append("Most probable key is: ").append(bestKey).append("\n\n");
            resultBuilder.append(bestDecryption);
            writeFile(outputFile, resultBuilder.toString());
        } else {
            throw new IOException("Cannot find a suitable key for decryption");
        }
    }
}