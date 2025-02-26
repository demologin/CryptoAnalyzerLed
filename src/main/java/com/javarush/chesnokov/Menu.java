package com.javarush.chesnokov;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {

    public static final int COMMAND_ENCRYPT = 1;
    public static final int COMMAND_DECRYPT = 2;
    public static final int COMMAND_BRUTE_FORCE = 3;
    public static final int COMMAND_ANALYZE = 4;
    public static final int COMMAND_EXIT = 5;

    private final Map<Integer, String> commands = new HashMap<>();

    public Menu() {
        initCommands();
    }

    private void initCommands() {
        commands.put(COMMAND_ENCRYPT, "Encrypt");
        commands.put(COMMAND_DECRYPT, "Decrypt");
        commands.put(COMMAND_BRUTE_FORCE, "Brute force");
        commands.put(COMMAND_ANALYZE, "Analyze");
        commands.put(COMMAND_EXIT, "Exit");
    }

    public void showMenu() {
        System.out.println("-".repeat(20));
        System.out.println("Выберите команду:");
        for (var map : commands.entrySet()) {
            System.out.println(map);
        }
        System.out.println("-".repeat(20));
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
