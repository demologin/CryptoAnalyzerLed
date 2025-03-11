package com.javarush.kalichinskaia;


import com.javarush.kalichinskaia.controller.ControllerApp;
import com.javarush.kalichinskaia.console.Menu;

import java.util.Scanner;

public class ConsoleRunnerApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Menu menuApp = new Menu(input);
        menuApp.showMenu();
        ControllerApp controllerApp = new ControllerApp();
        controllerApp.doExecute(menuApp.getArguments());
    }
}
