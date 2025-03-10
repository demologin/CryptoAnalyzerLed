package com.javarush.artjomfadejev.artjomfadeev.src.main.java.com.artjomfadeev;

import com.javarush.artjomfadejev.artjomfadeev.src.main.java.com.artjomfadeev.controller.MainController;
import com.javarush.artjomfadejev.artjomfadeev.src.main.java.com.artjomfadeev.view.console.ConsoleApp;
import com.javarush.artjomfadejev.artjomfadeev.src.main.java.com.artjomfadeev.view.console.Menu;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        //build console app
        Scanner input = new Scanner(System.in);
        Menu menu = new Menu(input);
        MainController mainController = new MainController();
        ConsoleApp application = new ConsoleApp(mainController, menu);
        //run console app
        application.run(args);
    }


}

