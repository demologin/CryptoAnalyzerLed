package com.javarush.chesnokov.command;

public class BruteForce extends AbstractCommand{

    public BruteForce() {
        super("Brute force");
    }

    @Override
    public void execute() {
        System.out.println("Выполняется brute force...");
    }
}
