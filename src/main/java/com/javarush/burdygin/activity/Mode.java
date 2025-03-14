package com.javarush.burdygin.activity;

import com.javarush.burdygin.constant.Constants;
import com.javarush.burdygin.exception.IncorrectModeException;

import java.util.Map;

public abstract class Mode {
    public abstract void start(Map<String, String> map, Activity activity);

    public static Mode of(String modeFlag){
        return switch (modeFlag){
            case Constants.MODE_ENCODE -> new Encode();
            case Constants.MODE_DECODE  -> new Decode();
            case Constants.MODE_BRUTE_FORCE ->  new BruteForce();
            default -> throw new IncorrectModeException();
        };
    }
}
