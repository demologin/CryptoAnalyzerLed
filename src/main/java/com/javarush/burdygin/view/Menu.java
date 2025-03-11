package com.javarush.burdygin.view;


import com.javarush.burdygin.alphabet.AlphabetLogic;
import com.javarush.burdygin.constant.Constants;

import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Menu {


    private final Scanner scanner;
    AlphabetLogic alphabetLogic;

    /**
     * mode flag
     * 0 Exit
     * 1 Encode
     * 2 Decode
     * 3 Brute Force
     */

    public Menu(Scanner scanner, AlphabetLogic alphabetLogic) {
        this.scanner = scanner;
        this.alphabetLogic = alphabetLogic;
    }

    //main method of class Menu
    public void getUserArguments(Map<String, String> args) {
        System.out.println("-".repeat(15));
        writeMessage(Messages.MODE_MESSAGE);
        args.put(Constants.MODE_FLAG, scanner.next());
        switch (args.get(Constants.MODE_FLAG)) {
            case Constants.MODE_ENCODE -> askEncryptParams(args);
            case Constants.MODE_DECODE, Constants.MODE_BRUTE_FORCE -> askDecryptParams(args);
            default -> {
                System.out.println("-".repeat(15));
                System.out.printf(Messages.EXIT_MESSAGE + '\n');
                args.put(Constants.MODE_FLAG, Constants.MODE_EXIT);
            }
        }
    }

    //asking decrypt params
    private void askDecryptParams(Map<String, String> args) {
        writeMessage(Messages.SOURCE_FILE_DECRYPT_MESSAGE);
        args.put(Constants.SOURCE_FILE, getDefaultFileName(Messages.DEFAULT_SOURCE_FILE_DECRYPT));
        writeMessage(Messages.DESTINATION_FILE_DECRYPT_MESSAGE);
        args.put(Constants.DESTINATION_FILE, getDefaultFileName(Messages.DEFAULT_DESTINATION_FILE_DECRYPT));
        if (args.get(Constants.MODE_FLAG).equals(Constants.MODE_DECODE)) {
            writeMessage(Messages.DECRYPT_KEY_MESSAGE);
            getDefaultKeyValue(args);
        }
    }

    //asking encrypt params
    private void askEncryptParams(Map<String, String> args) {
        writeMessage(Messages.SOURCE_FILE_ENCRYPT_MESSAGE);
        args.put(Constants.SOURCE_FILE, getDefaultFileName(Messages.DEFAULT_SOURCE_FILE_ENCRYPT));
        writeMessage(Messages.DESTINATION_FILE_ENCRYPT_MESSAGE);
        args.put(Constants.DESTINATION_FILE, getDefaultFileName(Messages.DEFAULT_DESTINATION_FILE_ENCRYPT));
        writeMessage(Messages.ENCRYPT_KEY_MESSAGE);
        getDefaultKeyValue(args);
    }

    //write message and line under
    private static void writeMessage(String message) {
        System.out.printf(message + '\n');
        System.out.println("-".repeat(15));
    }

    //set default filename if necessary
    private String getDefaultFileName(String defaultFile) {
        String typeFile = scanner.next();
        if (typeFile.isEmpty()) {
            typeFile = defaultFile;
        }
        return typeFile;
    }

    //set key value
    private void getDefaultKeyValue(Map<String, String> args) {
        args.put(Constants.KEY, scanner.next());
        if (args.get(Constants.KEY).isEmpty() && args.get(Constants.MODE_FLAG).equals(Constants.MODE_DECODE)) {
            args.put(Constants.MODE_FLAG, Constants.MODE_BRUTE_FORCE);
        } else if (args.get(Constants.KEY).isEmpty()) {
            Random random = new Random();
            String randomKey = String.valueOf(random.nextInt(1, alphabetLogic.alphabetLength()));
            args.put(Constants.KEY, randomKey);
            System.out.printf("key = %s", randomKey + '\n');
        }
    }
}
