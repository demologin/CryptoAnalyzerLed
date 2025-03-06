package com.javarush.pukhov.command;

import java.nio.file.Path;
import java.util.List;

import com.javarush.pukhov.constant.Constants;
import com.javarush.pukhov.io.FileInput;
import com.javarush.pukhov.io.FileOutput;
import com.javarush.pukhov.valid.ValidatorActionCaesar;

public final class EncryptCaesar extends Encrypt<Path> {

    private int key;
    FileInput fileInput;
    FileOutput fileOutput;

    @Override
    public void encrypt(List<String> parameters) {
        ValidatorActionCaesar<List<String>> validator = new ValidatorActionCaesar<>(this);
        if (validator.check(parameters)) {
            getValuesFrom(validator);

            fileInput = new FileInput(src);
            fileOutput = new FileOutput(destination);

            processFileStream(fileInput, fileOutput, Option.RW);
        }

    }

    private void getValuesFrom(ValidatorActionCaesar<List<String>> validator) {
        src = validator.getSource();
        destination = validator.getDestination();
        key = validator.getKey();
    }

    @Override
    public String toString() {
        return Constants.ENCRYPT;
    }

    @Override
    protected void processSymbols(char[] buf, int countRead) {
        ProcessorCipherCaesar cipherCaesar = new ProcessorCipherCaesar(key, ENCRYPT_MODE);
        cipherCaesar.processSymbolsWithKey(buf, countRead);
    }

}
