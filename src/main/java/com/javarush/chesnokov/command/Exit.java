package com.javarush.chesnokov.command;

import com.javarush.chesnokov.result.Result;
import com.javarush.chesnokov.result.ResultCode;

public class Exit implements Command{

    @Override
    public Result execute(String[] parameters) {
        return new Result(ResultCode.OK, "Exit");
    }
}
