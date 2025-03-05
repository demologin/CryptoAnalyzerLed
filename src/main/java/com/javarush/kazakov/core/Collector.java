package com.javarush.kazakov.core;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import static com.javarush.kazakov.constants.Constants.ALPHABET_MAP;

/**
 * The {@code Collector} class collects the number of occurrences of each letter specified in the alphabet.
 * <p>
 * {@code Collector} includes public constructor that accepts path to the file,
 * in which the occurrences of chars will be counted
 * and the {@code collectCharsFromString(String line)} method,
 * which accumulates the number of occurrences and the length of a text file in characters.
 *
 * @see Collector#collectCharsFromString(String)
 */
public class Collector {
    private long textLength;
    /**
     * Map that storing the number of occurrences of each letter defined in the alphabet.
     */
    private final Map<Character, Integer> occurrenceCharMap;
    private final Path filePath;

    /**
     * Creates an object of {@code Collector}.
     *
     * @param filePath File path
     */
    public Collector(Path filePath) {
        this.filePath = filePath;
        occurrenceCharMap = new HashMap<>();
    }

    /**
     * Accumulates the number of occurrences of characters in {@code line} to {@code Map<Character, Integer>}
     * and the length of a text file in characters.
     *
     * @param line {@code String} line in which counts the number of each of the characters.
     * @apiNote you can get {@code Map} using {@code getOccurrenceCharMap()}
     */
    public void collectCharsFromString(String line) {
        for (char c : line.toCharArray()) {
            char lower = Character.toLowerCase(c);
            textLength++;
            if (ALPHABET_MAP.containsKey(lower)) {
                occurrenceCharMap.put(lower, occurrenceCharMap.getOrDefault(lower, 0) + 1);
            }
        }
    }

    public Path getFilePath() {
        return filePath;
    }

    public long getTextLength() {
        return textLength;
    }

    /**
     * Returns map that storing the number of occurrences of each letter defined in the alphabet.
     *
     * @return {@code Map<Character, Integer>} occurrenceCharMap
     */
    public Map<Character, Integer> getOccurrenceCharMap() {
        return occurrenceCharMap;
    }
}
