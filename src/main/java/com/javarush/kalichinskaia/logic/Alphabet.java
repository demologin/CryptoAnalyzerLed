package com.javarush.kalichinskaia.logic;

import java.util.HashMap;
import java.util.Map;

public class Alphabet {
    private Alphabet() {
    }

    public final static char[] CHARS = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з', 'и','к', 'л', 'м',
            'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э',
            'я', '.', ',', '«', '»', '"', '”', '\'', '’', ':', '-', '!', '?', ' ', 'i', 'x', 'v'};

    public final static Map<Character, Integer> INDEX_CHAR = new HashMap<>();

    static {
        for (int i = 0; i < CHARS.length; i++) {
            INDEX_CHAR.put(CHARS[i], i);
        }
    }
}
