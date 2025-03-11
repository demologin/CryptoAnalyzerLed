package com.javarush.burdygin;

import com.javarush.burdygin.activity.Activity;
import com.javarush.burdygin.controller.AppConfig;
import com.javarush.burdygin.controller.Controller;
import com.javarush.burdygin.view.ConsoleApplication;
import com.javarush.burdygin.view.Menu;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        AppConfig appConfig = new AppConfig();
        Activity activity = new Activity(appConfig.getAlphabetLogic());
        Menu menu = new Menu(scanner, appConfig.getAlphabetLogic());
        Controller controller = new Controller(activity, appConfig.getAlphabetLogic());
        ConsoleApplication consoleApplication = new ConsoleApplication(menu, controller);
        consoleApplication.run();
    }
}
