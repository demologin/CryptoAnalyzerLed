package com.javarush.kulikov;

public class Cipher {

    public String encrypt(String text, int shift) {
        StringBuilder encrypted = new StringBuilder();
        if (shift < 0) {
            throw new IllegalArgumentException("Сдвиг не может быть отрицательным");
        }

        for (var character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'а' : 'А';
                character = (char) ((character - base + shift) % 33 + base);
            }
            encrypted.append(character);
        }
        return encrypted.toString();
    }

    public String decrypt(String encryptedText, int shift) {
        return null;
    }
}
