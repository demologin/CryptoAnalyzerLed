package com.javarush.pukhov.constant;

public class Constants {

    private Constants() {
    }

    public static final String ENCRYPT = "Encrypt";
    public static final String DECRYPT = "Decrypt";
    public static final String BRUTE_FORCE = "Brute force";
    public static final String ANALYZE = "Analyze";
    public static final String EXIT = "Exit";

    public static final String FILE_NOT_FOUND = "%1$s file not exists";
    public static final String INCORRECT_PATH_FILE = "Incorrect path to file - %1$s";

    private static final String PATH_REPOSITORY_STRING = "/com/javarush/pukhov/repository/file";
    public static final String PATH_REPOSITORY = Constants.class.getResource(PATH_REPOSITORY_STRING).toExternalForm();

    public static final String EXIT_PROGRAM = "Exit for program";
}
