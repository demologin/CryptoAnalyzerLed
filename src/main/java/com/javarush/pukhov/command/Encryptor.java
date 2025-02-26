package com.javarush.pukhov.command;

public abstract class Encryptor implements Action {

    @Override
    public void execute() {
        encrypt();
    }

    public abstract void encrypt();
}
