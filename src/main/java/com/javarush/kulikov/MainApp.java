package com.javarush.kulikov;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cipher cipher = new Cipher();

        while (true) {
            System.out.println("""
                    Select mode please:
                    1. Encrypt
                    2. Decrypt
                    0. Exit
                    """);
            String choice = scanner.nextLine();

            if (choice.equals("0")) {
                System.out.println("Exiting...");
                break;
            }

            System.out.println("Enter text: ");
            String text = scanner.nextLine();

            System.out.println("Enter shift: ");
            int shift = scanner.nextInt();
            scanner.nextLine();

            String result = switch (choice) {
                case "1" -> cipher.encrypt(text, shift);
                case "2" -> cipher.decrypt(text, shift);
                default -> "Invalid choice, please try again.";
            };

            System.out.println("Result: " + result);
        }

        scanner.close();
    }
}
