package com.javarush.burkhanova;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Validator {

    public boolean isValidKey(int key, char[] alphabet) {

        try {
            if (key <= 0) {
                throw new IllegalArgumentException("Key must be greater than zero");
            }
            if (key > alphabet.length) {
                throw new IllegalArgumentException("Key must be smaller than alphabet length");
            }

            return true;

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid key: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Unexpected exception: " + e.getMessage());
            return false;
        }

    }

    public boolean isFileExists(String filePath, boolean canCreate) {
        try {
            Path path = Path.of(filePath);
            if (!Files.exists(path)) {
                if (canCreate){
                    Files.createDirectories(path.getParent());
                    Files.createFile(path);
                    System.out.println("File created: " + filePath);
                    return true;
                } else {
                    throw new IOException("File does not exist, and creation is not allowed");
                }

            }
            if (!Files.isReadable(path)) {
                throw new AccessDeniedException("Access denied to file: " + filePath);
            }
            if (!Files.isRegularFile(path)) {
                throw new FileNotFoundException("Please select a file, not a directory: " + filePath);
            }

            return true;
        } catch (AccessDeniedException e) {
            System.out.println("Access denied: " + e.getMessage());
            return false;
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
            return false;
        } catch (IOException e) {
            System.err.println(" File error: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Unexpected exception: " + e.getMessage());
            return false;
        } catch (Error e) {
            System.err.println("Error:" + e.getMessage());
            return false;
        }

    }


    // For Brute Force method validation
    // Checking, if word is existed in dictionary
    public static boolean isValidWord(String word) {
        Set<String> dictonary = Set.of("ну", "она", "в", "на", "он", "это", "есть", "был", "была", "были",
                "дом", "работа", "машина", "человек", "город", "страна", "день", "ночь");
        return dictonary.contains(word.toLowerCase());
    }



    // Count valid words
    public static int countValidWords(String text) {
        String[] words = text.split("\\s+");
        int validWords = 0;
        for (String word : words) {
            if (isValidWord(word)) {
                validWords++;
            }

        }
        return validWords;

    }


}


