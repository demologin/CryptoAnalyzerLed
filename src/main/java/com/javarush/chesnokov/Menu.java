package com.javarush.chesnokov;

import com.javarush.chesnokov.command.*;
import com.javarush.chesnokov.result.Result;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {

    private final Scanner scanner;
    public static final int DECORATION_COUNT = 20;

    private final Map<CommandType, Command> commands = new HashMap<>();

    public Menu(Scanner scanner) {
        this.scanner = scanner;
        initCommands();
    }

    private void initCommands() {
        commands.put(CommandType.ENCRYPT, new Encrypt());
        commands.put(CommandType.DECRYPT, new Decrypt());
        commands.put(CommandType.BRUTE_FORCE, new BruteForce());
        commands.put(CommandType.ANALYZE, new Analyze());
        commands.put(CommandType.EXIT, new Exit());
    }

    public void showMenu() {
        System.out.println("-".repeat(DECORATION_COUNT));
        System.out.println(Const.CHOSE_COMMAND);

        for (CommandType ct : CommandType.values()) {
            System.out.println(ct.getCode() + " - " + ct.getCommandName());
        }
        System.out.println("-".repeat(DECORATION_COUNT));
    }

    public boolean executeCommand(CommandType command) {
        if (command == null) {
            System.out.println(Const.INCORRECT_COMMAND);
            return true;
        }
        Command cmd = commands.get(command);
        if (cmd != null) {
            Result result = cmd.execute();
            System.out.println(result);
            return command != CommandType.EXIT;
        }
        return true;
    }

    public CommandType chooseCommand() {
        while (!scanner.hasNextInt()) {
            System.out.println("Ошибка! Введите целое число.\n");
            scanner.next();
            showMenu();
        }
        int code = scanner.nextInt();
        return CommandType.fromCode(code);
    }

}