package com.javarush.apalinskiy.logic;

import com.javarush.apalinskiy.constants.Alphabet;

import java.util.ArrayList;

public class Encryption {
    public char[] encryption(char[] chars, int key) {
        ArrayList<Character> alphabet = Alphabet.getAlphabet();
        char[] encryptedText = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            if (alphabet.contains(chars[i])) {
                int index = alphabet.indexOf(chars[i]) + key;
                if (index >= alphabet.size()) {
                    encryptedText[i] = alphabet.get(index - alphabet.size());
                } else encryptedText[i] = alphabet.get(index);
            }
        }
        return encryptedText;
    }
}
