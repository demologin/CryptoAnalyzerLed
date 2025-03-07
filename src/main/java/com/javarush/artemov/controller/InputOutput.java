package com.javarush.artemov.controller;

import com.javarush.artemov.config.AppData;
import com.javarush.artemov.config.OperationType;
import com.javarush.artemov.config.Symbols;
import com.javarush.artemov.entity.ResultCode;
import com.javarush.artemov.service.EncryptDecrypt;
import com.javarush.artemov.exception.AppException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class InputOutput {
    EncryptDecrypt encryptDecrypt = new EncryptDecrypt();

    public ResultCode encryptDecryptFile(AppData inputData) {
        OperationType operation = inputData.getOperation();
        String inputFilePath = inputData.getInputFile();
        String outputFilePath = inputData.getOutputFile();
        int key = calculateOperationKey(inputData.getKey(), operation);

        Path source = Path.of(inputFilePath);
        Path target = Path.of(outputFilePath);

        try (
                BufferedReader reader = Files.newBufferedReader(source);
                BufferedWriter writer = Files.newBufferedWriter(target)
        ) {
            while (reader.ready()) {
                char character = (char) reader.read();
                char newCharacter = encryptDecrypt.process(Symbols.symbolsMap, Symbols.charsArray, character, key);
                writer.append(newCharacter);
            }
        } catch (IOException e) {
            throw new AppException(e.getMessage(), e);
        }
        return ResultCode.OK;
    }

    public ResultCode bruteForse(AppData inputData) {
        String inputFilePath = inputData.getInputFile();
        Path source = Path.of(inputFilePath);
        StringBuilder sourceText = new StringBuilder();
        int numberLinesToParse = inputData.getParseBruteForceLines(); // количество строк для анализа

        try (
                BufferedReader reader = Files.newBufferedReader(source)
        ) {
            // считали n строк из файла для анализа
            for (int i = 0; i < numberLinesToParse && reader.ready(); i++) {
                sourceText.append(reader.readLine());
            }
        } catch (IOException e) {
            throw new AppException(e.getMessage(), e);
        }

        String[] result = getMultiKeyDecryptStrings(sourceText.toString());
        int[][] numberMatches = countWordMatches(result);
        int bestKey = getBestKey(numberMatches);
        inputData.setKey(bestKey);

        return encryptDecryptFile(inputData);
    }

    /**
     * возвращает массив с результатами дешифровки для каждого из i ключей
     */
    private String[] getMultiKeyDecryptStrings(String sourceText) {
        String[] result = new String[Symbols.charsArray.length];
        char[] charArrayToParse = sourceText.toCharArray();
        for (int i = 0; i < Symbols.charsArray.length; i++) {
            for (char c : charArrayToParse) {
                char newCharacter = encryptDecrypt.process(Symbols.symbolsMap, Symbols.charsArray, c, i * -1);
                result[i] = result[i] + newCharacter;
            }
        }
        return result;
    }

    /**
     * считает количество совпадений слов для каждого элемента массива дешифровки со словами эталонного массива
     */
    private static int[][] countWordMatches(String[] result) {
        int[][] numberMatches = new int[Symbols.charsArray.length][Symbols.arrayTestWords.length];
        for (int i = 0; i < result.length; i++) {
            String[] arrayWords = result[i].split("\\s+");
            for (String word : arrayWords) {
                for (int j = 0; j < Symbols.arrayTestWords.length; j++) {
                    if (word.equalsIgnoreCase(Symbols.arrayTestWords[j])) {
                        numberMatches[i][j]++;
                    }
                }
            }
        }
        return numberMatches;
    }

    /**
     * вычисляет лучший ключ по максимальному количеству совпадений слов каждого элемента массива дешифровки со словами эталонного массива
     */
    private static int getBestKey(int[][] numberMatches) {
        int maxMatches = 0;
        int bestKey = 0;
        for (int i = 0; i < numberMatches.length; i++) {
            int sum = 0;
            for (int j = 0; j < numberMatches[i].length; j++) {
                sum = sum + numberMatches[i][j];
            }
            if (maxMatches < sum) {
                maxMatches = sum;
                bestKey = i;
            }
        }
        return bestKey;
    }

    /**
     * вычисляет ключ в зависимости от режима работы - шифрование / дешифрование / brute force
     */
    public int calculateOperationKey(int inputkey, OperationType operation) {
        return switch (operation) {
            case CODE -> inputkey;
            case DECODE, BRUTE_FORCE -> inputkey * -1;
        };
    }
}
