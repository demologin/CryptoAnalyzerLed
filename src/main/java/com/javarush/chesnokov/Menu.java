package com.javarush.chesnokov;

import com.javarush.chesnokov.command.*;
import com.javarush.chesnokov.result.Result;
import com.javarush.chesnokov.result.ResultCode;

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
        commands.put(CommandType.EXIT, new Exit());
    }

    public void showMenu() {
        System.out.println("-".repeat(DECORATION_COUNT));
        System.out.println(Const.CHOSE_COMMAND);

        for (CommandType commandType : CommandType.values()) {
            System.out.println(commandType.getCode() + " - " + commandType.getCommandName());
        }
        System.out.println("-".repeat(DECORATION_COUNT));
    }

    public Result executeCommand(CommandType command) {
        if (command == null) {
            return new Result(ResultCode.ERROR, Const.INCORRECT_COMMAND);
        }
        Command cmd = commands.get(command);
        try {
            return cmd.execute(getParameters(command));
        } catch (RuntimeException e) {
            throw new RuntimeException(Const.APPLICATION_ERROR + e.getMessage(), e);
        }
    }

    public CommandType chooseCommand() {
        while (!scanner.hasNextInt()) {
            System.out.println(Const.NOT_INTEGER);
            scanner.next();
            showMenu();
        }
        int code = scanner.nextInt();
        return CommandType.fromCode(code);
    }

    private String[] getParameters(CommandType commandType) {
        String[] parameters = new String[3];
        if (commandType != CommandType.EXIT) {
            System.out.println(Const.ENTER_SOURCE_PATH);
            parameters[0] = scanner.next();
            System.out.println(Const.ENTER_DESTINATION_PATH);
            parameters[1] = scanner.next();
            if (commandType != CommandType.BRUTE_FORCE) {
                System.out.println(Const.ENTER_KEY);
                parameters[2] = scanner.next();
            }
        }
        return parameters;
    }
}