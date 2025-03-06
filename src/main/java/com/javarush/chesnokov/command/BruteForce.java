package com.javarush.chesnokov.command;

import com.javarush.chesnokov.result.Result;

public class BruteForce implements Command{

    @Override
    public Result execute() {
        System.out.println("Выполняется brute force...");
        return null;
    }
}
