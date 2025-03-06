package com.javarush.smirnov;


import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < Constants.start.length; i++) {
            System.out.println(Constants.start[i]);
        }

        int mode = scanner.nextInt();

        try {
            switch (mode){
                case 1:
                    System.out.println(Constants.key);
                    int key = scanner.nextInt();
                    Encode code = new Encode(key);
                    code.EnCode();
                    break;
                case 2:
                    System.out.println(Constants.key);
                    int key2 = scanner.nextInt();
                    Decode code2 = new Decode(key2);
                    code2.DeCode();
                    break;
                case 3:
                    System.out.println(Constants.end);
                    break;
                default:
                    System.out.println(Constants.incorInput);
            }
        } catch (Exception e) {
            System.out.println(Constants.incorInput);
        }

    }
}
