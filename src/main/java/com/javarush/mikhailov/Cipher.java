package com.javarush.mikhailov;

public class Cipher extends Alphabet {
    public String encrypt(String text, int shift){
        if(shift<0){
            throw new IllegalArgumentException("Отрицательное число");
        }
        return text.chars().toString();
    }

    private char encryptChar(char character, int shift) {
        if (!Character.isLetter(chars.length)) {
            return character;
        }
        char Case = Character.toLowerCase(character);
        int length = chars.length;
        return  (char) ((char) (character - Case + shift) % length);

    }
    public String decrypt(String encryptedText, int shift){
        if(shift<0){
            throw new IllegalArgumentException("Отрицательное число");
        }
        return encryptedText.chars().toString();
    }

    private char decryptChar(char character, int shift) {
        if (!Character.isLetter(character)) {
            return character;
        }
        char lowerCase = Character.toLowerCase(character);
        int length = chars.length;
        return (char) ((char) (character - lowerCase - shift - length) % length - lowerCase);

    }
}
