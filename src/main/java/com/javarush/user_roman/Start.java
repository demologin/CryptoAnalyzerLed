package com.javarush.user_roman;

import java.util.Scanner;

public class Start {
    public static void main(String[] args) {
        System.err.println("Выберите действие:");
        System.out.print("\t1-Запись текста в файл \n \t2-Чтение текста из файла \n \t3-Шифрование \n \t4-Расшифровка \n \t5-Выход \n");
        Scanner sc = new Scanner(System.in);
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
                break;
            default:
                System.out.println("Нет такой команды");
        }
    }

}
