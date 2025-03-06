package com.javarush.kazakov.commands;

public class Exit extends AbstractCommand{
    @Override
    public void interact() {
        System.out.println("Goodbye");
        call();
    }

    @Override
    public String call() {
        System.exit(0);
        return "";
    }
}
