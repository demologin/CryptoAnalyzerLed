package com.javarush.artemov.config;

import java.util.HashMap;
import java.util.Map;

public class Symbols {
    public static final String alphabetRus = "абвгдеёжзийклмнопрстуфхцчшщьыъэюя";
    public static final String alphabetLat = "abcdefghijklmnopqrstuvwxyz";
    public static final String symbols = ",.?!:;\"\r\n";
    public static final String numbers = "0123456789";

    /**
     * Создание мапы из набора символов
     */
    public Map<Character, Integer> createSymbolsMap(String symbols) {
        char[] chars = symbols.toCharArray();
        Map<Character, Integer> symbolsMap = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            symbolsMap.put(chars[i], i);
        }
        return symbolsMap;
    }

    /**
     * определение типа символа
     */
    public SymbolType getSymbolType(char symbol) {
        char character = Character.toLowerCase(symbol);
        if (Symbols.alphabetRus.indexOf(character) != -1) {
            return SymbolType.ALPHABET_RUS;
        } else if (Symbols.alphabetLat.indexOf(character) != -1) {
            return SymbolType.ALPHABET_LAT;
        } else if (Symbols.numbers.indexOf(character) != -1) {
            return SymbolType.NUMBERS;
        } else if (Symbols.symbols.indexOf(character) != -1) {
            return SymbolType.PUNCTUATION_MARKS;
        } else {
            return SymbolType.NOT_DEFINED;
        }
    }
}
