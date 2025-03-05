package com.javarush.artemov.controller;

import com.javarush.artemov.config.AppData;
import com.javarush.artemov.config.OperationType;
import com.javarush.artemov.config.Symbols;
import com.javarush.artemov.service.EncryptDecrypt;
import com.javarush.artemov.exception.AppException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class InputOutput {
    EncryptDecrypt encryptDecrypt = new EncryptDecrypt();

    public void encryptDecryptFile(AppData inputData) {
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
    }

    /**
     * вычисление ключа в зависимости от режима работы - шифрование / дешифрование
     */
    public int calculateOperationKey (int inputkey, OperationType operation) {
        int key = switch(operation) {
            case CODE -> inputkey;
            case DECODE -> inputkey * -1;
        };
        return key;
    }
}
