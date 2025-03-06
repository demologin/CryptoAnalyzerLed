package com.javarush.bulimova;

import java.util.List;
import java.util.Scanner;


public class MainApp {
    public static void main(String[] args) {
        System.out.println("Введите номер программы, которую Вы хотите активировать" + "\n 1.Шифровка" +
                "\n 2.Дешифровка" + "\n 3.Выход");
        int number=0;
        Scanner scannerNumber = new Scanner(System.in);
        try {
            number = Integer.parseInt(scannerNumber.nextLine());

        } catch (NumberFormatException e) {
            System.out.println("число от 1 до 3");
        }



        if (number == 1) {
          //  read (String path, String path2);
            System.out.println("Введите ключ, который вы будете использовать для сдвига");
            int key = 0;
            Scanner scannerKey = new Scanner(System.in);
            try {
                key = Integer.parseInt(scannerKey.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Введите число");
            }
            System.out.println("Введите существующий файл в формате text/text.txt");
            Scanner scannerPath = new Scanner(System.in);
            String path  = scannerPath.nextLine();
            System.out.println("Введите файл в формате text/text2.txt");
            Scanner scannerPath2 = new Scanner(System.in);
            String path2  = scannerPath2.nextLine();


            Cipher cipher = new Cipher(key);

            FileManager fileManager = new FileManager(path, path2);
            List<Character> mainText = fileManager.readFile();
            List<Character> encodeText = cipher.code(mainText);
            fileManager.writeFile(encodeText);
        } else if (number == 2) {

            System.out.println("Введите ключ, который вы будете использовать для сдвига");

            int key = 0;
            Scanner scannerKey = new Scanner(System.in);
            try {
                key = Integer.parseInt(scannerKey.nextLine());
                if (key > 0 && key < 41) {
                    System.out.println("Введите существующий файл в формате text/text.txt");
                    Scanner scannerPath = new Scanner(System.in);
                    String path  = scannerPath.nextLine();
                    System.out.println("Введите файл в формате text/text2.txt");
                    Scanner scannerPath2 = new Scanner(System.in);
                    String path2  = scannerPath2.nextLine();

                    Cipher cipher = new Cipher(key);

                    FileManager fileManager = new FileManager(path, path2);
                    List<Character> mainText = fileManager.readFile();
                    List<Character> decodeText = cipher.deCode(mainText);
                    fileManager.writeFile(decodeText);
                }
                else {

                    System.out.println("За пределами границ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Введите число");
            }

        } else if (number == 3) {
            System.out.println("Пока пока");
        } else {
            System.out.println("Начните заново, Вы выбрали неверный номер");
        }


    }

}
