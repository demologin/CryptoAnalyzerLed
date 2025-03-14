package com.javarush.burdygin.view;

interface Messages {

       // base message
       String MODE_MESSAGE = """
            Select mode:
            1 Encode
            2 Decode
            3 Brute Force
            Exit""";

       //source messages
       String SOURCE_FILE_ENCRYPT_MESSAGE = "Enter the source path or press enter for default: \"text.txt\"";
       String SOURCE_FILE_DECRYPT_MESSAGE = "Enter the source path or press enter for default: \"encrypted.txt\"";

       //destination messages
       String DESTINATION_FILE_ENCRYPT_MESSAGE = "Enter the destination path or press enter for default: \"encrypted.txt\"";
       String DESTINATION_FILE_DECRYPT_MESSAGE = "Enter the destination path or press enter for default: \"decrypted.txt\"";

       //key messages
       String ENCRYPT_KEY_MESSAGE = "Enter the key value or press enter for random key";
       String DECRYPT_KEY_MESSAGE = "Enter the key value or press enter for Brute Force";

       //default source paths
       String DEFAULT_SOURCE_FILE_ENCRYPT = "text.txt";
       String DEFAULT_SOURCE_FILE_DECRYPT = "encrypted.txt";

       //default destination paths
       String DEFAULT_DESTINATION_FILE_ENCRYPT = "encrypted.txt";
       String DEFAULT_DESTINATION_FILE_DECRYPT = "decrypted.txt";

       //application messages
       String ENCODING_MESSAGE = "encoding...";
       String DECODING_MESSAGE = "decoding...";
       String BRUTE_FORCE_MESSAGE = """
               Brute Force
               decoding...""";
       String EXIT_MESSAGE = "EXIT";
       String COMPLETE_MESSAGE = "Complete!";

       //exception messages
       String INCORRECT_MODE_MESSAGE = "Incorrect mode";
       String EMPTY_FILE_MESSAGE = "Source file is empty";
       String FILE_NOT_FOUND_MESSAGE = "File %s not found";
       String UNKNOWN_ERROR_MESSAGE = "Unknown Error";
}
