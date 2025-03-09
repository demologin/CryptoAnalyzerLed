package com.javarush.tomchuk.constant;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.abs;

public class Alphabet {

    private Alphabet() {

    }

    private static final String RUS = "ЙЦУКЕНГШЩЗХЪФЫВАПРОЛДЖЭЯЧСМИТЬБЮ";
    private static final String SYMBOLS = "\n☮.,”’:-!? ";

    private static final char[] charsLower = (RUS + SYMBOLS).toLowerCase().toCharArray();
    private static final char[] charsUp = (RUS + SYMBOLS).toCharArray();

    public static final int MAX_INDEX = charsLower.length - 1;
    public static final int MIN_INDEX = 0;

    private static final Map<Character, Integer> collocation = new HashMap<>();

    static {
        for (int i = 0; i < charsLower.length; i++) {
            collocation.put(charsLower[i], i);
            collocation.put(charsUp[i], i);
        }
    }

    public static int getIndex(char symbol) {
        Integer index = collocation.get(symbol);
        if (index != null) {
            return index;
        }
        return -1;
    }

    public static char getCharMinus(int currentIndex, int minusIndex) {
        if ((MIN_INDEX <= currentIndex - minusIndex) && (currentIndex - minusIndex <= MAX_INDEX)) {
            return charsLower[currentIndex - minusIndex];
        }
        return charsLower[(MAX_INDEX + 1) - abs(currentIndex - (abs(minusIndex) % (MAX_INDEX + 1)))];

    }

    public static char getCharPlus(int currentIndex, int plusIndex) {
        if ((MIN_INDEX <= currentIndex + plusIndex) && (currentIndex + plusIndex <= MAX_INDEX)) {
            return charsLower[currentIndex + plusIndex];
        }
        return charsLower[(currentIndex + plusIndex) % (MAX_INDEX + 1)];
    }
}
