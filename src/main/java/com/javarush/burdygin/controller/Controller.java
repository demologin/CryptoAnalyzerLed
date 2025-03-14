package com.javarush.burdygin.controller;

import com.javarush.burdygin.activity.Activity;
import com.javarush.burdygin.activity.Mode;
import com.javarush.burdygin.alphabet.AlphabetLogic;
import com.javarush.burdygin.constant.Constants;


import java.util.Map;

public class Controller {

    private final Activity activity;
    static AlphabetLogic alphabetLogic;

    public static AlphabetLogic getAlphabetLogic() {
        return Controller.alphabetLogic;
    }

    public Controller(Activity activity, AlphabetLogic alphabetLogic) {
        this.activity = activity;
        Controller.alphabetLogic = alphabetLogic;
    }

    public void start(Map<String, String> args) {
        String modeFlag = args.get(Constants.MODE_FLAG);
        Mode mode = Mode.of(modeFlag);
        mode.start(args, activity);
    }
}
