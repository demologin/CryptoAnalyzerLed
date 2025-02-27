package com.javarush.kazakov.core;

import com.javarush.kazakov.constants.Constants;

public class Translator {
    private final int key;

    public Translator(int key) {
        this.key = key;
    }

    public String translate(String line) {
        StringBuilder sb = new StringBuilder();
        for (char c : line.toCharArray()) {
            char result = c;
            char target = Character.toLowerCase(c);
            if (Constants.ALPHABET_MAP.containsKey(target)) {
                int idx = (Constants.ALPHABET_MAP.get(target) - key + Math.abs(key) * Constants.ALPHABET.length)
                        % Constants.ALPHABET.length;
                result = Constants.ALPHABET[idx];
                result = Character.isLowerCase(c) || !Character.isLetter(c) ? result : Character.toUpperCase(result);
            }
            sb.append(result);
        }
        return sb.toString();
    }
}
