package com.javarush.pyatigin;

import java.util.Scanner;

public class Menu {
    public int MenuOption() {
            System.out.println("Welcome to Pyatigin APP");
            System.out.println("Select menu item");
            System.out.println("1. Encode file ");
            System.out.println("2. Decode file ");
            System.out.println("3. Exit");
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            switch (option) {
                case 1 -> {
                    return 1;
                }
            }
        return 0;
    }
}

