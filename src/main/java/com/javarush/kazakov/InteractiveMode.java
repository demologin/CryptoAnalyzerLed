package com.javarush.kazakov;

import com.javarush.kazakov.commands.AbstractCommand;
import com.javarush.kazakov.commands.Commands;

import java.util.Scanner;

public class InteractiveMode implements Runnable {

    @Override
    public void run() {
        System.out.println("Application runs at interactive mode");
        menu();
        Scanner scanner = new Scanner(System.in);
        AbstractCommand command = Commands.NOOP.getCommand();
        do {
            String choice = scanner.nextLine();
            try {
                int idx = Integer.parseInt(choice.trim());
                command = Commands.values()[idx - 1].getCommand();
            } catch (NumberFormatException e) {
                System.out.println("Please enter an integer");
            } catch (ArrayIndexOutOfBoundsException ignore) {
            }
            if (command == Commands.NOOP.getCommand()) {
                System.out.println("Please enter an integer from 1 to " + (Commands.values().length - 1));
            }
        } while (command == Commands.NOOP.getCommand());

        command.interact();
    }

    private static void menu() {
        System.out.println("Welcome to CryptoAnalyzer!");
        System.out.println("Chose an option number:");
        for (int i = 0; i < Commands.values().length - 1; i++) {
            System.out.println(i + 1 + ". " + Commands.values()[i].toString());
        }
    }
}
