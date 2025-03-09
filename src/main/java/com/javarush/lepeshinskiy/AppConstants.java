package com.javarush.lepeshinskiy;

public final class AppConstants {

    public static final class Menu {
        public static final int ENCRYPT_OPTION = 1;
        public static final int DECRYPT_OPTION = 2;
        public static final int BRUTE_FORCE_OPTION = 3;
        public static final int EXIT_OPTION = 4;
    }

    public static final class CipherOperation {
        public static final String ENCRYPTION_TYPE = "encryption";
        public static final String BRUTE_FORCE_TYPE = "brute_force";
        public static final String ENCRYPTED_TEXT = "encrypted";
        public static final String DECRYPTED_TEXT = "decrypted";
        public static final String BRUTE_FORCED_TEXT = "decrypted using brute force";
        public static final String ENCRYPTION_PROCESS = "encryption";
        public static final String DECRYPTION_PROCESS = "decryption";
        public static final String BRUTE_FORCE_PROCESS = "decryption using brute force";
        public static final int INVALID_KEY = -1;
    }

    public static final class UI {
        public static final String WELCOME_MESSAGE = "Welcome!";
        public static final String EXIT_MESSAGE = "Program terminated.";
        public static final String INVALID_CHOICE_MESSAGE = "Invalid choice. Please choose again.";
        public static final String ENTER_NUMBER_MESSAGE = "Please enter a number.";
        public static final String CHOICE_PROMPT = "Your choice: ";
        public static final String FILE_NOT_EXIST_MESSAGE = "File does not exist or is not a regular file. Try again.";
        public static final String INPUT_FILE_PROMPT = "Enter the input file path: ";
        public static final String OUTPUT_FILE_PROMPT = "Enter the output file path: ";
        public static final String KEY_RANGE_ERROR = "Key must be between 0 and ";
        public static final String TRY_AGAIN = ". Try again.";
        public static final String KEY_PROMPT_TEMPLATE = "Enter the key (from 0 to %d): ";
        public static final String SUCCESS_MESSAGE_TEMPLATE = "Text successfully %s and saved to file %s";
        public static final String ERROR_MESSAGE_TEMPLATE = "Error processing file: %s";
        public static final String OPERATION_START_TEMPLATE = "\nStarting text %s process.";
    }

    public static final class FileOperations {
        public static final String DEFAULT_CHARSET = "UTF-8";
    }
}