package com.javarush.pukhov.command;

import java.util.List;

public abstract class Encrypt extends CipherAction {

    protected static final int ENCRYPT_MODE = 1;

    @Override
    public void execute(List<String> parameters) {
        encrypt(parameters);
    }

    public abstract void encrypt(List<String> parameters);
}
