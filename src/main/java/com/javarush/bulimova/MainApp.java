package com.javarush.bulimova;

import java.util.List;
import java.util.Scanner;


public class MainApp {
    public static void main(String[] args) {
        // System.out.println("Введите программу, которую хотите активировать");

        // readFile("text/text.txt");
        // text/er.txt


        //Scanner scanner = new Scanner(System.in);

        String path = "text/eruuu.txt";
        String path2 = "text/er2.txt";
        int key = 1;
        int number = 1;

//        String path = "text/er2.txt";
//        String path2 = "text/er3.txt";
//        int key = 1;
//        int number = 2;

        FileManager fileManager = new FileManager(path, path2);
        List<Character> mainText = fileManager.readFile();

        Cipher cipher = new Cipher(key);


        if (number == 1) {
            List<Character> encodeText = cipher.code(mainText);
            fileManager.writeFile(encodeText);
        } else if (number == 2) {

            List<Character> decodeText = cipher.deCode(mainText);
            fileManager.writeFile(decodeText);
        } else {
            System.out.println("Начните заново");
        }


    }
}
