package com.javarush.artemov.config;

public class AppData {
    private OperationType operation;
    private String inputFile;
    private String outputFile;
    private int key;
    private int parseBruteForceLines;


    public OperationType getOperation() {
        return operation;
    }

    public void setOperation(OperationType operation) {
        this.operation = operation;
    }

    public String getInputFile() {
        return inputFile;
    }

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public String getOutputFile() {
        return outputFile;
    }

    public void setOutputFile(String outputFile) {
        this.outputFile = outputFile;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getParseBruteForceLines() {
        return parseBruteForceLines;
    }

    public void setParseBruteForceLines(int parseBruteForceLines) {
        this.parseBruteForceLines = parseBruteForceLines;
    }
}
