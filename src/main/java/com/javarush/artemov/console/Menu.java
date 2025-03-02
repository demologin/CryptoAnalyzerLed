package com.javarush.artemov.console;

import java.util.Scanner;

public class Menu {
    private static final String INPUT_FILE = "Введите путь к исходному файлу";
    private static final String OUTPUT_FILE = "Укажите путь к файлу для сохранения результата";
    private static final String KEY = "Введите ключ для шифрования / дешифрования";
    private static final String CODE = "Операция шифрования";
    private static final String DECODE = "Операция дешифрования";
    private static final String[] MENU = {
            "***********************",
            "* Выберете операцию:  *",
            "* 1. Шифрование       *",
            "* 2. Дешифрование     *",
            "***********************"
    };
    ;

    public String[] getInputData() {
        String[] inputData = new String[4];
        Scanner console = new Scanner(System.in);

        for (String line : MENU) {
            System.out.println(line);
        }
        inputData[0] = console.nextLine();

        System.out.println(INPUT_FILE);
        inputData[1] = console.nextLine();

        System.out.println(OUTPUT_FILE);
        inputData[2] = console.nextLine();

        System.out.println(KEY);
        inputData[3] = console.nextLine();

        return inputData;
    }
}
