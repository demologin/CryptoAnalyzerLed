package com.javarush.pukhov.constant;

import java.util.HashMap;
import java.util.Map;

public class AlphabetCaesar {

    private AlphabetCaesar() {
    }

    private static final String RUS_SYMBOLS = "йцукенгшщзхъфывапролджэячсмитьбюё";
    private static final String PUNCTUATIONS = "”’:-!;*.,/\\?\" " + System.lineSeparator();

    private static final char[] charsArray = (RUS_SYMBOLS + RUS_SYMBOLS.toUpperCase() + PUNCTUATIONS).toCharArray();

    private static final Map<Character, Integer> alphabet = new HashMap<>();


    static {
        for (int i = 0; i < charsArray.length; i++) {
            alphabet.put(charsArray[i], i);
        }
    }

    public static Map<Character, Integer> getAlphabet() {
        Object clone = ((HashMap<Character, Integer>) alphabet).clone();
        return (Map<Character, Integer>) clone;
    }

    public static char getSymbol(int index) {
        return charsArray[index];
    }

    public static char[] getChars(){
        return charsArray;
    }

}
