package com.javarush.Apalinskiy.Logic;

import com.javarush.Apalinskiy.Constants.Alphabet;

import java.util.List;

public class Encryption {
    public char[] encryption(char[] chars, int key) {
        Alphabet alphabet = new Alphabet();
        List<Character> alphabetToList = alphabet.getAlphabetToList();
        char[] encryptionText = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            if (alphabetToList.contains(chars[i])) {
                encryptionText[i] = alphabetToList.get(i + key);
            } else {
                encryptionText[i] = chars[i];
            }
        }
        return encryptionText;
    }
}
