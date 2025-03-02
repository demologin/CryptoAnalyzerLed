package com.javarush.artemov.controller;

import com.javarush.artemov.config.AppData;
import com.javarush.artemov.config.OperationType;
import com.javarush.artemov.config.SymbolType;
import com.javarush.artemov.config.Symbols;
import com.javarush.artemov.service.EncryptDecrypt;
import com.javarush.artemov.utils.Utils;
import com.javarush.artemov.exception.AppException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class InputOutput {
    Utils utils = new Utils();
    EncryptDecrypt encryptDecrypt = new EncryptDecrypt();
    Symbols symbols = new Symbols();


    public void encryptDecryptFile(AppData inputData) {
        OperationType operation = inputData.getOperation();
        String inputFilePath = inputData.getInputFile();
        String outputFilePath = inputData.getOutputFile();
        int key = inputData.getKey();

        Map<Character, Integer> rusSymbolMapLowCase = symbols.createSymbolsMap(Symbols.alphabetRus);
        Map<Character, Integer> rusSymbolMapUpperCase = symbols.createSymbolsMap(Symbols.alphabetRus.toUpperCase());
        Map<Character, Integer> latSymbolMapLowCase = symbols.createSymbolsMap(Symbols.alphabetLat);
        Map<Character, Integer> latSymbolMapUpperCase = symbols.createSymbolsMap(Symbols.alphabetLat.toUpperCase());
        Map<Character, Integer> symbolsMap = symbols.createSymbolsMap(Symbols.symbols);
        Map<Character, Integer> numbersMap = symbols.createSymbolsMap(Symbols.numbers);

        Path source = Path.of(inputFilePath);
        Path target = Path.of(outputFilePath);
        try (
                BufferedReader reader = Files.newBufferedReader(source);
                BufferedWriter writer = Files.newBufferedWriter(target)
        ) {
            while (reader.ready()) {
                char character = (char) reader.read();
                SymbolType symbolType = utils.getSymbolType(character);
                char newCharacter = switch (symbolType) {
                    case ALFPHABET_UPPER_CASE_RUS -> encryptDecrypt.process(rusSymbolMapUpperCase, character, key);
                    case ALFPHABET_LOW_CASE_RUS -> encryptDecrypt.process(rusSymbolMapLowCase, character, key);
                    case ALFPHABET_UPPER_CASE_LAT -> encryptDecrypt.process(latSymbolMapUpperCase, character, key);
                    case ALFPHABET_LOW_CASE_LAT -> encryptDecrypt.process(latSymbolMapLowCase, character, key);
                    case NUMBERS -> encryptDecrypt.process(numbersMap, character, key);
                    case PUNCTUATION_MARKS -> encryptDecrypt.process(symbolsMap, character, key);
                    case NOT_DEFINED -> throw new AppException("Тип символа не определен!");
                };

                writer.append(newCharacter);
            }
        } catch (IOException e) {
            throw new AppException(e.getMessage(), e);
        }
    }
}
