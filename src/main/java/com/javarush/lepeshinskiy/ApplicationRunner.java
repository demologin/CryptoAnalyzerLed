package com.javarush.lepeshinskiy;

import java.io.IOException;
import java.util.Scanner;
import static com.javarush.lepeshinskiy.AppConstants.Menu;
import static com.javarush.lepeshinskiy.AppConstants.CipherOperation;
import static com.javarush.lepeshinskiy.AppConstants.UI;

public class ApplicationRunner {
    private final Scanner scanner;
    private final Validator validator;
    private final FileManager fileManager;
    private final Cipher cipher;
    private final ConsoleUI consoleUI;

    public ApplicationRunner() {
        this.scanner = new Scanner(System.in);
        this.validator = new Validator();
        this.fileManager = new FileManager();
        this.cipher = new Cipher();
        this.consoleUI = new ConsoleUI(scanner, validator, cipher);
    }

    public void run() {
        boolean isApplicationRunning = true;

        consoleUI.showWelcomeMessage();

        while (isApplicationRunning) {
            consoleUI.displayMainMenu();
            int selectedOption = consoleUI.getMenuChoice();

            switch (selectedOption) {
                case Menu.ENCRYPT_OPTION:
                    handleCipherOperation(CipherAction.ENCRYPT);
                    break;
                case Menu.DECRYPT_OPTION:
                    handleCipherOperation(CipherAction.DECRYPT);
                    break;
                case Menu.BRUTE_FORCE_OPTION:
                    handleCipherOperation(CipherAction.BRUTE_FORCE);
                    break;
                case Menu.EXIT_OPTION:
                    isApplicationRunning = false;
                    consoleUI.showExitMessage();
                    break;
                default:
                    consoleUI.showInvalidChoiceMessage();
            }
        }
    }

    private void handleCipherOperation(CipherAction action) {
        consoleUI.showOperationStartMessage(action.getDisplayName());
        String inputFilePath = consoleUI.getValidInputFilePath();
        String outputFilePath = consoleUI.getOutputFilePath();

        try {
            // For brute force a dummy key value is passed since it's not used
            int cipherKey = (action == CipherAction.BRUTE_FORCE) ? 0 : consoleUI.getValidKey();
            fileManager.processFile(inputFilePath, outputFilePath, cipherKey, action);
            consoleUI.showSuccessMessage(action.getDisplayName(), outputFilePath);
        } catch (IOException exception) {
            consoleUI.showErrorMessage(exception.getMessage());
        }
    }
}