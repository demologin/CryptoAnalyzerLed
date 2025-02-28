package com.javarush.yatsevich;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

import static com.javarush.yatsevich.Actions.readAndEncrypt;


public class ApplicationRunner {
    public static void main(String[] args) throws IOException {

        System.out.println("Chose option");
        System.out.println("1. encrypt");
        System.out.println("2. decrypt");



        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            if (Objects.equals(scanner.nextLine(), "exit")){
                break;
            }

            if(scanner.nextLine().equals("1")) {

                readAndEncrypt(scanner);
            }
        }


    }


}
