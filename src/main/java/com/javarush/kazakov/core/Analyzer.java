package com.javarush.kazakov.core;

import com.javarush.kazakov.core.exceptions.CryptoAnalyzerException;
import com.javarush.kazakov.core.files.FileManager;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import static com.javarush.kazakov.constants.Constants.ALPHABET;
import static com.javarush.kazakov.constants.Constants.ALPHABET_MAP;

/**
 * The {@code Analyzer} class attempts to decipher the cipher.
 * <p>
 * {@code Analyzer} includes public constructor
 * that accepts {@link Collector} instances of encrypted and representative files.
 * Contains methods {@code guessKey()}, {@code getKey()}, both attempt to decrypt the text, returns the decryption key.
 *
 * @see Collector
 * @see Analyzer#getKey()
 * @see Analyzer#guessKey()
 */

public class Analyzer {
    private static final char ANCHOR_CHARACTER = ' ';
    private final Collector encrypted;
    private final Collector representative;

    private final long charsToCheck;

    /**
     * Creates an object of {@code Analyzer}.
     *
     * @param encrypted      {@link Collector} instance of encrypted file
     * @param representative {@link Collector} instance of representative file
     */
    public Analyzer(Collector encrypted, Collector representative) {
        this.encrypted = encrypted;
        this.representative = representative;
        charsToCheck = countCharsToCheck();
    }

    /**
     * Attempts to decrypt the text by the <b>statistical analysis</b> strategy.
     * <p>
     * Calculates <i>sum of squared deviations</i> for each shift,
     * then finds the minimum sum and the associated shift with it.
     * Then subtracts shift value from the length of the alphabet,
     * in result calculating the decryption key.
     *
     * @return {@code int} representation of key for decryption.
     */
    public int getKey() {
        Map<Integer, Long> squaresMap = calculateDeviationSquares();
        Map.Entry<Integer, Long> min = Collections.min(squaresMap.entrySet(), Comparator.comparingLong(Map.Entry::getValue));
        return min.getKey() == 0 ? 0 : ALPHABET.length - min.getKey();
    }

    /**
     * Attempts to decrypt the text by the <b>brute force</b> strategy.
     * <p>
     * Finds character with maximum occurrences in encrypted file,
     * then finds the modulus of the deviation between this symbol and the anchor symbol.
     * This deviation will be the key.
     *
     * @return {@code int} representation of key for decryption.
     */
    public int guessKey() {
        Map<Character, Integer> encryptedOccurrenceCharMap = encrypted.getOccurrenceCharMap();
        if (encryptedOccurrenceCharMap == null || encryptedOccurrenceCharMap.isEmpty()) {
            throw new CryptoAnalyzerException("collected data is insufficient");
        }
        char maxChar = getCharWithMaxOccurrences(encryptedOccurrenceCharMap);
        return Math.abs(ALPHABET_MAP.get(maxChar) - ALPHABET_MAP.get(ANCHOR_CHARACTER));
    }

    private Map<Character, Integer> shiftEncryptedFile(int shift) {
        FileManager fmEnc = new FileManager(encrypted.getFilePath());
        fmEnc.translateFile(new Translator(shift));

        FileManager fmTemp = new FileManager(FileManager.TEMP);
        Collector tempCol = fmTemp.collectData(charsToCheck);
        return tempCol.getOccurrenceCharMap();
    }

    private Map<Integer, Long> calculateDeviationSquares() {
        Map<Character, Integer> repMap = new FileManager(representative.getFilePath()).collectData(charsToCheck).getOccurrenceCharMap();
        Map<Integer, Long> squaresMap = new HashMap<>();
        for (int i = 0; i < ALPHABET.length; i++) {
            long sum = 0;
            Map<Character, Integer> shiftedCharsMap = shiftEncryptedFile(i);
            for (char c : ALPHABET) {
                if (shiftedCharsMap.containsKey(c) && repMap.containsKey(c)) {
                    int deviation = shiftedCharsMap.get(c) - repMap.get(c);
                    long deviationSquared = (long) deviation * deviation;
                    sum += deviationSquared;
                } else {
                    if (shiftedCharsMap.containsKey(c)) {
                        sum += (int) Math.pow(shiftedCharsMap.get(c), 2);
                    }
                    if (repMap.containsKey(c)) {
                        sum += (int) Math.pow(repMap.get(c), 2);
                    }
                }
            }
            squaresMap.put(i, sum);
        }

        try {
            Files.deleteIfExists(FileManager.TEMP);
        } catch (IOException e) {
            throw new CryptoAnalyzerException("Unable to delete temp file: " + e);
        }
        return squaresMap;
    }

    private long countCharsToCheck() {
        return Math.min(encrypted.getTextLength(), representative.getTextLength());
    }

    private char getCharWithMaxOccurrences(Map<Character, Integer> map) {
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
