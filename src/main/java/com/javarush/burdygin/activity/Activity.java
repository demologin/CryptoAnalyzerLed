package com.javarush.burdygin.activity;

import com.javarush.burdygin.constant.AlphabetLogic;
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
        AlphabetLogic alphabetLogic = new AlphabetLogic();
        try (
                BufferedReader bufferedReader = Files.newBufferedReader(sourceFilePath);
                BufferedWriter bufferedWriter = Files.newBufferedWriter(destinationFilePath)
        ) {
            while (bufferedReader.ready()) {
                char readString = Character.toLowerCase((char) bufferedReader.read());
                for (int i = 0; i < Math.abs(Integer.parseInt(args.get("key"))); i++) {
                    if (alphabetLogic.isMiddleAlphabet(readString)) {
                        readString = (char) (readString + key);
                    } else {
                        readString = alphabetLogic.charSwitch(readString, key);
                    }
                }
                bufferedWriter.write(readString);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
