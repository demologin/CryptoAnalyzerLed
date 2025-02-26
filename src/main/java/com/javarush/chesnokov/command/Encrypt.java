package com.javarush.chesnokov.command;

public class Encrypt extends AbstractCommand {

    public Encrypt() {
        super("Encrypt");
    }

    @Override
    public void execute() {
        System.out.println("Выполняется шифрование...");
    }

}
