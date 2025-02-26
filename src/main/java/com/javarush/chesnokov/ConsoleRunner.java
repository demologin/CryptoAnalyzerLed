package com.javarush.chesnokov;

import com.javarush.chesnokov.command.CommandType;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            menu.showMenu();
            CommandType command = menu.chooseCommand(scanner);
            running = menu.executeCommand(command);
        }

        System.out.println("Программа завершена.");

    }
}
