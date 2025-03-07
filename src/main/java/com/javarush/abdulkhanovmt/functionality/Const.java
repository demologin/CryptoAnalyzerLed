package com.javarush.abdulkhanovmt.functionality;

import java.io.File;

public interface Const {
    String SOURCE_FILE_NAME = "text.txt";
    String ENCODED_FILE_NAME = "abdulkhanovEncoded.txt";
    String DECODED_FILE_NAME = "abdulkhanovDecoded.txt";
    String BRUTEFORCED_FILE_NAME = "abdulkhanovBruteForce.txt";
    String ANALYZE_FILE_NAME = "abdulkhanovAnalyze.txt";

    String TXT_FOLDER = System.getProperty("user.dir") +
            File.separator +
            "text" +
            File.separator;

    String NOT_FOUND_ACTION_FORMAT = "not found action: %s";
    String INCORRECT_FILE = "Incorrect file: ";
    String APPLICATION_CLOSED = "application closed";
}