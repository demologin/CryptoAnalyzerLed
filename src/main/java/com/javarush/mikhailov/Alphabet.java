package com.javarush.mikhailov;

import java.io.BufferedReader;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Alphabet {
    private static final String rus = "ЙЦУКЕНГШЩЗХЪЭЖДЛОРПАВЫФЯЧСМИТЬБЮ";
    private static final String symbols = "\n☮.,”’:-!? ";

    public Alphabet() {
    }

    public static final char[] chars = (rus.toLowerCase() + symbols).toCharArray();


Path path = Path.of("C:\\Users\\Дмитрий\\IdeaProjects\\CryptoAnalyzerLed\\text\\text.txt");
Path path1 = Path.of("C:\\Users\\Дмитрий\\IdeaProjects\\CryptoAnalyzerLed\\text\\dict.txt");

    public static final Map <Character, Integer> index = new HashMap<>();

    static {
        for (int i = 0; i < chars.length; i++) {
            index.put(chars[i], i);
        }

    }


}
