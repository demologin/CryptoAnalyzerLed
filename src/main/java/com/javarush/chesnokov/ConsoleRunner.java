package com.javarush.chesnokov;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            menu.showMenu();
            int command = menu.chooseCommand(scanner);
            menu.executeCommand(command);
        }

    }
}
