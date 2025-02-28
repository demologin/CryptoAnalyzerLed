package com.javarush.apalinskiy.constants;

import java.util.*;

public class Alphabet {
    private static final String ALPHABET = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя,.? \";:'<>«»\n–-";

    public static ArrayList <Character> getAlphabet(){
        ArrayList<Character> alphabet = new ArrayList<>();
        char[] chars = ALPHABET.toCharArray();
        for (char aChar : chars) {
            alphabet.add(aChar);
        }
        return alphabet;
    }
}

