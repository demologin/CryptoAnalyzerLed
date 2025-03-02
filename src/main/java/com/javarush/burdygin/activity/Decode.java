package com.javarush.burdygin.activity;

import java.util.Map;

public class Decode {

    static {
        System.out.println('\n' + "decoding...");
    }

    public void start(Map<String, String> args, Activity activity) {
        args.put("key", String.valueOf((Integer.parseInt(args.get("key")) * -1)));
        activity.activity(args);
    }
}
