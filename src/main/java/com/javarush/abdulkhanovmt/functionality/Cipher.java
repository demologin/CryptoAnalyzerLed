package com.javarush.abdulkhanovmt.functionality;

import com.javarush.abdulkhanovmt.exception.CipherException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Cipher {

    public static void encrypt(String sourceFile, String destinationFile, int key) {
        copyWithShift(sourceFile, key, destinationFile);
    }

    public static void decrypt(String sourceFile, String destinationFile, int key) {
        key *= -1;
        copyWithShift(sourceFile, key, destinationFile);
    }

    public static void copyWithShift(String sourceFile, int key, String destinationFile) {
        Path src = FileManager.get(sourceFile);
        Path dst = FileManager.get(destinationFile);
        try (BufferedReader bufferedReader = Files.newBufferedReader(src);
             BufferedWriter bufferedWriter = Files.newBufferedWriter(dst)) {
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                char[] charBuffer = line.toCharArray();
                shiftCharacter(charBuffer, key);
                bufferedWriter.write(charBuffer);
            }
        } catch (IOException e) {
            throw new CipherException(Const.INCORRECT_FILE + e.getMessage(), e);
        }
    }

    public static void shiftCharacter(char[] charBuffer, int key) {
        for (int i = 0; i < charBuffer.length; i++) {
            if (charBuffer[i] == '\n') {
                charBuffer[i] = '\n';
            } else {
                charBuffer[i] = Alphabet.getCharacter(Alphabet.getIndex(charBuffer[i]) + key);
                if(charBuffer[i]=='\n'){
                    charBuffer[i] = Alphabet.getCharacter(Alphabet.getIndex(charBuffer[i]) + 1);
                }
            }
        }
    }


}
