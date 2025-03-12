package com.javarush.pukhov.statistic;

import java.util.Map;

import com.javarush.pukhov.constant.ErrorMessages;
import com.javarush.pukhov.exception.StatisticException;

public class Statistic {

    private final double[][] matrix;
    private final Map<Character, Integer> alphabet;
    private int pairCount;
    private char lastSymbol;

    public Statistic(Map<Character, Integer> alphabet) {
        int length = alphabet.size();
        matrix = new double[length][length];
        this.alphabet = alphabet;
    }

    public void fillMatrixStatistics(char[] buf, int countRead) {
        if (alphabet == null) {
            throw new StatisticException(ErrorMessages.NO_ALPHABET);
        }
        if (buf.length == 0 || countRead > buf.length) {
            String message = String.format(ErrorMessages.LENGTH_IS_NOT_VALID, buf.length, countRead);
            throw new StatisticException(new IndexOutOfBoundsException(message));
        }
        char prefix = lastSymbol != Character.MIN_VALUE ? lastSymbol : Character.MIN_VALUE;
        for (int i = 0; i < countRead; i++) {
            Integer indexPrefix = alphabet.get(prefix);
            Integer indexCurrent = alphabet.get(buf[i]);
            if (indexPrefix != null && indexCurrent != null) {
                matrix[indexPrefix][indexCurrent]++;
                pairCount++;
            }
            prefix = buf[i];
        }
        lastSymbol = prefix;
    }

    public double[][] getStatisticsMatrix() {
        calculateStatistics();
        return matrix;
    }

    private void calculateStatistics() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] /= pairCount;
            }
        }
    }

}
