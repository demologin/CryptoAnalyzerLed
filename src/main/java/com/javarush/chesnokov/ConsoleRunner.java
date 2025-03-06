package com.javarush.chesnokov;

import com.javarush.chesnokov.command.CommandType;
import com.javarush.chesnokov.result.Result;
import com.javarush.chesnokov.result.ResultCode;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner);
        Result appRunning;

        do {
            menu.showMenu();
            CommandType command = menu.chooseCommand();
            appRunning = menu.executeCommand(command);
            System.out.println(appRunning);
        } while (appRunning.code == ResultCode.ERROR);
    }
}
