package com.javarush.pukhov.io;

public class ConsolePrinter implements Output, OutputError {

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public void print(RuntimeException e) {
        System.err.println(e.getMessage());
    }

}
