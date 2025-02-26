package com.javarush.chesnokov.command;

public class Exit extends AbstractCommand{

    public Exit() {
        super("Exit");
    }

    @Override
    public void execute() {
        System.out.println("Завершение программы...");
        System.exit(0);
    }
}
