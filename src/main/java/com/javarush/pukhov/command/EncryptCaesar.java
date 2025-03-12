package com.javarush.pukhov.command;

import java.util.List;

import com.javarush.pukhov.constant.Constants;
import com.javarush.pukhov.io.FileInput;
import com.javarush.pukhov.io.FileOutput;
import com.javarush.pukhov.valid.ValidatorActionCaesar;
import com.javarush.pukhov.valid.ValidatorCipherAction;

public final class EncryptCaesar extends Encrypt {

    private int key;
    FileInput fileInput;
    FileOutput fileOutput;

    @Override
    public void encrypt(List<String> parameters) {
        validator = new ValidatorActionCaesar<>(this);
        if (validator.check(parameters)) {
            getValuesFrom(validator);

            fileInput = new FileInput(src);
            fileOutput = new FileOutput(destination);

            processFileStream(fileInput, fileOutput, OptionFile.RW);
        }
    }

    @Override
    protected void getValuesFrom(ValidatorCipherAction<List<String>> validator) {
        super.getValuesFrom(validator);
        key = ((ValidatorActionCaesar<List<String>>) validator).getKey();
    }

    @Override
    public String toString() {
        return Constants.ENCRYPT;
    }

    @Override
    protected char[] processSymbols(char[] buf, int countRead) {
        ProcessorCipherCaesar cipherCaesar = new ProcessorCipherCaesar(key, ENCRYPT_MODE);
        return cipherCaesar.processSymbolsWithKey(buf, countRead);
    }

}
