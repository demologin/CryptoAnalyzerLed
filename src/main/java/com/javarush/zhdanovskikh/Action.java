package com.javarush.zhdanovskikh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Action {

    //шифровка и дешифровка
    public static void processFile(String readFile, String writeFile, int key) {
        if (Math.abs(key) > Constants.ALPHABET.length()) {
            key = key % Constants.ALPHABET.length();
        }
        try{
            Path readPath = MyPath.get(readFile);
            Path writePath = MyPath.get(writeFile);
            BufferedReader reader = Files.newBufferedReader(readPath);
            BufferedWriter writer = Files.newBufferedWriter(writePath);
            String currentLine;
            StringBuilder builder = new StringBuilder();
            while ((currentLine = reader.readLine()) != null) {
                for (int i = 0; i < currentLine.length(); i++) {
                    for (int j = 0; j < Constants.ALPHABET.length(); j++) {
                        if (currentLine.charAt(i) == Constants.ALPHABET.charAt(j)) {
                            if (key < 0){//decode
                                if (j + key < 0) {
                                    builder.append(Constants.ALPHABET.charAt(j + key + Constants.ALPHABET.length()));
                                }
                                else{
                                    builder.append(Constants.ALPHABET.charAt(j + key));
                                }
                            } else { //code
                                if (j + key < Constants.ALPHABET.length()) {
                                    builder.append(Constants.ALPHABET.charAt(j + key));
                                } else {
                                    builder.append(Constants.ALPHABET.charAt(j + key-Constants.ALPHABET.length()));
                                }
                            }
                            break;
                        } else if (key < 0 && j==Constants.ALPHABET.length()-1) {
                            int chrCode = currentLine.charAt(i);
                            String msg = String.format("Illegal character found: %d '%s'. Possible hacking attempt",  chrCode, currentLine.charAt(i) );
                            throw new RuntimeException(msg);
                        }
                    }
                }
                builder.append(System.lineSeparator());
                writer.write(builder.toString());
                builder.setLength(0);
            }
            writer.flush();
            writer.close();
        }
        catch ( IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static long countCharInFile(String encryptedFileName, int key){
        long count=0;
        char fixchar = Constants.ALPHABET.charAt((key+Constants.ALPHABET.indexOf(' '))%Constants.ALPHABET.length());
        Path readPath = MyPath.get(encryptedFileName);
        try(BufferedReader reader = Files.newBufferedReader(readPath)) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                for (int i = 0; i < currentLine.length(); i++) {
                    if (currentLine.charAt(i) == fixchar) {
                        count++;
                    }
                }
            }
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
        return count;
    }
}