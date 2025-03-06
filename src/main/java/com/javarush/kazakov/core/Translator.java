package com.javarush.kazakov.core;

import com.javarush.kazakov.constants.Constants;

/**
 * The {@code Translator} class encapsulates a shift algorithm based on some key.
 * <p>
 * {@code Translator} includes public constructor that accepts the key value
 * by which to shift the symbol relative to the alphabet,
 * and the {@code translate(String)} method,
 * which applies the Caesar encryption algorithm to the input string, returning the shifted string.
 *
 * @see Translator#translate(String)
 */
public class Translator {
    private final int key;

    /**
     * Creates an object of {@code Translator}.
     *
     * @param key Shift key
     */
    public Translator(int key) {
        this.key = key;
    }

    /**
     * Shifts each character to the key position specified when {@code Translator} was created,
     * and returns a representation of shifted string.
     *
     * @param line {@code String} line which shifts
     * @return Representation of shifted {@code String}
     */
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
