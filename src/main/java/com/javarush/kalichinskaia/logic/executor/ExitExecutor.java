package com.javarush.kalichinskaia.logic.executor;

import com.javarush.kalichinskaia.logic.Result;
import com.javarush.kalichinskaia.logic.ResultCode;

import java.util.List;

public class ExitExecutor extends AbstractExecutor {

    @Override
    public Result execute(List<String> parameters) {
        return new Result(ResultCode.SUCCESS, "Exit completed");
    }
}
