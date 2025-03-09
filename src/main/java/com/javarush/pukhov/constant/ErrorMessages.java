package com.javarush.pukhov.constant;

public class ErrorMessages {
    private ErrorMessages() {
    }

    public static final String FILE_NOT_FOUND = "%1$s file not exists";
    public static final String INCORRECT_PATH_FILE = "Incorrect path to file - %1$s";

    public static final String INCORRECT_MATRIX_SIZE = """
            incorrect matrix size -
            length firstMatrix = %d;
            length firstMatrix[0] = %d;
            length secondMatrix = %d;
            length secondMatrix[0] = %d""";

    public static final String LENGTH_IS_NOT_VALID = "the buffer cannot be empty and the number of characters checked must not exceed its length, buf.length = %d, countSymbols = %d";
}
