package com.javarush.chesnokov.command;

public class Analyze implements Command{

    @Override
    public void execute() {
        System.out.println("Выполняется анализ...");
    }
}
