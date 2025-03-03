package com.javarush.artemov.console;

import com.javarush.artemov.config.AppData;
import com.javarush.artemov.config.OperationType;
import com.javarush.artemov.utils.Utils;

import java.util.Scanner;

public class Menu {
    private static final String INPUT_FILE = "Введите путь к исходному файлу";
    private static final String OUTPUT_FILE = "Укажите путь к файлу для сохранения результата";
    private static final String KEY = "Введите ключ для шифрования / дешифрования - целое число";
    private static final String[] MENU = {
            "***********************",
            "* Выберете операцию:  *",
            "* 1. Шифрование       *",
            "* 2. Дешифрование     *",
            "***********************"
    };

    Utils utils = new Utils();
    
    public AppData getInputData() {
        AppData appData = new AppData();
        Scanner console = new Scanner(System.in);

        for (String line : MENU) {
            System.out.println(line);
        }
        
        choosingOperation(console, appData);

        enterSourceFilePath(console, appData);

        enterReceiverFilePath(console, appData);

        enterKey(console, appData);

        return appData;
    }

    private static void choosingOperation(Scanner console, AppData appData) {
        while (true) {
            String operation = console.nextLine();
            if (operation.equals("1")) {
                appData.setOperation(OperationType.CODE);
                break;
            } else if (operation.equals("2")) {
                appData.setOperation(OperationType.DECODE);
                break;
            } else {
                System.out.println("Введите корректный номер операции");
            }
        }
    }

    private static void enterSourceFilePath(Scanner console, AppData appData) {
        System.out.println(INPUT_FILE);
        String inputFile = console.nextLine();
        appData.setInputFile(inputFile); // "c:\\1\\1.txt"; //
    }

    private static void enterReceiverFilePath(Scanner console, AppData appData) {
        System.out.println(OUTPUT_FILE);
        String outputFile = console.nextLine();
        appData.setOutputFile(outputFile); // console.nextLine();
    }

    private void enterKey(Scanner console, AppData appData) {
        System.out.println(KEY);
        while (true) {
            if (console.hasNextInt()) {
                int key = console.nextInt();
                appData.setKey(utils.getKey(key, appData.getOperation()));
                break;
            } else {
                System.out.println("Введите корректное значение ключа");
            }
        }
    }
}
