package com.javarush.pukhov.io;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;

public class ConsolePrinter<T,J> implements OutputError {

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public void print(RuntimeException e) {
        System.err.println(e.getMessage());
    }

    @Override
    public OutputStream getOutputStream() {
        return System.out;
    }

    @Override
    public Writer getWriter() {
        return new BufferedWriter(new PrintWriter(System.out));
    }

}
