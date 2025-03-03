package com.javarush.artemov.service;

import com.javarush.artemov.exception.AppException;
import com.javarush.artemov.utils.Utils;

import java.util.Map;

public class EncryptDecrypt {
    Utils utils = new Utils();

    /**
     * сдвиг символа symbol на значение key
     */
    public char process(Map<Character, Integer> symbolsMap, char symbol, int key) {
        int currentIndex = utils.searchSymbolIndex(symbolsMap, symbol);
        int newIndex = (currentIndex + key) % symbolsMap.size();
        char newChar = utils.searchSymvol(symbolsMap, newIndex);
        if (newChar == 0) {
            throw new AppException("Символ не найден!");
        }
        if (Character.isUpperCase(symbol)) {
            newChar = Character.toUpperCase(newChar);
        }
        return newChar;
    }
}
