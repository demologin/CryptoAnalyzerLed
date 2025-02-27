package com.javarush.kazakov.commands;

import com.javarush.kazakov.core.exceptions.CryptoAnalyzerException;

public class NoOperation extends AbstractCommand {

    @Override
    public String call() {
        throw new CryptoAnalyzerException("There is nothing to do, no operation is selected");
    }

    @Override
    public void interact() {
        call();
    }
}
