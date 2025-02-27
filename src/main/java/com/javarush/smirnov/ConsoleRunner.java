package com.javarush.smirnov;

import org.apache.commons.math3.analysis.function.Constant;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        System.out.println("program started");
        System.out.println("choose an option:");
        System.out.println("1. Encode");
        System.out.println("2. Decode");
        System.out.println("3. Exit");
        Scanner scanner = new Scanner(System.in);
        int mode = 0;
        try {
            mode = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("incorrect input");
        }
        if (mode == 1){
            System.out.println("ok");
        } else if (mode == 2){
            System.out.println("ok");
        } else if (mode == 3){
            System.out.println("program ended");
        } else {
            System.out.println("incorrect input");
        }
    }
}
