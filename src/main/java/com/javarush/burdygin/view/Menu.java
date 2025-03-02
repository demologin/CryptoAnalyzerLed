package com.javarush.burdygin.view;

import java.util.Random;
import java.util.Scanner;

import static com.javarush.burdygin.controller.Controller.*;

public class Menu {


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
    }

    //main method of class Menu
    public void mainMenu() {
        System.out.println("-".repeat(15));
        writeMessage(Messages.MODE_MESSAGE);
        args.put("modeFlag", scanner.next());
        switch (args.get("modeFlag")) {
            case "1" -> encryptParams();
            case "2", "3" -> decryptParams();
            default -> {
                System.out.println("-".repeat(15));
                System.out.printf(Messages.EXIT_MESSAGE + '\n');
                args.put("modeFlag", "0");
            }
        }

    }

    //asking decrypt params
    private void decryptParams() {
        writeMessage(Messages.SOURCE_FILE_DECRYPT_MESSAGE);
        args.put("sourceFile", defaultValue(Messages.DEFAULT_SOURCE_FILE_DECRYPT));
        writeMessage(Messages.DESTINATION_FILE_DECRYPT_MESSAGE);
        args.put("destinationFile", defaultValue(Messages.DEFAULT_DESTINATION_FILE_DECRYPT));
        writeMessage(Messages.DECRYPT_KEY_MESSAGE);
        defaultKeyValue();
    }

    //asking encrypt params
    private void encryptParams() {
        writeMessage(Messages.SOURCE_FILE_ENCRYPT_MESSAGE);
        args.put("sourceFile", defaultValue(Messages.DEFAULT_SOURCE_FILE_ENCRYPT));
        writeMessage(Messages.DESTINATION_FILE_ENCRYPT_MESSAGE);
        args.put("destinationFile", defaultValue(Messages.DEFAULT_DESTINATION_FILE_ENCRYPT));
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
        args.put("key", scanner.next());
        if (args.get("key").isEmpty() && args.get("modeFlag").equals("2")) {
            args.put("modeFlag", "3");
        } else if (args.get("key").isEmpty()) {
            Random random = new Random();
            String randomKey = String.valueOf(random.nextInt(10));
            args.put("key", randomKey);
            System.out.printf("key = %s", randomKey + '\n');
        }
    }
}
