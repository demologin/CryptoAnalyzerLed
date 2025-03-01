package com.javarush.burdygin.Activity;

import com.javarush.burdygin.inputOutput.CreatePath;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Activity {
    public int index;

    public Activity() {
    }

    public void activity(){

        Path sourceFilePath = CreatePath.get("text.txt");
        Path encryptedFilePath = CreatePath.get("encrypted.txt");
        Path decryptedFilePath = CreatePath.get("decrypted.txt");

        try (BufferedReader bufferedReader = Files.newBufferedReader(encryptedFilePath);
             BufferedWriter bufferedWriter = Files.newBufferedWriter(decryptedFilePath)) {
            while (bufferedReader.ready()) {
                char[] readString = bufferedReader.readLine().toCharArray();
                for (int i = 0; i < readString.length; i++) {
                    readString[i] = (char) (readString[i] + index);
                }
                bufferedWriter.write(String.valueOf(readString));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
