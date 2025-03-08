package com.javarush.mikhailov;

import java.util.HashMap;
import java.util.Map;

public class Alphabet {
    private static final String rus = "ЙЦУКЕНГШЩЗХЪЭЖДЛОРПАВЫФЯЧСМИТЬБЮ";
    private static final String symbols = "\n☮.,”’:-!? ";

    public Alphabet() {
    }

    public static final char[] chars = (rus.toLowerCase() + symbols).toCharArray();


    String string = "C:\\Users\\Дмитрий\\IdeaProjects\\CryptoAnalyzerLed\\text\\text.txt";
    String getString = "hello";   // тестировал!!!
    public static final Map <Character, Integer> index = new HashMap<>();

    static {
        for (int i = 0; i < chars.length; i++) {
            index.put(chars[i], i);
        }

    }


}
