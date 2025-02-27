package com.javarush.Apalinskiy.Constants;

import java.util.ArrayList;

public class Alphabet {
    private static final String ALPHABET = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static final String SYMBOLS = ",.? \";:'";

    public ArrayList <Character> getAlphabetToList(){
        ArrayList<Character> alphabet = new ArrayList<>();
        char[] chars = ALPHABET.toCharArray();
        for (char aChar : chars) {
            alphabet.add(aChar);
        }
        return alphabet;
    }

    public String getSYMBOLS() {
        return SYMBOLS;
    }
}

