package com.javarush.tomchuk.constant;

import java.util.HashMap;
import java.util.Map;

public class Alphabet {

    private Alphabet() {

    }

    private static final String RUS = "ЙЦУКЕНГШЩЗХЪФЫВАПРОЛДЖЭЯЧСМИТЬБЬЮ";
    private static final String SYMBOLS = "\n☮.,”’:-!? ";

    private static final char[] chars = (RUS + SYMBOLS).toLowerCase().toCharArray();

    public static final int MAX_INDEX = chars.length - 1;
    public static final int MIN_INDEX = 0;

    private static final Map<Character, Integer> collocation = new HashMap<>();

    static {
        for (int i = 0; i < chars.length; i++) {
            collocation.put(chars[i], i);
        }
    }

    public static int getIndex(char symbol) {
        Integer index = collocation.get(symbol);
        if (index != null) {
            return index;
        }
        return -1;
    }

    public static char getChar(int index) {
        if (MIN_INDEX <= index && index <= MAX_INDEX) {
            return chars[index];
        }
        return chars[index % (MAX_INDEX + 1)];
    }
}
