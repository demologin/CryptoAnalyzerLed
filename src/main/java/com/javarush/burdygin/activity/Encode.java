package com.javarush.burdygin.activity;

import java.util.Map;

public class Encode extends Mode {

    @Override
    public void start(Map<String, String> args, Activity activity) {
        activity.startActivity(args);
    }
}
