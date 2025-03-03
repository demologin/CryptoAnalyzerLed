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
        char character = Character.toLowerCase(symbol);
        return symbolsMap.get(character);
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
