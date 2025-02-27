package com.javarush.Apalinskiy.Constants;

import java.util.*;

public class Alphabet {
    private static final String ALPHABET = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static final String SYMBOLS = ",.? \";:'";

    public Map <Integer, Character> getAlphabetToMap(){
        Map<Integer, Character> alphabet = new HashMap<>();
        char[] chars = ALPHABET.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            alphabet.put(i, chars[i]);
        }
        return alphabet;
    }

    public String getSYMBOLS() {
        return SYMBOLS;
    }
}

