package com.javarush.pyatigin;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class GetOptions {
    public int option;
    public Path path;
    public int key;

    public GetOptions() {
    }

    public GetOptions(int option) {
        if (option == 1) {
            this.option = 1;
            System.out.println("File to be encrypted");
            Scanner scanner = new Scanner(System.in);
            this.path = Paths.get(scanner.nextLine());
            System.out.println("Encryption key");
            this.key = scanner.nextInt();
        } else if (option == 2) {
            this.option = 2;
            System.out.println("File to be decrypted");
            Scanner scanner = new Scanner(System.in);
            this.path = Paths.get(scanner.nextLine());
            System.out.println("Decryption key");
            this.key = scanner.nextInt();
        } else if (option == 3) {
            this.option = 3;
            System.out.println("File to be decrypted");
            Scanner scanner = new Scanner(System.in);
            this.path = Paths.get(scanner.nextLine());
            this.key = 0;
        }
    }
}
