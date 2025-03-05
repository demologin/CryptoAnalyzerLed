package com.javarush.artemov.console;

import com.javarush.artemov.config.AppData;
import com.javarush.artemov.config.OperationType;
import com.javarush.artemov.entity.ResultCode;
import com.javarush.artemov.exception.AppException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Menu {
    private static final String INPUT_FILE = "Введите путь к исходному файлу. Для выхода наберите - exit";
    private static final String OUTPUT_FILE = "Укажите путь к файлу для сохранения результата. Для выхода наберите - exit";
    private static final String KEY = "Введите ключ для шифрования / дешифрования - целое число. Для выхода наберите 0";
    private static final String[] MENU = {
            "***********************",
            "* Выберете операцию:  *",
            "* 1. Шифрование       *",
            "* 2. Дешифрование     *",
            "* 0. Выход            *",
            "***********************"
    };

    public AppData getInputData() {
        ResultCode resultCode;
        AppData appData = new AppData();
        Scanner console = new Scanner(System.in);

        for (String line : MENU) {
            System.out.println(line);
        }

        resultCode = choosingOperation(console, appData);
        if (resultCode.equals(ResultCode.CANCELED)) {
            return null;
        }

        resultCode = enterSourceFilePath(console, appData);
        if (resultCode.equals(ResultCode.CANCELED)) {
            return null;
        }

        resultCode = enterReceiverFilePath(console, appData);
        if (resultCode.equals(ResultCode.CANCELED)) {
            return null;
        }

        resultCode = enterKey(console, appData);
        if (resultCode.equals(ResultCode.CANCELED)) {
            return null;
        }

        return appData;
    }

    private static ResultCode choosingOperation(Scanner console, AppData appData) {
        ResultCode resultCode;
        while (true) {
            String operation = console.nextLine();
            if (operation.equals("1")) {
                appData.setOperation(OperationType.CODE);
                resultCode = ResultCode.OK;
                break;
            } else if (operation.equals("2")) {
                appData.setOperation(OperationType.DECODE);
                resultCode = ResultCode.OK;
                break;
            } else if (operation.equals("0")) {
                resultCode = ResultCode.CANCELED;
                break;
            }else {
                System.out.println("Введите корректный номер операции");
            }
        }
        return resultCode;
    }

    private ResultCode enterSourceFilePath(Scanner console, AppData appData) {
        ResultCode resultCode;
        System.out.println(INPUT_FILE);
        while (true) {
            String inputFile = console.nextLine();
            if (inputFile.equals("exit")) {
                resultCode = ResultCode.CANCELED;
                break;
            } else {
                if (Files.exists(Path.of(inputFile))) {
                    appData.setInputFile(inputFile);
                    resultCode = ResultCode.OK;
                    break;
                } else {
                    System.out.println("Исходный файл не обнаружен! Введите корректный путь к файлу или exit");
                }
            }
        }
        return resultCode;
    }

    private static ResultCode enterReceiverFilePath(Scanner console, AppData appData) {
        ResultCode resultCode;
        System.out.println(OUTPUT_FILE);
        while (true) {
            String outputFile = console.nextLine();
            if (outputFile.equals("exit")) {
                resultCode = ResultCode.CANCELED;
                break;
            } else {
                if (Files.exists(Path.of(outputFile))) {
                    appData.setOutputFile(outputFile);
                    resultCode = ResultCode.OK;
                    break;
                } else {
                    System.out.println("Файл не обнаружен! Для создания файла введите YES, для выхода - exit");
                }
            }
        }
        return resultCode;
    }

    private ResultCode enterKey(Scanner console, AppData appData) {
        ResultCode resultCode;
        System.out.println(KEY);
        while (!console.hasNextInt()) {
            System.out.println("Введите корректное значение ключа или 0 для выхода");
            console.nextLine();
        }
        int key = console.nextInt();
        if (key == 0) {
            resultCode = ResultCode.CANCELED;
        } else {
            appData.setKey(key);
            resultCode = ResultCode.OK;
        }
        return resultCode;
    }
}
