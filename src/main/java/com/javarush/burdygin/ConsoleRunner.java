package com.javarush.burdygin;

import com.javarush.burdygin.activity.Activity;
import com.javarush.burdygin.controller.Controller;
import com.javarush.burdygin.view.ConsoleApplication;
import com.javarush.burdygin.view.Menu;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        AlphabetConfig alphabetConfig = new AlphabetConfig();
        Activity activity = new Activity(alphabetConfig.getAlphabetLogic());
        Menu menu = new Menu(scanner, alphabetConfig.getAlphabetLogic());
        Controller controller = new Controller(activity, alphabetConfig.getAlphabetLogic());
        ConsoleApplication consoleApplication = new ConsoleApplication(menu, controller);
        consoleApplication.run();
    }
}
