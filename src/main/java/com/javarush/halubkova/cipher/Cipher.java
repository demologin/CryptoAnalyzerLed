package com.javarush.halubkova.cipher;

import com.javarush.halubkova.exception.CharNotFoundException;

public class Cipher {
    private final char[] alphabet;

    public Cipher(char[] alphabet) {
        this.alphabet = alphabet;
    }

    public String encrypt(String text, int shift) throws CharNotFoundException {
        StringBuilder exit = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            int position = -1;
            for (int j = 0; j < alphabet.length; j++) {
                if ((text.charAt(i)) == alphabet[j]) {
                    position = j + shift;
                }
            }
            if (position > alphabet.length - 1) {
                position = position % alphabet.length;
                exit.append(alphabet[position]);
            } else if (position == -1) {
                throw new CharNotFoundException();
            } else {
                exit.append(alphabet[position]);
            }
        }

        return exit.toString();
    }

    public String decrypt(String encryptedText, int shift) throws CharNotFoundException {
        StringBuilder exit = new StringBuilder();
        for (int i = 0; i < encryptedText.length(); i++) {
            int position = alphabet.length;
            for (int j = 0; j < alphabet.length; j++) {
                if ((encryptedText.charAt(i)) == alphabet[j]) {
                    position = j - shift;
                }
            }
            if (position < 0) {
                position = alphabet.length + position;
                exit.append(alphabet[position]);
            } else if (position == alphabet.length) {
                throw new CharNotFoundException();
            } else {
                exit.append(alphabet[position]);
            }
        }
        return exit.toString();
    }

    //Ты будешь использовать этот код использовать в следующих подзадачах, поэтому выводить результат можно
    // в поток.

}
