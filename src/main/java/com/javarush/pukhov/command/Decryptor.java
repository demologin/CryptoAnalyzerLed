package com.javarush.pukhov.command;

import java.util.List;

public abstract class Decryptor implements Action {

    @Override
    public void execute(List<String> parameters) {
        decrypt(parameters);
    }

    public abstract void decrypt(List<String> parameters);
}
