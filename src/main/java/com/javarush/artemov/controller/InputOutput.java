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
import java.util.Arrays;

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

    public ResultCode bruteForse(AppData inputData){
        String inputFilePath = inputData.getInputFile();
        Path source = Path.of(inputFilePath);
        String sourceText = "";
        int numberLinesToParse = 20;

        try (
                BufferedReader reader = Files.newBufferedReader(source)
        ) {
            // считали n строк из файла для анализа
            for (int i = 0; i < numberLinesToParse && reader.ready(); i++) {
                sourceText = sourceText + reader.readLine();
            }

            // создали массив с результатами дешифровки с помощью Symbols.charsArray.length количеством ключей
            String[] result = new String[Symbols.charsArray.length];
            char[] charArrayToParse = sourceText.toCharArray();
            for (int i = 0; i < Symbols.charsArray.length; i++) {
                for (int j = 0; j < charArrayToParse.length; j++) {
                    char newCharacter = encryptDecrypt.process(Symbols.symbolsMap, Symbols.charsArray, charArrayToParse[j], i * -1);
                    result[i] = result[i] + newCharacter;
                }
            }

            String[] arrayTestWords = {"но", "ну", "не", "да", "от", "ты", "мы", "вы", "по", "он", "она", "они", "для", "был", "что", "нет", "как"};

            // считаем количество совпадений слов для каждой строки со словами эталонного массива
            int[][] numberMatches = new int[Symbols.charsArray.length][arrayTestWords.length];
            for (int i = 0; i < result.length; i++) {
                String[] arrayWords = result[i].split("\\s+");
                System.out.println("i = " + i + " " + Arrays.toString(arrayWords));
                for (String word : arrayWords){
                    for (int j = 0; j < arrayTestWords.length; j++) {
                        if (word.equalsIgnoreCase(arrayTestWords[j])) {
                            numberMatches[i][j]++;
                        }
                    }
                }
            }

            System.out.println(Arrays.deepToString(numberMatches));


        } catch (IOException e) {
            throw new AppException(e.getMessage(), e);
        }
        return ResultCode.OK;
    }

    /**
     * вычисление ключа в зависимости от режима работы - шифрование / дешифрование
     */
    public int calculateOperationKey (int inputkey, OperationType operation) {
        return switch(operation) {
            case CODE -> inputkey;
            case DECODE -> inputkey * -1;
            case BRUTE_FORCE -> inputkey * -1;
        };
    }
}
