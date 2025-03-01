package com.javarush.burdygin.view;

import java.util.Random;
import java.util.Scanner;

public class Menu {
    public static int modeFlag;
    public static String sourceFile;
    public static String destinationFile;
    public static String key;
    private final Scanner scanner;

    /**
     * mode flag
     * 0 Exit
     * 1 Encode
     * 2 Decode
     * 3 Brut Force
     */

    public Menu(Scanner scanner) {
        this.scanner = scanner;
        menu();
    }

    //main method of class Menu
    public void menu() {
        System.out.println("-".repeat(15));
        System.out.printf(Messages.MODE_MESSAGE + '\n');
        System.out.println("-".repeat(15));
        modeFlag = scanner.nextInt();
        if (modeFlag == 0) {
            System.out.println("-".repeat(15));
            System.out.printf(Messages.EXIT_MESSAGE + '\n');
        } else if (modeFlag == 1) {
            encryptParams();
        } else if (modeFlag == 2 || modeFlag == 3) {
            decryptParams();
        }

        System.out.println("source " + sourceFile + " dest " + destinationFile + " key " + key + " flag " + modeFlag);
    }

    //asking decrypt params
    private void decryptParams() {
        writeMessage(Messages.SOURCE_FILE_DECRYPT_MESSAGE);
        sourceFile = defaultValue(Messages.DEFAULT_SOURCE_FILE_DECRYPT);
        writeMessage(Messages.DESTINATION_FILE_DECRYPT_MESSAGE);
        destinationFile = defaultValue(Messages.DEFAULT_DESTINATION_FILE_DECRYPT);
        writeMessage(Messages.DECRYPT_KEY_MESSAGE);
        defaultKeyValue();
    }

    //asking encrypt params
    private void encryptParams() {
        writeMessage(Messages.SOURCE_FILE_ENCRYPT_MESSAGE);
        sourceFile = defaultValue(Messages.DEFAULT_SOURCE_FILE_ENCRYPT);
        writeMessage(Messages.DESTINATION_FILE_ENCRYPT_MESSAGE);
        destinationFile = defaultValue(Messages.DEFAULT_DESTINATION_FILE_ENCRYPT);
        writeMessage(Messages.ENCRYPT_KEY_MESSAGE);
        defaultKeyValue();
    }

    //write message and line under
    private static void writeMessage(String message) {
        System.out.printf(message + '\n');
        System.out.println("-".repeat(15));
    }

    //set default filename if necessary
    private String defaultValue(String defaultFile) {
        String typeFile = scanner.next();
        if (typeFile.isEmpty()) {
            typeFile = defaultFile;
        }
        return typeFile;
    }

    //set key value
    private void defaultKeyValue() {
        key = scanner.next();
        if (key.isEmpty() && modeFlag == 2) {
            modeFlag = 3;
        } else if (key.isEmpty()) {
            Random random = new Random();
            key = String.valueOf(random.nextInt(10));
        }
    }
}
