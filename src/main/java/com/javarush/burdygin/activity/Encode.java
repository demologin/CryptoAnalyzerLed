package com.javarush.burdygin.activity;

import java.util.Map;

public class Encode implements Mode {

    public void start(Map<String, String> args, Activity activity) {
        activity.startActivity(args);
    }
}
