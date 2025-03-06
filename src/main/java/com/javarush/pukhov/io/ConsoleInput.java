package com.javarush.pukhov.io;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;

public class ConsoleInput implements Input<InputStream,Reader> {

    Scanner scanner = new Scanner(System.in);

    @Override
    public String read() {
        return scanner.nextLine();
    }

    @Override
    public InputStream getInputStream() {
        return System.in;
    }

    @Override
    public Reader getReader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }

}
