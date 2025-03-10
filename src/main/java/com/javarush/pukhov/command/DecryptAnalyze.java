package com.javarush.pukhov.command;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.javarush.pukhov.constant.Constants;
import com.javarush.pukhov.io.FileInput;
import com.javarush.pukhov.io.FileOutput;
import com.javarush.pukhov.statistic.Statistic;
import com.javarush.pukhov.util.Statistics;
import com.javarush.pukhov.valid.ValidatorAnalyzeAction;
import com.javarush.pukhov.valid.ValidatorCipherAction;

public final class DecryptAnalyze extends Decrypt {

    private static final int COUNT_TRY_FIND = 10;

    private FileInput fileDictionary;
    private FileInput fileInput;
    private FileOutput fileOutput;

    private boolean isReadFile;

    private Path dictionary;

    private Statistic statistic;
    private double[][] statisticsMatrixDictionaries;
    private double[][] statisticsMatrixEncryptFiles;

    private List<Character> bestEncryptedAlphabet;

    private Map<Character, Integer> alphabet = new HashMap<>();

    Character[] charsAlphabet;
    private boolean isAlphabetFilled;
    private int lastIndexAlphabet;

    @Override
    public void decrypt(List<String> parameters) {
        validator = new ValidatorAnalyzeAction<>(this);
        if (validator.check(parameters)) {
            getValuesFrom(validator);

            fileDictionary = new FileInput(dictionary);
            fileInput = new FileInput(src);
            fileOutput = new FileOutput(destination);

            fillAlphabet();

            statisticsMatrixDictionaries = getStatisticsMatrix(fileDictionary);
            statisticsMatrixEncryptFiles = getStatisticsMatrix(fileInput);

            decryptAnalyze(statisticsMatrixEncryptFiles, statisticsMatrixDictionaries);
        }
    }

    private void fillAlphabet() {
        processFileStream(fileDictionary, fileOutput, Option.R);
        charsAlphabet = alphabet.keySet().toArray(new Character[0]);
        isAlphabetFilled = true;
    }

    private double[][] getStatisticsMatrix(FileInput fileInput) {
        statistic = getInstance();
        readFile(fileInput);
        return statistic.getStatisticsMatrix();
    }

    private Statistic getInstance() {
        return new Statistic(alphabet);
    }

    private void readFile(FileInput fileInput) {
        isReadFile = true;
        processFileStream(fileInput, fileOutput, Option.R);
        isReadFile = false;
    }

    @Override
    protected char[] processSymbols(char[] buf, int countRead) {
        if (!isAlphabetFilled) {
            for (int i = 0; i < countRead; i++) {
                Integer index = alphabet.putIfAbsent(buf[i], lastIndexAlphabet);
                if (index == null) {
                    lastIndexAlphabet++;
                }
            }
        } else if (isReadFile) {
            statistic.fillMatrixStatistics(buf, countRead);
        } else {
            for (int i = 0; i < countRead; i++) {
                int index = bestEncryptedAlphabet.indexOf(buf[i]);
                if (index != -1) {
                    buf[i] = charsAlphabet[index];
                }
            }
        }
        return buf;
    }

    private void decryptAnalyze(double[][] firstMatrix, double[][] secondMatrix) {
        findBestAlphabet(firstMatrix, secondMatrix);
        processFileStream(fileInput, fileOutput, Option.RW);
    }

    private void findBestAlphabet(double[][] sourceMatrix, double[][] original) {
        double bestDistance = Double.MAX_VALUE;
        Character[] bestChars = null;
        for (int i = COUNT_TRY_FIND; i > 0; i--) {
            Character[] chars = charsAlphabet.clone();
            double probeDistance = Statistics.findBestDistanceWithArraySwaps(chars, sourceMatrix, original);
            if (probeDistance < bestDistance) {
                i += COUNT_TRY_FIND;
                bestDistance = probeDistance;
                bestChars = chars.clone();
                // For debug only, here System.out.println - not the best solution. Here need
                // the logger
                System.out.println("Best distance = " + bestDistance);
            }
        }
        bestEncryptedAlphabet = Arrays.asList(bestChars);
    }

    private static List<Character> getCharacterList(char[] chars) {
        return String.valueOf(chars)
                .chars()
                .mapToObj(c -> (char) c)
                .toList();
    }

    @Override
    protected void getValuesFrom(ValidatorCipherAction<List<String>> validator) {
        super.getValuesFrom(validator);
        dictionary = ((ValidatorAnalyzeAction<List<String>>) validator).getDictionary();
    }

    @Override
    public String toString() {
        return Constants.ANALYZE;
    }

}
