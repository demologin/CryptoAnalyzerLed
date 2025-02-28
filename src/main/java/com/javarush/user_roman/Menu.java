package com.javarush.user_roman;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static void startMenu() {
        System.err.println("Выберите действие:");
        System.out.print("\t1-Запись текста в файл \n "
                + "\t2-Чтение текста из файла \n "
                + "\t3-Шифрование \n "
                + "\t4-Расшифровка \n "
                + "\t5-Выход \n");
    }

    static void switchMenu() {
        Scanner sc = new Scanner(System.in);
        Boolean isExit = false;
        while (!isExit) {
            try {
                int button = sc.nextInt();
                switch (button) {
                    case 1:
                        WriteTextToFile.writeTextToFile();
                        break;
                    case 2:
                        System.out.println("Чтение текста из файла");
                        ReadTextFromFile.readTextFromFile();
                        break;
                    case 3:
                        System.out.println("Шифрование");
                        break;
                    case 4:
                        System.out.println("Расшифровка");
                        break;
                    case 5:
                        System.out.println("Выход");
                        isExit = true;
                        break;
                    default:
                        System.out.println("Нет такой команды");
                }
            } catch (InputMismatchException e) {
                throw new InputMismatchException("Вы ввели не число. Все сломалось");
            }
        }
    }
}