package com.javarush.bulimova;

import java.util.List;
import java.util.Scanner;




public class MainApp {
    public static void main(String[] args) {
        // System.out.println("Введите программу, которую хотите активировать");
        //System.out.println("text.txt");
        // readFile("text/text.txt");
        // text/er.txt
        // /Users/n.bulimova/IdeaProjects/CryptoAnalyzerLed/text/tru.txt

//        do {
//
//        }
//        while ()

        Scanner scanner = new Scanner(System.in);
        String path = "text/er1.txt";
        String path2 = "text/er5.txt";
        int key = 1;
        int number = 2;
        FileManager fileManager = new FileManager(path, path2);
        List<Character> mainText = fileManager.readFile();
        //char mainText = fileManager.readFile();
        Cipher cipher = new Cipher(key);
//        List<Character>  encodeText = cipher.code(mainText);
//        fileManager.writeFile(encodeText);
//        List<Character>  decodeText = cipher.code(encodeText);
//        fileManager.writeFile(decodeText);
        //List<Character>  encodeText;
        List<Character> encodeText = cipher.code(mainText);

        if (number == 1) {
            //List<Character> encodeText = cipher.code(mainText);
            fileManager.writeFile(encodeText);
        } else if (number == 2) {

            List<Character> decodeText = cipher.code(encodeText);
            fileManager.writeFile(decodeText);
        } else {
            System.out.println("Начните заново");
        }


    }
}
