package com.javarush.chesnokov;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        menu.showMenu();
        int command = menu.chooseCommand(scanner);

        String result = switch (command) {
            case Menu.COMMAND_ENCRYPT -> "Вы выбрали Encrypt";
            case Menu.COMMAND_DECRYPT -> "Вы выбрали Decrypt";
            case Menu.COMMAND_BRUTE_FORCE -> "Вы выбрали Brute force";
            case Menu.COMMAND_ANALYZE -> "Вы выбрали Analyze";
            case Menu.COMMAND_EXIT -> "Выход из программы";
            default -> "Неизвестная команда";
        };
        System.out.println(result);

    }
}
