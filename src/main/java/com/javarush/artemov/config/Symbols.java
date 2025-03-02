package com.javarush.artemov.config;

import java.util.HashMap;
import java.util.Map;

public class Symbols {
    public static final String alphabetRus = "абвгдеёжзийклмнопрстуфхцчшщьыъэюя";
    public static final String alphabetLat = "abcdefghijklmnopqrstuvwxyz";
    public static final String symbols = ",.?!:;\"\r\n";
    public static final String numbers = "0123456789";

    public Map<Character, Integer> createSymbolsMap(String symbols) {
        char[] chars = symbols.toCharArray();
        Map<Character, Integer> symbolsMap = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            symbolsMap.put(chars[i], i);
        }
        return symbolsMap;
    }
}
