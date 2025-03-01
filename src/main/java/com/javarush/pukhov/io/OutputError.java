package com.javarush.pukhov.io;

public interface OutputError extends Output {
    public void print(RuntimeException e);
}
