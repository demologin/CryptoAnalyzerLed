package com.javarush.pukhov.command;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import com.javarush.pukhov.io.FileInput;
import com.javarush.pukhov.io.FileOutput;
import com.javarush.pukhov.valid.ValidatorCipherAction;

public abstract class CipherAction implements Action {
    protected Path src;
    protected Path destination;
    protected ValidatorCipherAction<List<String>> validator;

    protected void processFileStream(FileInput input,
            FileOutput output, Option option) {
        try (
                BufferedReader reader = input.getReader();
                BufferedWriter writer = output.getWriter()) {
            char[] buf = new char[2048];
            int countRead;
            while ((countRead = reader.read(buf)) != -1) {
                boolean process = option == Option.R || option == Option.RW;
                char[] processedSymbols = new char[countRead];
                if (process) {
                    processedSymbols = processSymbols(buf, countRead);
                }
                if (option == Option.W || option == Option.RW) {
                    writer.write(processedSymbols, 0, countRead);
                }
            }
        } catch (IOException e) {
            throw new com.javarush.pukhov.exception.IOException(e.getMessage(), e);
        }
    }

    protected abstract char[] processSymbols(char[] buf, int countRead);


    protected void getValuesFrom(ValidatorCipherAction<List<String>> validator) {
        src = validator.getSource();
        destination = validator.getDestination();
    }

}
