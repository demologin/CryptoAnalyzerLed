package com.javarush.pukhov.constant;

import java.util.HashMap;
import java.util.Map;

public class AlphabetCaesar {

    private AlphabetCaesar() {
    }

    private static final String RUS_SYMBOLS = "йцукенгшщзхъфывапролджэячсмитьбюё";
    private static final String PUNCTUATIONS = "\n”’:-!;*.,/\\?\"";

    public static final char[] chars = (RUS_SYMBOLS + RUS_SYMBOLS.toUpperCase() + PUNCTUATIONS).toCharArray();

    public static final Map<Character, Integer> alphabet = new HashMap<>();


    static {
        for (int i = 0; i < chars.length; i++) {
            alphabet.put(chars[i], i);
        }
    }

}
