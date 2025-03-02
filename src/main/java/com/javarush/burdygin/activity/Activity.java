package com.javarush.burdygin.activity;

import com.javarush.burdygin.inputOutput.CreatePath;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class Activity {

    public Activity() {
    }

    public void activity(Map<String, String> args) {

        Path sourceFilePath = CreatePath.get(args.get("sourceFile"));
        Path destinationFilePath = CreatePath.get(args.get("destinationFile"));

        int key = Integer.parseInt(args.get("key")) > 0 ? 1 : -1;

        try (BufferedReader bufferedReader = Files.newBufferedReader(sourceFilePath);
             BufferedWriter bufferedWriter = Files.newBufferedWriter(destinationFilePath)) {

            while (bufferedReader.ready()) {
                char[] readString = bufferedReader.readLine().toLowerCase().toCharArray();

                for (int i = 0; i < readString.length; i++) {
                    for (int j = 0; j < Math.abs(Integer.parseInt(args.get("key"))); j++) {

                        //for cyrillic alphabet
                        if (isCyrillic(readString[i])) {
                            readString[i] = calculate(readString[i], key, new char[]{'а', 'е', 'ж', 'я'});
                        }

                        //for latin alphabet
                        if (isLatin(readString[i])) {
                            readString[i] = calculate(readString[i], key, new char[]{'a', 'z'});
                        }

                        // for symbols
                        if (isSymbol(readString[i])) {
                            readString[i] = calculate(readString[i], key, new char[]{' ', '@'});
                        }
                    }
                }
                bufferedWriter.write(String.valueOf(readString));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private char calculate(char readString, int key, char[] chars) {
        int result;
        if (chars.length == 2 ? readString > chars[0] && readString < chars[1]
                : readString > chars[0] && readString < chars[1]
                || readString > chars[2] && readString < chars[3]) {
            result = readString + key;
        } else {
            result = charSwitch(readString, key);

        }
        return (char) result;
    }


    private boolean isSymbol(char c) {
        return c >= 32 && c <= 64;
    }

    private boolean isLatin(char c) {
        return c >= 97 && c <= 122;
    }

    private boolean isCyrillic(char c) {
        return c >= 1072 && c <= 1105;
    }

    private char charSwitch(char readString, int key) {
        if (key == 1) {
            switch (readString) {
                //for cyrillic
                case 'е' -> readString = 'ё';
                case 'ё' -> readString = 'ж';
                case 'ж' -> readString = 'з';
                case 'я' -> readString = 'а';
                case 'а' -> readString = 'б';
                //for latin
                case 'a' -> readString = 'b';
                case 'z' -> readString = 'a';
                //for symbol
                case '@' -> readString = ' ';
                case ' ' -> readString = '!';
            }
        }
        if (key == -1) {
            switch (readString) {
                //for cyrillic
                case 'ж' -> readString = 'ё';
                case 'ё' -> readString = 'е';
                case 'е' -> readString = 'д';
                case 'а' -> readString = 'я';
                case 'я' -> readString = 'ю';
                // for latin
                case 'a' -> readString = 'z';
                case 'z' -> readString = 'y';
                //for symbol
                case ' ' -> readString = '@';
                case '@' -> readString = '?';
            }
        }

        return readString;
    }

}
