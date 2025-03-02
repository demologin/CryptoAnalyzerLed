package com.javarush.burdygin.controller;

import com.javarush.burdygin.activity.Activity;
import com.javarush.burdygin.activity.BruteForce;
import com.javarush.burdygin.activity.Decode;
import com.javarush.burdygin.activity.Encode;
import com.javarush.burdygin.view.Menu;

import java.util.HashMap;
import java.util.Map;

public class Controller {

    public static Map<String, String> args = new HashMap<>();

    private final Menu menu;
    private final Activity activity;

    public Controller(Menu menu, Activity activity) {
        this.menu = menu;
        this.activity = activity;
    }

    public void start() {
        menu.mainMenu();
        switch (args.get("modeFlag")) {
            case "1" -> new Encode().start(args, activity);
            case "2" -> new Decode().start(args, activity);
            case "3" -> new BruteForce().start(args, activity);
            default -> System.exit(0);
        }
    }
}
