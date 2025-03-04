package com.javarush.bulimova;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.javarush.bulimova.FileManager.*;


public class MainApp {
    public static void main(String[] args) {
       // System.out.println("Введите программу, которую хотите активировать");
        //System.out.println("text.txt");
       // readFile("text/text.txt");
        // /Users/n.bulimova/IdeaProjects/CryptoAnalyzerLed/text/tru.txt
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        String path2 = scanner.nextLine();
        int key = Integer.parseInt(scanner.nextLine());
        FileManager fileManager = new FileManager(path, path2);
        List<Character> mainText = fileManager.readFile();
        Cipher cipher = new Cipher(key);
//        List <Integer> encodeText = cipher.code(mainText);
        fileManager.writeFile(mainText);




    }
}
