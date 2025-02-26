package com.javarush.chesnokov.command;

public class Analyze extends AbstractCommand{

    public Analyze() {
        super("Analyze");
    }

    @Override
    public void execute() {
        System.out.println("Выполняется анализ...");
    }
}
