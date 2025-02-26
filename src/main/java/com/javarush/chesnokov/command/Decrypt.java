package com.javarush.chesnokov.command;

public class Decrypt implements Command{

    @Override
    public void execute() {
        System.out.println("Выполняется дешифрование...");
    }
}
