package com.javarush.chesnokov.command;

import com.javarush.chesnokov.result.Result;

public class Analyze implements Command{

    @Override
    public Result execute() {
        System.out.println("Выполняется анализ...");
        return null;
    }
}
