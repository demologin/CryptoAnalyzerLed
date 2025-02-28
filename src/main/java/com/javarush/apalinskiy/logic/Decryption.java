package com.javarush.apalinskiy.logic;

import com.javarush.apalinskiy.constants.Alphabet;

import java.util.ArrayList;

public class Decryption {
    public char[] decryption(char[] chars, int key) {
        ArrayList<Character> alphabet = Alphabet.getAlphabet();
        char[] decryptedText = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            if (alphabet.contains(chars[i])) {
                int index = alphabet.indexOf(chars[i]) - key;
                if (index < 0) {
                    decryptedText[i] = alphabet.get(index + alphabet.size());
                } else decryptedText[i] = alphabet.get(index);
            }
        }
        return decryptedText;
    }
}
