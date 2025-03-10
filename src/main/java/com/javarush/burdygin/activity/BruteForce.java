package com.javarush.burdygin.activity;

import com.javarush.burdygin.alphabet.AlphabetLogic;
import com.javarush.burdygin.constant.Constants;
import com.javarush.burdygin.alphabet.Alphabet;
import com.javarush.burdygin.inputOutput.PathHelper;

import java.nio.file.Path;
import java.util.Map;

public class BruteForce implements Mode {

    AlphabetLogic alphabetLogic;

    public BruteForce(AlphabetLogic alphabetLogic) {
        this.alphabetLogic = alphabetLogic;
    }

    public void start(Map<String, String> args, Activity activity) {

        int key = 0;

        Path sourceFilePath = PathHelper.get(args.get(Constants.SOURCE_FILE));
        char spaceChar = alphabetLogic.getMostUsageSymbol(sourceFilePath);
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
    }
}
