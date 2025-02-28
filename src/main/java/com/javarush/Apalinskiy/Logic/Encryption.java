package com.javarush.Apalinskiy.Logic;

import com.javarush.Apalinskiy.Constants.Alphabet;

import java.util.List;

public class Encryption {
    public char[] encryption(char[] chars, int key) {
        Alphabet alphabet = new Alphabet();
        List<Character> alphabetToListLowerCase = alphabet.getAlphabetToListToLowerCase();
        List<Character> alphabetToListUpperCase = alphabet.getAlphabetToListToUpperCase();
        char[] encryptionText = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            if (alphabetToListLowerCase.contains(chars[i])) {
                int index = alphabetToListLowerCase.indexOf(chars[i]);
                if (index + key >= alphabetToListLowerCase.size()) {
                    encryptionText[i] = alphabetToListLowerCase.get(((index + key) - alphabetToListLowerCase.size()));
                } else {
                    encryptionText[i] = alphabetToListLowerCase.get((index + key));
                }
            }else if (alphabetToListUpperCase.contains(chars[i])) {
                int index = alphabetToListUpperCase.indexOf(chars[i]);
                if (index + key >= alphabetToListUpperCase.size()) {
                    encryptionText[i] = alphabetToListUpperCase.get(((index + key) - alphabetToListUpperCase.size()));
                } else {
                    encryptionText[i] = alphabetToListUpperCase.get((index + key));
                }
            }else {
                encryptionText[i] = chars[i];
            }
        }
        return encryptionText;
    }
}
