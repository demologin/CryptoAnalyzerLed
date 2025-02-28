package com.javarush.yatsevich;

import java.util.Scanner;

import static com.javarush.yatsevich.EncryptDecryptClass.encrypt;

public class Actions {

    public static void readAndEncrypt(Scanner scanner) {
        String s = scanner.nextLine();
        FileProcessor fp = new FileProcessor();
        fp.readFile(s);
        encrypt(FileProcessor.textFromFile, 1);
        System.out.println(new String(FileProcessor.textFromFile));
    }
}
