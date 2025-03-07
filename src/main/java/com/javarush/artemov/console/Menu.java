package com.javarush.artemov.console;

import com.javarush.artemov.config.AppData;
import com.javarush.artemov.config.OperationType;
import com.javarush.artemov.entity.ResultCode;
import com.javarush.artemov.exception.AppException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private static final String INPUT_FILE = "Введите путь к исходному файлу. Для выхода наберите - exit";
    private static final String OUTPUT_FILE = "Укажите путь к файлу для сохранения результата. Для выхода наберите - exit";
    private static final String KEY = "Введите ключ для шифрования / дешифрования - положительное целое число. Для выхода наберите 0";
    private static final String OPERATION_ERROR_MESSAGE = "Введите корректный номер операции";
    private static final String INPUT_FILE_NO_FOUND_MESSAGE = "Исходный файл не обнаружен! Введите корректный путь к файлу или exit";
    private static final String OUTPUT_FILE_NO_FOUND_MESSAGE = "Файл не обнаружен! Для создания файла введите YES, для выхода - exit";
    private static final String OUTPUT_FILE_ERROR_MESSAGE = "Ошибка создания файла результата";
    private static final String ENTER_KEY_ERROR_MESSAGE = "Введите корректное значение ключа - целое положительное число или 0 для выхода";
    private static final String PARSE_BRUTE_FORCE_LINES = "Введите количество строк для анализа Brute Force от 5 до 20 или 0 для выхода";
    private static final String ENTER_PARSE_BRUTE_FORCE_LINES_ERROR_MESSAGE = "Введите корректное значение количества строк " +
            "для анализа Brute Force от 5 до 20 или 0 для выхода";
    private static final String[] MENU = {
            "***********************",
            "* Выберете операцию:  *",
            "* 1. Шифрование       *",
            "* 2. Дешифрование     *",
            "* 3. Brute Force      *",
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

        if (appData.getOperation() == OperationType.BRUTE_FORCE) {
            resultCode = enterParseBruteForceLines(console, appData);
        } else {
            resultCode = enterKey(console, appData);
        }
        if (resultCode.equals(ResultCode.CANCELED)) {
            return null;
        }

        return appData;
    }

    private static ResultCode choosingOperation(Scanner console, AppData appData) {
        ResultCode resultCode;
        label:
        while (true) {
            String operation = console.nextLine();
            switch (operation) {
                case "1":
                    appData.setOperation(OperationType.CODE);
                    resultCode = ResultCode.OK;
                    break label;
                case "2":
                    appData.setOperation(OperationType.DECODE);
                    resultCode = ResultCode.OK;
                    break label;
                case "3":
                    appData.setOperation(OperationType.BRUTE_FORCE);
                    resultCode = ResultCode.OK;
                    break label;
                case "0":
                    resultCode = ResultCode.CANCELED;
                    break label;
                default:
                    System.out.println(OPERATION_ERROR_MESSAGE);
                    break;
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
                if (Files.isRegularFile(Path.of(inputFile))) {
                    appData.setInputFile(inputFile);
                    resultCode = ResultCode.OK;
                    break;
                } else {
                    System.out.println(INPUT_FILE_NO_FOUND_MESSAGE);
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
                if (Files.isRegularFile(Path.of(outputFile))) {
                    appData.setOutputFile(outputFile);
                    resultCode = ResultCode.OK;
                    break;
                } else {
                    System.out.println(OUTPUT_FILE_NO_FOUND_MESSAGE);
                    if (console.nextLine().equalsIgnoreCase("yes")) {
                        try {
                            Files.createFile(Path.of(outputFile));
                            appData.setOutputFile(outputFile);
                            resultCode = ResultCode.OK;
                            break;
                        } catch (IOException e) {
                            throw new AppException(OUTPUT_FILE_ERROR_MESSAGE);
                        }
                    }
                }
            }
        }
        return resultCode;
    }

    private ResultCode enterParseBruteForceLines(Scanner console, AppData appData) {
        ResultCode resultCode;
        System.out.println(PARSE_BRUTE_FORCE_LINES);
        int lines;
        try {
            do {
                while (!console.hasNextInt()) {
                    System.out.println(ENTER_PARSE_BRUTE_FORCE_LINES_ERROR_MESSAGE);
                    console.nextLine();
                }
                lines = console.nextInt();
                if (lines < 0 || (lines > 0 && lines < 5) || lines > 20) {
                    System.out.println(ENTER_PARSE_BRUTE_FORCE_LINES_ERROR_MESSAGE);
                }
            } while (lines < 0 || (lines > 0 && lines < 5) || lines > 20);
            if (lines == 0) {
                resultCode = ResultCode.CANCELED;
            } else {
                appData.setParseBruteForceLines(lines);
                resultCode = ResultCode.OK;
            }
            return resultCode;
        } catch (InputMismatchException e) {
            throw new AppException("Ошибка ввода количества строк для анализа Brute Force");
        }
    }

    private ResultCode enterKey(Scanner console, AppData appData) {
        ResultCode resultCode;
        System.out.println(KEY);
        int key;
        try {
            do {
                while (!console.hasNextInt()) {
                    System.out.println(ENTER_KEY_ERROR_MESSAGE);
                    console.nextLine();
                }
                key = console.nextInt();
                if (key < 0) {
                    System.out.println(ENTER_KEY_ERROR_MESSAGE);
                }
            } while (key < 0);
            if (key == 0) {
                resultCode = ResultCode.CANCELED;
            } else {
                appData.setKey(key);
                resultCode = ResultCode.OK;
            }
            return resultCode;
        } catch (InputMismatchException e) {
            throw new AppException("Ошибка ввода значения ключа");
        }
    }
}
