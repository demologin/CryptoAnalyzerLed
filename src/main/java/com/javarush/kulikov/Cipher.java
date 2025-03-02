package com.javarush.kulikov;

public class Cipher {

    public String encrypt(String text, int shift) {
        if (shift < 0) {
            throw new IllegalArgumentException("Сдвиг не может быть отрицательным");
        }

        return text.chars()
                .mapToObj(ch -> encryptChar((char) ch, shift))
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }

    private char encryptChar(char character, int shift) {
        if (!Character.isLetter(character)) {
            return character;
        }

        char base = Character.isLowerCase(character) ? 'а' : 'А';
        return (char) ((character - base + shift) % 33 + base);
    }


    public String decrypt(String encryptedText, int shift) {
        if (shift < 0) {
            throw new IllegalArgumentException("Сдвиг не может быть отрицательным");
        }

        return encryptedText.chars()
                .mapToObj(ch -> decryptChar((char) ch, shift))
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }

    private char decryptChar(char character, int shift) {
        if (!Character.isLetter(character)) {
            return character;
        }

        char base = Character.isLowerCase(character) ? 'а' : 'А';
        return (char) ((character - base - shift + 33) % 33 + base);
    }
}
