package com.javarush.pyatigin;

import com.javarush.pyatigin.exception.FilePrompter;
import com.javarush.pyatigin.exception.KeyPrompter;

import java.nio.file.Path;
import java.util.Scanner;


public class GetOptions {
    public int option;
    public Path path;
    public int key;

    public GetOptions(int option) {
        Scanner scanner = new Scanner(System.in);
        FilePrompter filePrompter = new FilePrompter();
        KeyPrompter keyPrompter = new KeyPrompter();
        switch (option) {
            case 1:
                this.path = filePrompter.promptFile("File to be encrypted", scanner);
                this.key = keyPrompter.promptKey("Encryption key", scanner);
                break;
            case 2:
                this.path = filePrompter.promptFile("File to be decrypted", scanner);
                this.key = keyPrompter.promptKey("Decryption key", scanner);
                break;
            case 3:
                this.path = filePrompter.promptFile("File to be decrypted", scanner);
                this.key = 0;
                break;
        }
    }
}
//        if (option == 1) {
//            this.option = option;
//            System.out.println("File to be encrypted");
//            Scanner scanner = new Scanner(System.in);
//            while (true) {
//                this.path = Paths.get(scanner.nextLine());
//                if (!isRegularFile(this.path)) {
//                    System.out.println("File not found");
//                } else {
//                    break;
//                }
//            }
//            System.out.println("Encryption key");
//            this.key = scanner.nextInt();
//        } else if (option == 2) {
//            this.option = option;
//            System.out.println("File to be decrypted");
//            Scanner scanner = new Scanner(System.in);
//            this.path = Paths.get(scanner.nextLine());
//            System.out.println("Decryption key");
//            this.key = scanner.nextInt();
//        } else if (option == 3) {
//            this.option = option;
//            System.out.println("File to be decrypted");
//            Scanner scanner = new Scanner(System.in);
//            this.path = Paths.get(scanner.nextLine());
//            this.key = 0;
//        }
//    }
//}