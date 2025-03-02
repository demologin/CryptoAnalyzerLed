package com.javarush.yatsevich;

public class EncryptDecryptClass {


    public static char[] encrypt(char[] textFromFile, int step) {
        char [] encryptedText = new char[textFromFile.length];
        try{
            for (int i = 0; i < textFromFile.length; i++) {
                encryptedText[i] = (char) (textFromFile[i] + step);
            }
        } catch (NullPointerException e) {
            System.out.println("File is empty, nothing to encrypt. " + e.getMessage());
        }
      return encryptedText;
    }

    public static char [] decrypt(char[] textFromFile, int step) {
        char [] decryptedText = new char[textFromFile.length];
        for (int i = 0; i < textFromFile.length; i++) {
            decryptedText[i] = (char) (textFromFile[i] - step);
        }
        return decryptedText;
    }



}
