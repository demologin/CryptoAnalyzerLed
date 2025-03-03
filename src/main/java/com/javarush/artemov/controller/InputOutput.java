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
    EncryptDecrypt encryptDecrypt = new EncryptDecrypt();
    Symbols symbols = new Symbols();

    Map<Character, Integer> rusSymbolMap = symbols.createSymbolsMap(Symbols.alphabetRus);
    Map<Character, Integer> latSymbolMap = symbols.createSymbolsMap(Symbols.alphabetLat);
    Map<Character, Integer> punctuationMarksMap = symbols.createSymbolsMap(Symbols.symbols);
    Map<Character, Integer> numbersMap = symbols.createSymbolsMap(Symbols.numbers);


    public void encryptDecryptFile(AppData inputData) {
        OperationType operation = inputData.getOperation();
        String inputFilePath = inputData.getInputFile();
        String outputFilePath = inputData.getOutputFile();
        int key = inputData.getKey();

        Path source = Path.of(inputFilePath);
        Path target = Path.of(outputFilePath);
        try (
                BufferedReader reader = Files.newBufferedReader(source);
                BufferedWriter writer = Files.newBufferedWriter(target)
        ) {
            while (reader.ready()) {
                char character = (char) reader.read();
                SymbolType symbolType = symbols.getSymbolType(character);
                char newCharacter = switch (symbolType) {
                    case ALPHABET_RUS -> encryptDecrypt.process(rusSymbolMap, character, key);
                    case ALPHABET_LAT -> encryptDecrypt.process(latSymbolMap, character, key);
                    case NUMBERS -> encryptDecrypt.process(numbersMap, character, key);
                    case PUNCTUATION_MARKS -> encryptDecrypt.process(punctuationMarksMap, character, key);
                    case NOT_DEFINED -> throw new AppException("Тип символа не определен!");
                };

                writer.append(newCharacter);
            }
        } catch (IOException e) {
            throw new AppException(e.getMessage(), e);
        }
    }
}
