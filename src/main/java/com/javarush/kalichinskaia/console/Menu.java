package com.javarush.kalichinskaia.console;

import com.javarush.kalichinskaia.console.args.ArgsProvider;

import java.util.*;

public class Menu {
    private final Scanner scanner;

    Map<Integer, ArgsProvider> providers = new HashMap<>();

    public Menu(Scanner scanner) {
        this.scanner = scanner;
        for (AppMode mode : AppMode.values()) {
            providers.put(mode.getMode(), mode.getSupplier());
        }
    }

    public List<String> getArguments() {
        int mode = getModeApp(scanner);
        ArgsProvider argsProvider = providers.get(mode);
        return argsProvider.get(scanner);
    }

    public static int getModeApp(Scanner scanner) {
        int mode;
        do {
            String input = scanner.nextLine();
            mode = switch (input) {
                case "1" -> 1;
                case "2" -> 2;
                case "3" -> 3;
                case "4" -> 4;
                case "5" -> 5;
                default -> {
                    System.out.println("Incorrect mode\nSelect a mode from the list");
                    yield -1;
                }
            };
        } while (mode < 0);
        return mode;
    }

    public void showMenu() {
        String dottedLine = "-".repeat(20);
        String messageMenu = dottedLine + "\nPlease select mode:\n" + """
                1. Encrypt
                2. Decrypt
                3. Brute force
                4. Analyze
                5. Exit
                """
                + dottedLine;
        System.out.println(messageMenu);
    }

}
