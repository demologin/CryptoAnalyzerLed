package com.javarush.chesnokov.command;

public class Exit implements Command{

    @Override
    public void execute() {
        System.out.println("Завершение программы...");
    }
}
