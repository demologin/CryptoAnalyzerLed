package com.javarush.Apalinskiy.Constants;

import java.util.*;

public class Alphabet {
    private static final String ALPHABET = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static final String SYMBOLS = ",.? \";:'";

    public List <Character> getAlphabetToListToLowerCase(){
        List<Character> alphabet = new ArrayList<>();
        char[] chars = ALPHABET.toLowerCase().toCharArray();
        for (char aChar : chars) {
            alphabet.add(aChar);
        }
        return alphabet;
    }

    public List <Character> getAlphabetToListToUpperCase(){
        List<Character> alphabet = new ArrayList<>();
        char[] chars = ALPHABET.toUpperCase().toCharArray();
        for (char aChar : chars) {
            alphabet.add(aChar);
        }
        return alphabet;
    }

    public String getSYMBOLS() {
        return SYMBOLS;
    }
}

