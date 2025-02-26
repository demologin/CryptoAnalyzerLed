package com.javarush.chesnokov.command;

public class Decrypt extends AbstractCommand{

    public Decrypt() {
        super("Decrypt");
    }

    @Override
    public void execute() {
        System.out.println("Выполняется дешифрование...");
    }

}
