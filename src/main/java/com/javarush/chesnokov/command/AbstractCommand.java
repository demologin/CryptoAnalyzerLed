package com.javarush.chesnokov.command;

public abstract class AbstractCommand implements Command {

    protected final String name;

    protected AbstractCommand(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
