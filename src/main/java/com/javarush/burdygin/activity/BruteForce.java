package com.javarush.burdygin.activity;

import com.javarush.burdygin.constant.Constants;
import com.javarush.burdygin.alphabet.Alphabet;
import com.javarush.burdygin.alphabet.AlphabetLogic;
import com.javarush.burdygin.exception.EmptyFileException;
import com.javarush.burdygin.inputOutput.PathHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class BruteForce implements Mode {

    AlphabetLogic alphabetLogic;
    int spaceCounter = 0;
    char spaceChar;

    public BruteForce(AlphabetLogic alphabetLogic){
        this.alphabetLogic = alphabetLogic;
    }

    public void start(Map<String, String> args, Activity activity) {

        int key = 0;

        Path sourceFilePath = PathHelper.get(args.get(Constants.SOURCE_FILE));
        repeater(Alphabet.SPACE, Alphabet.COMMERCIAL_AT, sourceFilePath);
        repeater(Alphabet.A_LAT, Alphabet.Z_LAT, sourceFilePath);
        repeater(Alphabet.A_CYR, Alphabet.YA_CYR, sourceFilePath);
        repeater(Alphabet.NEW_STRING, sourceFilePath);
        repeater(Alphabet.CARRIAGE_RETURN, sourceFilePath);
        repeater(Alphabet.YO_CYR, sourceFilePath);
        if (spaceCounter != 0){
            while (spaceChar != Alphabet.SPACE) {
                if (alphabetLogic.isMiddleAlphabet(spaceChar)) {
                    spaceChar--;
                } else {
                    spaceChar = alphabetLogic.charSwitch(spaceChar, -1);
                }
                key--;
            }
            args.put(Constants.KEY, String.valueOf(key));
            activity.startActivity(args);
        } else {
            throw new EmptyFileException();
        }


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
