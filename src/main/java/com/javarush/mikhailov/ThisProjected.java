package com.javarush.mikhailov;

import java.util.Scanner;

public class ThisProjected {
    static Scanner scanner = new Scanner(System.in);

    public ThisProjected() {

    }
    public static void main(String[] args) throws RuntimeException {

        Alphabet alphabet = new Alphabet();
        Cipher cipher = new Cipher();

        while (true) {
            System.out.println("""
                    Select mode please
                    1. Encrypt
                    2. Decrypt
                    3. Exit
                    """);

                String choice = scanner.nextLine();
                if (choice.equals("3")) {
                    System.out.println("Exiting...");
                    break;
                }
                System.out.println("Enter text:");
                String text = scanner.nextLine();

                System.out.println("Enter shift:");
                int shift = scanner.nextInt();
                scanner.nextLine();

                String result = "";
                switch (choice) {
                    case "1" -> cipher.encrypt(text, shift);
                    case "2" -> cipher.decrypt(text, shift);
                    default -> {
                    }

                }
                System.out.println("Result:" + result);
        }
    }
}