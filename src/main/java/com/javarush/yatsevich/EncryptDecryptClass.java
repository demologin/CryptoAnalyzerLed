package com.javarush.yatsevich;

import java.util.Arrays;

public class EncryptDecryptClass {


    public static char[] encrypt(char[] textFromFile, int step) {
        char[] encryptedText = new char[textFromFile.length];
        try {
            for (int i = 0; i < textFromFile.length; i++) {
                encryptedText[i] = (char) (textFromFile[i] + step);
            }
        } catch (NullPointerException e) {
            System.out.println("File is empty, nothing to encrypt. " + e.getMessage());
        }
        return encryptedText;
    }

    public static char[] decrypt(char[] textFromFile, int step) {
        char[] decryptedText = new char[textFromFile.length];
        try {
            for (int i = 0; i < textFromFile.length; i++) {
                decryptedText[i] = (char) (textFromFile[i] - step);
            }
        } catch (NullPointerException e) {
            System.out.println("File is empty, nothing to decrypt. " + e.getMessage());
        }
        return decryptedText;
    }

    public static int findKey(char[] encryptedText, char[] sourceText) {

        for (int key = 0; key <= 100; key++) {
            char[] decryptedText = decrypt(encryptedText, key);
            if ((Arrays.toString(decryptedText)).equals((Arrays.toString(sourceText)))) {
                return key;
            }
        }
        return -1;
    }



}
