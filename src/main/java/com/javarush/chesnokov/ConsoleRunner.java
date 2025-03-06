package com.javarush.chesnokov;

import com.javarush.chesnokov.command.CommandType;
import com.javarush.chesnokov.result.Result;
import com.javarush.chesnokov.result.ResultCode;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner);
        Result result;

        do {
            menu.showMenu();
            CommandType command = menu.chooseCommand();
            result = menu.executeCommand(command);
            result.printResult();
        } while (result.code == ResultCode.ERROR);
    }
}
