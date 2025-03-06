package com.javarush.pukhov.constant;

import java.util.HashMap;
import java.util.Map;

public class AlphabetCaesar {

    private AlphabetCaesar() {
    }

    private static final String RUS_SYMBOLS = "йцукенгшщзхъфывапролджэячсмитьбюё";
    private static final String PUNCTUATIONS = "\n”’:-!;*.,/\\?\"";

    private static final char[] chars = (RUS_SYMBOLS + RUS_SYMBOLS.toUpperCase() + PUNCTUATIONS).toCharArray();

    private static final Map<Character, Integer> alphabet = new HashMap<>();


    static {
        for (int i = 0; i < chars.length; i++) {
            alphabet.put(chars[i], i);
        }
    }

    public static Map<Character, Integer> getAlphabet() {
        Object clone = ((HashMap<Character, Integer>) alphabet).clone();
        return (Map<Character, Integer>) clone;
    }

    public static char getSymbol(int index) {
        return chars[index];
    }

}
