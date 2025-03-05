package com.javarush.artemov.utils;


import java.util.Map;

public class Utils {

    /**
     * поиск индекса символа в мапе Map<Character, Integer>
     */
    public Integer searchSymbolIndex(Map<Character, Integer> symbolsMap, char symbol) {
        char character = Character.toLowerCase(symbol);
        return symbolsMap.get(character);
    }
}
