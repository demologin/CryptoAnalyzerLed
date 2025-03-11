package com.javarush.halubkova.ui;

public class DialogDTO {
    int operation;
    String inputFilePath;
    int keyCipher;
    String outputFileName;

    public DialogDTO(int operation, String inputFilePath, int keyCipher, String outputFileName) {
        this.operation = operation;
        this.inputFilePath = inputFilePath;
        this.keyCipher = keyCipher;
        this.outputFileName = outputFileName;
    }

    public int getOperation() {
        return operation;
    }

    public String getInputFilePath() {
        return inputFilePath;
    }

    public int getKeyCipher() {
        return keyCipher;
    }

    public String getOutputFileName() {
        return outputFileName;
    }

}
