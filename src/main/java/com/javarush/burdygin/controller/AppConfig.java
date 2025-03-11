package com.javarush.burdygin.controller;

import com.javarush.burdygin.activity.Activity;
import com.javarush.burdygin.alphabet.Alphabet;
import com.javarush.burdygin.alphabet.AlphabetLogic;
import com.javarush.burdygin.alphabet.AlphabetObject;

import java.util.ArrayList;
import java.util.List;

public class AppConfig {
    private final AlphabetObject alphabetObjectLatin = new AlphabetObject(Alphabet.A_LAT, Alphabet.B_LAT, Alphabet.Y_LAT, Alphabet.Z_LAT);
    private final AlphabetObject alphabetObjectCyrillic = new AlphabetObject(Alphabet.A_CYR, Alphabet.B_CYR, Alphabet.YU_CYR, Alphabet.YA_CYR, Alphabet.YO_CYR);
    private final AlphabetObject alphabetObjectSymbol = new AlphabetObject(Alphabet.SPACE, Alphabet.EXCLAMATION_MARK, Alphabet.QUESTION_MARK, Alphabet.COMMERCIAL_AT, Alphabet.NEW_STRING, Alphabet.CARRIAGE_RETURN);

    private final List<AlphabetObject> alphabetsObjects = new ArrayList<>(List.of(alphabetObjectLatin, alphabetObjectCyrillic, alphabetObjectSymbol));

    private final AlphabetLogic alphabetLogic = new AlphabetLogic(alphabetsObjects);

    private final Activity activity = new Activity(alphabetLogic);

    public AlphabetLogic getAlphabetLogic() {
        return alphabetLogic;
    }

    public Activity getActivity() {
        return activity;
    }
}
