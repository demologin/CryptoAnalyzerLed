package com.javarush.burdygin.activity;

import com.javarush.burdygin.constant.Constants;

import java.util.Map;

public class Decode implements Mode{

    public void start(Map<String, String> args, Activity activity) {
        args.put(Constants.KEY, String.valueOf((Integer.parseInt(args.get(Constants.KEY)) * -1)));
        activity.startActivity(args);
    }
}
