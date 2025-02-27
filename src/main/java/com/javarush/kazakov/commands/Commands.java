package com.javarush.kazakov.commands;

import com.javarush.kazakov.util.Utils;

public enum Commands {
    ENCRYPT(new Encrypt()),
    DECRYPT(new Decrypt()),
    BRUTE_FORCE(new BruteForce()),
    STAT_ANALYSIS(new StatAnalysis()),
    EXIT(new Exit()),
    NOOP(new NoOperation());

    private final AbstractCommand command;

    Commands(AbstractCommand command) {
        this.command = command;
    }

    public AbstractCommand getCommand() {
        return command;
    }

    @Override
    public String toString() {
        return Utils.capitalize(this.name());
    }
}
