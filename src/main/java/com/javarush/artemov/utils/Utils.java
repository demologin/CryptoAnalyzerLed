package com.javarush.artemov.utils;

import com.javarush.artemov.config.OperationType;
import com.javarush.artemov.config.SymbolType;
import com.javarush.artemov.config.Symbols;

import java.util.Map;
import java.util.Set;

public class Utils {

    /**
     * поиск индекса символа в мапе Map<Character, Integer>
     */
    public int searchSymbolIndex(Map<Character, Integer> symbolsMap, char symbol) {
        return symbolsMap.get(symbol);
    }

    /**
     * поиск символа по индексу в мапе Map<Character, Integer>
     */
    public char searchSymvol(Map<Character, Integer> symbolsMap, int index) {
        Set<Character> symbols = symbolsMap.keySet();
        for (Character symbol : symbols) {
            if (symbolsMap.get(symbol).equals(index)) {
                return symbol;
            }
        }
        return 0; // если символ не найден
    }

    /**
     * определение типа символа
     */
    public SymbolType getSymbolType(char symbol) {
        if (Symbols.alphabetRus.indexOf(symbol) != -1) {
            return SymbolType.ALFPHABET_LOW_CASE_RUS;
        } else if (Symbols.alphabetRus.toUpperCase().indexOf(symbol) != -1) {
            return SymbolType.ALFPHABET_UPPER_CASE_RUS;
        } else if (Symbols.alphabetLat.indexOf(symbol) != -1) {
            return SymbolType.ALFPHABET_LOW_CASE_LAT;
        } else if (Symbols.alphabetLat.toUpperCase().indexOf(symbol) != -1) {
            return SymbolType.ALFPHABET_UPPER_CASE_LAT;
        } else if (Symbols.numbers.indexOf(symbol) != -1) {
            return SymbolType.NUMBERS;
        } else if (Symbols.symbols.indexOf(symbol) != -1) {
            return SymbolType.PUNCTUATION_MARKS;
        } else {
            return SymbolType.NOT_DEFINED;
        }
    }

    /**
     * вычисление ключа в зависимости от режима работы - шифрование / дешифрование
     */
    public int getKey (int inputkey, OperationType operation) {
        int key = switch(operation) {
            case CODE -> inputkey;
            case DECODE -> inputkey * -1;
        };
        return key;
    }

}
