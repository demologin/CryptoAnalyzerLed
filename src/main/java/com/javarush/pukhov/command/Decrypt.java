package com.javarush.pukhov.command;

import java.util.List;

public abstract class Decrypt extends CipherAction {

    protected static final int DECRYPT_MODE = -1;

    @Override
    public void execute(List<String> parameters) {
        decrypt(parameters);
    }

    public abstract void decrypt(List<String> parameters);
}
