package com.javarush.kazakov.core;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import static com.javarush.kazakov.constants.Constants.ALPHABET_MAP;

public class Collector {
    private long textLength;
    private final Map<Character, Integer> occurrenceCharMap;
    private final Path filePath;

    public Collector(Path filePath) {
        this.filePath = filePath;
        occurrenceCharMap = new HashMap<>();
    }

    public void collectCharsFromString(String line){
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

    public Map<Character, Integer> getOccurrenceCharMap() {
        return occurrenceCharMap;
    }
}
