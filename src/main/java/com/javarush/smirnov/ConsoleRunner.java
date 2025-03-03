package com.javarush.smirnov;

import org.apache.commons.math3.analysis.function.Constant;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        for (int i = 0; i < Constants.start.length; i++) {
            System.out.println(Constants.start[i]);
        }
        Scanner scanner = new Scanner(System.in);
        try {
            int mode = scanner.nextInt();
            switch (mode){
                case 1:
                    System.out.println(Constants.ok);
                    break;
                case 2:
                    System.out.println(Constants.ok);
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
