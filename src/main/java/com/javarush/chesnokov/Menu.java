package com.javarush.chesnokov;

import com.javarush.chesnokov.command.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {

    public static final int COMMAND_ENCRYPT = 1;
    public static final int COMMAND_DECRYPT = 2;
    public static final int COMMAND_BRUTE_FORCE = 3;
    public static final int COMMAND_ANALYZE = 4;
    public static final int COMMAND_EXIT = 5;
    public static final int DECORATION_COUNT = 20;

    private final Map<Integer, Command> commands = new HashMap<>();

    public Menu() {
        initCommands();
    }

    private void initCommands() {
        commands.put(COMMAND_ENCRYPT, new Encrypt());
        commands.put(COMMAND_DECRYPT, new Decrypt());
        commands.put(COMMAND_BRUTE_FORCE, new BruteForce());
        commands.put(COMMAND_ANALYZE, new Analyze());
        commands.put(COMMAND_EXIT, new Exit());
    }

    public void showMenu() {
        System.out.println("-".repeat(DECORATION_COUNT));
        System.out.println("Выберите команду:");
        for (var entry : commands.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getName());
        }
        System.out.println("-".repeat(DECORATION_COUNT));
    }

    public void executeCommand(int command) {
        Command cmd = commands.get(command);
        if (cmd != null) {
            cmd.execute();
        } else {
            System.out.println("Неверная команда!");
        }
    }

    public int chooseCommand(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Ошибка! Введите целое число.\n");
            scanner.next();
            showMenu();
        }
        return scanner.nextInt();
    }

}