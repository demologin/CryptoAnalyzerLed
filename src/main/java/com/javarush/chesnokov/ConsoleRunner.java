package com.javarush.chesnokov;

import com.javarush.chesnokov.command.CommandType;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner);
        boolean appRunning = true;

        while (appRunning) {
            menu.showMenu();
            CommandType command = menu.chooseCommand();
            appRunning = menu.executeCommand(command);
        }

    }
}
