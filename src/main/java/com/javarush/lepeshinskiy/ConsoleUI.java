package com.javarush.lepeshinskiy;

import java.util.Scanner;
import static com.javarush.lepeshinskiy.AppConstants.CipherOperation;
import static com.javarush.lepeshinskiy.AppConstants.UI;

public class ConsoleUI {
    private final Scanner scanner;
    private final Validator validator;
    private final Cipher cipher;

    public ConsoleUI(Scanner scanner, Validator validator, Cipher cipher) {
        this.scanner = scanner;
        this.validator = validator;
        this.cipher = cipher;
    }

    public void displayMainMenu() {
        System.out.println("\nSelect action:");
        System.out.println("1. Encrypt text");
        System.out.println("2. Decrypt text");
        System.out.println("3. Decrypt text using brute force");
        System.out.println("4. Exit program");
        System.out.print(UI.CHOICE_PROMPT);
    }

    public int getMenuChoice() {
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println(UI.ENTER_NUMBER_MESSAGE);
                System.out.print(UI.CHOICE_PROMPT);
            }
        }
    }

    public String getValidInputFilePath() {
        String inputFilePath;
        do {
            System.out.print(UI.INPUT_FILE_PROMPT);
            inputFilePath = scanner.nextLine();

            if (!validator.isFileExists(inputFilePath)) {
                System.out.println(UI.FILE_NOT_EXIST_MESSAGE);
            }
        } while (!validator.isFileExists(inputFilePath));

        return inputFilePath;
    }

    public String getOutputFilePath() {
        System.out.print(UI.OUTPUT_FILE_PROMPT);
        return scanner.nextLine();
    }

    public int getValidKey() {
        int cipherKey;
        int alphabetSize = cipher.getAlphabetSize();

        do {
            System.out.printf(UI.KEY_PROMPT_TEMPLATE, alphabetSize - 1);
            try {
                String input = scanner.nextLine().trim();
                cipherKey = Integer.parseInt(input);
                if (!validator.isKeyValid(cipherKey, alphabetSize)) {
                    System.out.println(UI.KEY_RANGE_ERROR + (alphabetSize - 1) + UI.TRY_AGAIN);
                }
            } catch (NumberFormatException e) {
                System.out.println(UI.ENTER_NUMBER_MESSAGE);
                cipherKey = CipherOperation.INVALID_KEY;
            }
        } while (!validator.isKeyValid(cipherKey, alphabetSize));

        return cipherKey;
    }

    public void showWelcomeMessage() {
        System.out.println(UI.WELCOME_MESSAGE);
    }

    public void showExitMessage() {
        System.out.println(UI.EXIT_MESSAGE);
    }

    public void showInvalidChoiceMessage() {
        System.out.println(UI.INVALID_CHOICE_MESSAGE);
    }

    public void showSuccessMessage(String operationType, String outputFilePath) {
        String operationName;
        if (operationType.equals(CipherOperation.ENCRYPTION_TYPE)) {
            operationName = CipherOperation.ENCRYPTED_TEXT;
        } else if (operationType.equals(CipherOperation.BRUTE_FORCE_TYPE)) {
            operationName = CipherOperation.BRUTE_FORCED_TEXT;
        } else {
            operationName = CipherOperation.DECRYPTED_TEXT;
        }
        System.out.printf(UI.SUCCESS_MESSAGE_TEMPLATE, operationName, outputFilePath);
        System.out.println();
    }

    public void showErrorMessage(String errorMessage) {
        System.out.printf(UI.ERROR_MESSAGE_TEMPLATE, errorMessage);
        System.out.println();
    }

    public void showOperationStartMessage(String operationType) {
        String operationName;
        if (operationType.equals(CipherOperation.ENCRYPTION_TYPE)) {
            operationName = CipherOperation.ENCRYPTION_PROCESS;
        } else if (operationType.equals(CipherOperation.BRUTE_FORCE_TYPE)) {
            operationName = CipherOperation.BRUTE_FORCE_PROCESS;
        } else {
            operationName = CipherOperation.DECRYPTION_PROCESS;
        }
        System.out.printf(UI.OPERATION_START_TEMPLATE, operationName);
        System.out.println();
    }
}