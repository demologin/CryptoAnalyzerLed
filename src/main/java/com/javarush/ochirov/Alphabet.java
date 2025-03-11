package com.javarush.ochirov;

import java.util.HashMap;
import java.util.Map;

public class Alphabet
{
    public static final Map<Character, Integer> CHAR_INDEX = new HashMap<>();
    private static final String POSSIBLE_SYMBOLS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя"
            + "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ"
            + "0123456789"
            + " .,!?:;{}()[]@#$%^&-+*/=<>\n\"\\'";
    public static final char[] CHAR_ARRAY = POSSIBLE_SYMBOLS.toCharArray();

    private Alphabet() {}

    static
    {
        for (var i = 0; i < CHAR_ARRAY.length; i++)
        {
            CHAR_INDEX.put(CHAR_ARRAY[i], i);
        }
    }
}
