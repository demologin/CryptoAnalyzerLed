package com.javarush.pukhov.io;

import java.util.Scanner;

public class ConsoleInput implements Input {

    Scanner scanner = new Scanner(System.in);

    @Override
    public String read() {
        return scanner.nextLine();
    }

}
