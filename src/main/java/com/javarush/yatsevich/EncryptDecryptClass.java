package com.javarush.yatsevich;

public class EncryptDecryptClass {

    public static char[] encrypt(char[] textFromFile, int step) {
        for (int i = 0; i < textFromFile.length; i++) {
            textFromFile[i] = (char) (textFromFile[i] + step);
        }
        return textFromFile;
    }



}
