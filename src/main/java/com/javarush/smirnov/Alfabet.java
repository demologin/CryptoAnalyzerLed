package com.javarush.smirnov;

import java.util.HashMap;
import java.util.Map;

public class Alfabet {
    private static final char[] alfabet = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};

    public static final int length = alfabet.length;

    public final static Map<Character, Integer> map = new HashMap<>();

    static {
        for (int i = 0; i < alfabet.length; i++) {
            map.put(alfabet[i], i);
        }
    }
}
