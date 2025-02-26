package com.javarush.chesnokov.command;

public class Encrypt implements Command{

    @Override
    public void execute() {
        System.out.println("Выполняется шифрование...");
    }
}
