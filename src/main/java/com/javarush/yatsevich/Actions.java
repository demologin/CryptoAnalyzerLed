package com.javarush.yatsevich;

import java.util.Scanner;

import static com.javarush.yatsevich.EncryptDecryptClass.decrypt;
import static com.javarush.yatsevich.EncryptDecryptClass.encrypt;

public class Actions {

    public static void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Chose option");
            System.out.println("1. encrypt");
            System.out.println("2. decrypt");
            System.out.println("3. exit");
            String operation = scanner.nextLine();
            if (operation.equals("1")) {
                operation(scanner, Operation.ENCRYPT);
                System.out.println("Operation finished");
            }
            else if (operation.equals("2")) {
                operation(scanner, Operation.DECRYPT);
                System.out.println("decrOperation finished");
            }
            else if (operation.equals("exit") || operation.equals("3")) {
                break;
            }
            System.out.println("end of loop");
        }
    }

    public static void operation (Scanner scanner, Operation operation  ) {
        FileProcessor fileProcessor = new FileProcessor();
        System.out.println("Please enter file to read: ");
        String pathToRead = scanner.nextLine();
        fileProcessor.readFile(pathToRead);
        System.out.println("Please enter a key: ");
        int key = Integer.parseInt(scanner.nextLine());                  //add check for isInt
        char[] text;
        if (operation == Operation.ENCRYPT){
            text = encrypt(fileProcessor.readFile(pathToRead), key);
        }
        else if (operation == Operation.DECRYPT){
            text = decrypt(fileProcessor.readFile(pathToRead), key);
        }
        else {
            text = new char[0];
        }
        System.out.println("Please enter file to write: ");
        String pathToWrite = scanner.nextLine();
        fileProcessor.writeFile(text,pathToWrite );
    }
}
