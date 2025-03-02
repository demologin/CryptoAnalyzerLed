package com.javarush.burdygin;


import com.javarush.burdygin.activity.Activity;
import com.javarush.burdygin.controller.Controller;
import com.javarush.burdygin.view.Menu;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        Menu menu = new Menu(scanner);
        Activity activity = new Activity();
        Controller controller = new Controller(menu, activity);
        controller.start();
    }
}
