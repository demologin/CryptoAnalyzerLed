package com.javarush.burdygin.activity;

import com.javarush.burdygin.constant.Alphabet;
import com.javarush.burdygin.constant.AlphabetLogic;
import com.javarush.burdygin.inputOutput.CreatePath;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class BruteForce {

    public BruteForce() {
    }

    int spaceCounter;
    char spaceChar;

    static {
        System.out.println("""
                Brute Force
                decoding...""");
    }

    public void start(Map<String, String> args, Activity activity) {

        int key = 0;
        AlphabetLogic alphabetLogic = new AlphabetLogic();
        Path sourceFilePath = CreatePath.get(args.get("sourceFile"));
        repeater(Alphabet.SPACE, Alphabet.COMMERCIAL_AT, sourceFilePath);
        repeater(Alphabet.A_LAT, Alphabet.Z_LAT, sourceFilePath);
        repeater(Alphabet.A_CYR, Alphabet.YA_CYR, sourceFilePath);
        repeater(Alphabet.NEW_STRING, sourceFilePath);
        repeater(Alphabet.CARRIAGE_RETURN, sourceFilePath);
        repeater(Alphabet.YO_CYR, sourceFilePath);
        while (spaceChar != Alphabet.SPACE) {
            if (alphabetLogic.isMiddleAlphabet(spaceChar)) {
                spaceChar--;
            } else {
                spaceChar = alphabetLogic.charSwitch(spaceChar, -1);
            }
            key--;
        }
        args.put("key", String.valueOf(key));
        activity.activity(args);
    }

    private void repeater(char start, char end, Path sourceFilePath) {
        for (char i = start; i <= end; i++) {
            int middleCounter = 0;
            try (BufferedReader bufferedReader = Files.newBufferedReader(sourceFilePath)) {
                while (bufferedReader.ready()) {
                    char c = Character.toLowerCase((char) bufferedReader.read());
                    if (c == i) {
                        middleCounter++;
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (middleCounter > spaceCounter) {
                spaceChar = i;
                spaceCounter = middleCounter;
            }
        }
    }

    private void repeater(char symbol, Path sourceFilePath) {
        int middleCounter = 0;
        try (BufferedReader bufferedReader = Files.newBufferedReader(sourceFilePath)) {
            while (bufferedReader.ready()) {
                char c = Character.toLowerCase((char) bufferedReader.read());
                if (c == symbol) {
                    middleCounter++;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (middleCounter > spaceCounter) {
            spaceChar = symbol;
            spaceCounter = middleCounter;
        }
    }
}
