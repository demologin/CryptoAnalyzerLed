package com.javarush.pukhov.io;

public interface Output {
    public void print(String message);

    public void print(RuntimeException e);

}
