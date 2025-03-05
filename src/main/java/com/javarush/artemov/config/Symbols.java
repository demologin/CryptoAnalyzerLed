package com.javarush.artemov.config;

import java.util.HashMap;
import java.util.Map;

public class Symbols {
    private static final String alphabetRus = "абвгдеёжзийклмнопрстуфхцчшщьыъэюя";
    private static final String alphabetLat = "abcdefghijklmnopqrstuvwxyz";
    private static final String symbols = " ,.?!:;\"\r\n";
    private static final String numbers = "0123456789";

    public static final char[] charsArray = (alphabetRus + alphabetLat + symbols + numbers).toCharArray();

    public static final Map<Character, Integer> symbolsMap = createSymbolsMap(Symbols.charsArray );

    /**
     * Создание мапы из массива символов
     */
    public static Map<Character, Integer> createSymbolsMap(char[] charsArray) {
        Map<Character, Integer> symbolsMap = new HashMap<>();
        for (int i = 0; i < charsArray.length; i++) {
            symbolsMap.put(charsArray[i], i);
        }
        return symbolsMap;
    }
}
