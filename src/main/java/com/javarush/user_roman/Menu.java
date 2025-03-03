package com.javarush.user_roman;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public static void startMenu() {
        System.err.println("Выберите действие:");
        System.out.print(FinalConstant.getMenuAction());
    }

    static void switchMenu() {
        Scanner sc = new Scanner(System.in);
        Boolean isExit = false;
        while (!isExit) {
            try {
                int button = sc.nextInt();
                switch (button) {
                    case 1:
                        WriteTextToFile.writeTextToFile(FinalConstant.getTest());
                        break;
                    case 2:
                        System.out.println("Чтение текста из файла test.txt");
                        ReadTextFromFile.readTextFromFile(FinalConstant.getTest());
                        break;
                    case 3:
                        System.out.println("Чтение text.txt");
                        ReadTextFromFile.readTextFromFile(FinalConstant.getText());
                        break;
                    case 4:
                        System.out.println("Шифрование");
                        break;
                    case 5:
                        System.out.println("Расшифровка");
                        break;
                    case 6:
                        System.out.println("Выход");
                        isExit = true;
                        break;
                    default:
                        System.out.println("Нет такой команды");
                }
            } catch (InputMismatchException e) {
                throw new InputMismatchException("Вы ввели не целое число. Все сломалось."
                        + FinalConstant.getKaomojiError());
            }
        }
    }
}