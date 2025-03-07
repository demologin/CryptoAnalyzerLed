package com.javarush.burdygin.controller;

import com.javarush.burdygin.activity.*;
import com.javarush.burdygin.constant.Constants;
import com.javarush.burdygin.alphabet.AlphabetLogic;

import java.util.HashMap;
import java.util.Map;

public class Controller {

    private final AlphabetLogic alphabetLogic = new AlphabetLogic();
    private final Activity activity = new Activity(alphabetLogic);
    private final Map<String, Mode> map = new HashMap<>();

    {
        map.put(Constants.MODE_ENCODE, new Encode());
        map.put(Constants.MODE_DECODE, new Decode());
        map.put(Constants.MODE_BRUTE_FORCE, new BruteForce(alphabetLogic));
    }

    public void start(Map<String, String> args) {
        Mode mode = map.get(args.get(Constants.MODE_FLAG));
        mode.start(args, activity);
    }
}
