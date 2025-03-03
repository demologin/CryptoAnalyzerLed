package com.javarush.bulimova;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class MainApp {
    public static void main(String[] args) {
       // System.out.println("Введите программу, которую хотите активировать");
        //System.out.println("text.txt");
       // readFile("text/text.txt");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        String path2 = scanner.nextLine();
        int key = Integer.parseInt(scanner.nextLine());
        FileManager fileManager = new FileManager(path, path2);
        List<String> mainText = fileManager.readFile();
        Cipher cipher = new Cipher(key);
        List<String> encodeText = cipher.code(mainText);




    }
}
