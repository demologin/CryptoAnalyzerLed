package com.javarush.Apalinskiy.Constants;

import java.util.*;

public class Alphabet {
    private static final String ALPHABET = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static final String SYMBOLS = ",.? \";:'";

    public List <Character> getAlphabetToList(){
        List<Character> alphabet = new ArrayList<>();
        char[] chars = ALPHABET.toLowerCase().toCharArray();
        for (char aChar : chars) {
            alphabet.add(aChar);
        }
        return alphabet;
    }

    public String getSYMBOLS() {
        return SYMBOLS;
    }
}

