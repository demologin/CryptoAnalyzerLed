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
        if(option==1){
            this.option=1;
            System.out.println("File to be encrypted");
            Scanner scanner = new Scanner(System.in);
            this.path = Paths.get(scanner.nextLine());
            System.out.println("Encryption key");
            this.key = scanner.nextInt();
        }
    }
}
