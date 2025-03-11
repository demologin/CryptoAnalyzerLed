package com.javarush.ochirov;

public class StringConstantsContainer
{
    public static final String PATH_USER_DIR = "user.dir";
    public static final String PATH_TEXT = "text";

    public static final String CLI_ENCRYPT_MODE = "1. Encrypt\n";
    public static final String CLI_DECRYPT_MODE = "2. Decrypt\n";

    public static final String CLI_APP_DESCRIPTION = "This application encrypts/decrypts a text file.\n"
            + "Select the task:\n"
            + CLI_ENCRYPT_MODE
            + CLI_DECRYPT_MODE
            + "1 OR 2 OR Enter for " + CLI_ENCRYPT_MODE;

    public static final String CLI_SOURCE_PATH_DESCRIPTION = "Enter source (full path OR only filename OR Enter for text.txt) :";
    public static final String CLI_DESTINATION_PATH_DESCRIPTION = "Enter destination (full path OR only filename OR Enter for dest.txt) :";
    public static final String CLI_KEY_DESCRIPTION = "Enter key (int number OR Enter for key=0, i.e. copy) :";

    public static final String CLI_SELECTED_MODE_DESCRIPTION = "You have selected mod: ";
    public static final String CLI_SELECTED_SOURCE_PATH_DESCRIPTION = "You have selected source path: ";
    public static final String CLI_SELECTED_DEST_PATH_DESCRIPTION = "You have selected dest path: ";
    public static final String CLI_SELECTED_KEY_DESCRIPTION = "You have selected key: ";

    public static final String CLI_COMPLETED_DESCRIPTION = "Completed!";
    public static final String CLI_FAILED_DESCRIPTION = "Something went wrong...";

    public static final String INVALID_MODE_ERROR_DESCRIPTION = "ERROR!!! Invalid mode! ";
    public static final String INVALID_KEY_ERROR_DESCRIPTION = "ERROR!!! Invalid key! ";
    public static final String INVALID_PATH_ERROR_DESCRIPTION = "ERROR!!! Invalid path! ";
    public static final String ERROR_CODE = "Error code: ";

    public static final String DEFAULT_MODE_ARGUMENT = "1";
    public static final String DEFAULT_SOURCE_PATH_ARGUMENT = "text.txt";
    public static final String DEFAULT_DEST_PATH_ARGUMENT = "dest.txt";
    public static final String DEFAULT_KEY_ARGUMENT = "0";

    public static final String ENCRYPT_MODE_ARGUMENT = "1";
    public static final String DECRYPT_MODE_ARGUMENT = "2";

    private StringConstantsContainer() {}
}
