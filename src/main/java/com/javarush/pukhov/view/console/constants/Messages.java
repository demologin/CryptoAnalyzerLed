package com.javarush.pukhov.view.console.constants;

public final class Messages {


        private Messages() {
        }

        public static final String REQUEST_SELECT_MODE = "Please select mode:";
        public static final String LINE = "-".repeat(20);

        public static final String INCORRECT_NUMBER = "%1$s - not number";
        public static final String INCORRECT_INDEX = "Number must be from %2$d to %3$d. You are input - %1$s";
        public static final String INCORRECT_ACTION = "%1$s - is not an action";

        public static final String FILE_SOURCE = "text.txt";
        public static final String FILE_ENCRYPT = "encrypted.txt";
        public static final String FILE_DECRYPT = "decrypted.txt";
        public static final String FILE_BRUTEFORCE = "bruteforce.txt";
        public static final String FILE_DICTIONARY = "dict.txt";
        public static final String FILE_ANALYZE = "analyzed.txt";
        public static final String KEY = "1";
        
        private static final String INPUT_SOURCE = "Enter source (full path OR only filename OR Enter for %s) :";
        private static final String INPUT_DESTINATION = "Enter destination (full path OR only filename OR Enter for %s) :";

        public static final String INPUT_SOURCE_ENCRYPT = String
        .format(INPUT_SOURCE, FILE_SOURCE);
        public static final String INPUT_DESTINATION_ENCRYPT = String
                        .format(INPUT_DESTINATION, FILE_ENCRYPT);

        public static final String INPUT_SOURCE_DECRYPT = String.format(
                        INPUT_SOURCE,
                        FILE_ENCRYPT);

        public static final String INPUT_DESTINATION_KEY = String
                        .format(INPUT_DESTINATION, FILE_DECRYPT);

        public static final String INPUT_DESTINATION_BRUTEFORCE = String
                        .format(INPUT_DESTINATION, FILE_BRUTEFORCE);

        public static final String INPUT_DICTIONARY = String.format(
                        "Enter dictionary  (full path OR only filename OR Enter for %s) :", FILE_DICTIONARY);
        public static final String INPUT_DESTINATION_ANALYZE = String
                        .format(INPUT_DESTINATION, FILE_ANALYZE);

        public static final String INPUT_KEY = String.format("Enter key (int number OR Enter for key=%s) :", KEY);

}
