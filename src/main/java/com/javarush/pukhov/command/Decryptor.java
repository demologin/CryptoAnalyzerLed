package com.javarush.pukhov.command;

public abstract class Decryptor implements Action {

    @Override
    public void execute() {
        decrypt();
    }

    public abstract void decrypt();
}
