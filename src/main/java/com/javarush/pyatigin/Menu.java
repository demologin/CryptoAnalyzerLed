package com.javarush.pyatigin;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public int MenuOption() {
        System.out.println("Welcome to Pyatigin APP");
        System.out.println("Select menu item");
        System.out.println("1. Encode file ");
        System.out.println("2. Decode file ");
        System.out.println("3. Brute Force ");
        System.out.println("4. Exit");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                int option = scanner.nextInt();
                if (option < 1 || option > 4) {
                    System.out.println("Invalid option. Please select a valid option (1-4).");
                } else {
                    return option;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                scanner.next();
            }
        }
    }
}

