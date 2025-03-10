package com.javarush.pukhov.constant;

public class Constants {

    private Constants() {
    }

    public static final String ENCRYPT = "Encrypt";
    public static final String DECRYPT = "Decrypt";
    public static final String BRUTE_FORCE = "Brute force";
    public static final String ANALYZE = "Analyze";
    public static final String EXIT = "Exit";

    public static final String SOURCE = "source";
    public static final String DESTINATION = "destination";
    public static final String DICTIONARY = "dictionary";
    public static final String KEY = "key";

    private static final String PATH_REPOSITORY_STRING = "/com/javarush/pukhov/repository/file";
    public static final String PATH_REPOSITORY = Constants.class.getResource(PATH_REPOSITORY_STRING).toExternalForm();

    public static final String EXIT_PROGRAM = "Exit for program";
}
