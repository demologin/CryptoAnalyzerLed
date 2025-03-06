package com.javarush.abdulkhanovmt.functionality;

import java.io.File;

public interface Const {
    String ENCODED_FILE_NAME = "abdulkhanovEncoded";
    String DECODED_FILE_NAME = "abdulkhanovDecoded";
    String BRUTEFORCED_FILE_NAME = "abdulkhanovBruteForce";
    String ANALYZE_FILE_NAME = "abdulkhanovAnalyze";

    String TXT_FOLDER = System.getProperty("user.dir") +
            File.separator +
            "text" +
            File.separator;

    String NOT_FOUND_ACTION_FORMAT = "not found action: %s";
    String INCORRECT_FILE = "Incorrect file: ";
    String APPLICATION_CLOSED = "application closed";
}