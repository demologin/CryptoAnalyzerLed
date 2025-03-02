package com.javarush.burdygin.activity;

import java.util.Map;

public class Encode {

    static {
        System.out.println('\n' +"encoding...");

    }

    public void start(Map<String, String> args, Activity activity){

        activity.activity(args);
    }


}
