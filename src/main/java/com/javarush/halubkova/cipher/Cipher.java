package com.javarush.halubkova.cipher;

import com.javarush.halubkova.exception.CharNotFoundException;
import java.util.HashMap;

public class Cipher {
    private final char[] alphabet;

    public Cipher(char[] alphabet) {
        this.alphabet = alphabet;
    }

    public String encrypt(String text, int shift) throws CharNotFoundException {
        HashMap<Character, Character> knownCharMap = new HashMap<>();
        StringBuilder exit = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char charFromText = text.charAt(i);
            Character encryptedValue = knownCharMap.get(charFromText);
            if (encryptedValue != null) {
                exit.append(encryptedValue);
                continue;
            }

            int position = -1;
            for (int j = 0; j < alphabet.length; j++) {
                if ((charFromText) == alphabet[j]) {
                    position = j + shift;
                }
            }
            if (position == -1) {
                throw new CharNotFoundException();
                //continue;
            }
            if (position > alphabet.length - 1) {
                position = position % alphabet.length;
            }
            exit.append(alphabet[position]);
            knownCharMap.put(charFromText, alphabet[position]);
        }
        return exit.toString();
    }

    public String decrypt(String encryptedText, int shift) throws CharNotFoundException {
        HashMap<Character, Character> knownCharMap = new HashMap<>();
        StringBuilder exit = new StringBuilder();
        for (int i = 0; i < encryptedText.length(); i++) {
            char charFromText = encryptedText.charAt(i);
            Character decryptedValue = knownCharMap.get(charFromText);
            if (decryptedValue != null) {
                exit.append(decryptedValue);
                continue;
            }

            int position = alphabet.length;
            for (int j = 0; j < alphabet.length; j++) {
                if ((charFromText) == alphabet[j]) {
                    position = j - shift;
                }
            }
            if (position == alphabet.length) {
                throw new CharNotFoundException();
            }
            if (position < 0) {
                position = alphabet.length + position;
            }
            exit.append(alphabet[position]);
            knownCharMap.put(charFromText, alphabet[position]);
        }
        return exit.toString();

    }
}
