package com.javarush.burdygin.activity;

import com.javarush.burdygin.constant.Constants;
import com.javarush.burdygin.alphabet.AlphabetLogic;
import com.javarush.burdygin.exception.EmptyFileException;
import com.javarush.burdygin.inputOutput.PathHelper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class Activity {

    AlphabetLogic alphabetLogic;

    public Activity(AlphabetLogic alphabetLogic) {
        this.alphabetLogic = alphabetLogic;
    }


    public void startActivity(Map<String, String> args) {
        Path sourceFilePath = PathHelper.get(args.get(Constants.SOURCE_FILE));
        Path destinationFilePath = PathHelper.get(args.get(Constants.DESTINATION_FILE));
        int key = Integer.parseInt(args.get(Constants.KEY)) > 0 ? 1 : -1;

        try (
                BufferedReader bufferedReader = Files.newBufferedReader(sourceFilePath);
                BufferedWriter bufferedWriter = Files.newBufferedWriter(destinationFilePath)
        ) {
            if (!bufferedReader.ready()){
                throw new EmptyFileException();
            }

            while (bufferedReader.ready()) {
                char textChar = Character.toLowerCase((char) bufferedReader.read());
                for (int i = 0; i < Math.abs(Integer.parseInt(args.get(Constants.KEY))); i++) {
                    if (alphabetLogic.isMiddleAlphabet(textChar)) {
                        textChar = (char) (textChar + key);
                    } else {
                        textChar = alphabetLogic.charSwitch(textChar, key);
                    }
                }
                bufferedWriter.write(textChar);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
