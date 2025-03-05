package com.javarush.artemov.service;

import com.javarush.artemov.exception.AppException;
import com.javarush.artemov.utils.Utils;

import java.util.Map;

public class EncryptDecrypt {
    Utils utils = new Utils();

    /**
     * сдвиг символа symbol на значение key
     */
    public char process(Map<Character, Integer> symbolsMap, char[] charsArray, char symbol, int key) {
        char newChar = symbol; // если символ не найден в мапе, вернется исходный символ
        Integer currentIndex = utils.searchSymbolIndex(symbolsMap, symbol);

        if (currentIndex != null) {
            int newIndex = (currentIndex + key) % symbolsMap.size();
            if (newIndex < 0) {
                newIndex = symbolsMap.size() + newIndex;
            }
            newChar = charsArray[newIndex];
            if (Character.isUpperCase(symbol)) {
                newChar = Character.toUpperCase(newChar);
            }
        }
        return newChar;
    }
}
