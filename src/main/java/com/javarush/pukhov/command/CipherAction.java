package com.javarush.pukhov.command;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import com.javarush.pukhov.io.FileInput;
import com.javarush.pukhov.io.FileOutput;

public abstract class CipherAction<T> implements Action {
    protected T src;
    protected T destination;

    protected void processFileStream(FileInput input,
            FileOutput output, Option option) {
        try (
                BufferedReader reader = input.getReader();
                BufferedWriter writer = output.getWriter()) {
            char[] buf = new char[2048];
            int countRead;
            while ((countRead = reader.read(buf)) != -1) {
                boolean process = option == Option.R || option == Option.RW;
                if (process) {
                    processSymbols(buf, countRead);
                }
                if (option == Option.W || option == Option.RW) {
                    writer.write(buf, 0, countRead);
                }
            }
        } catch (IOException e) {
            throw new com.javarush.pukhov.exception.IOException(e.getMessage(), e);
        }
    }

    protected abstract void processSymbols(char[] buf, int countRead);

}
