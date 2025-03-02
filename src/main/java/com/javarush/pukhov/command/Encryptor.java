package com.javarush.pukhov.command;

import java.util.List;

public abstract class Encryptor implements Action {

    @Override
    public void execute(List<String> parameters) {
        encrypt(parameters);
    }

    public abstract void encrypt(List<String> parameters);
}
