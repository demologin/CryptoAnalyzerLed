package com.javarush.artemov;

import com.javarush.artemov.config.AppData;
import com.javarush.artemov.console.Menu;
import com.javarush.artemov.controller.InputOutput;
import com.javarush.artemov.entity.ResultCode;
import com.javarush.artemov.exception.AppException;

public class ConsoleRunner {
    public static void main(String[] args) {
        AppData inputData;
        Menu menu = new Menu();
        InputOutput inputOutput = new InputOutput();

        try {
            inputData = menu.getInputData();
            if (inputData != null) {
                ResultCode result = switch (inputData.getOperation()) {
                    case CODE, DECODE -> inputOutput.encryptDecryptFile(inputData);
                    case BRUTE_FORCE -> inputOutput.bruteForse(inputData);
                };
                System.out.printf("Операция %s завершена - %s. Файл результата %s. Ключ - %d", inputData.getOperation(),
                        result, inputData.getOutputFile(), inputData.getKey());
            } else {
                System.out.println("Выполнение программы прервано!");
            }
        } catch (AppException e) {
            System.out.println("Работа программы завершилась с ошибкой - " + e.getMessage());
        }
    }
}
