package com.javarush.apalinskiy.view;

import com.javarush.apalinskiy.constants.Const;

import java.io.IOException;

public class MainMenu {
    public void Menu() throws IOException {
        System.out.println(Const.ANSI_GREEN + "-".repeat(20));
        System.out.println("Select an action:");
        System.out.println("1. Encode.");
        System.out.println("2. Decode.");
        System.out.println("3. Bruteforce.");
        System.out.println("4. Exit");
        System.out.println("-".repeat(20));
        OperatorSwitch operatorSwitch = new OperatorSwitch();
        operatorSwitch.Switch();
    }
}
