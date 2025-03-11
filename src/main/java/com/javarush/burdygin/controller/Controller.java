package com.javarush.burdygin.controller;

import com.javarush.burdygin.activity.Activity;
import com.javarush.burdygin.activity.Mode;
import com.javarush.burdygin.activity.Encode;
import com.javarush.burdygin.activity.Decode;
import com.javarush.burdygin.activity.BruteForce;
import com.javarush.burdygin.alphabet.AlphabetLogic;
import com.javarush.burdygin.constant.Constants;

import java.util.HashMap;
import java.util.Map;

public class Controller {

    private final Activity activity;
    private final Map<String, Mode> map = new HashMap<>();

    public Controller(Activity activity, AlphabetLogic alphabetLogic) {
        this.activity = activity;
        map.put(Constants.MODE_ENCODE, new Encode());
        map.put(Constants.MODE_DECODE, new Decode());
        map.put(Constants.MODE_BRUTE_FORCE, new BruteForce(alphabetLogic));
    }

    public void start(Map<String, String> args) {
        Mode mode = map.get(args.get(Constants.MODE_FLAG));
        mode.start(args, activity);
    }
}
