package com.javarush.kalichinskaia.logic.executor;

import com.javarush.kalichinskaia.logic.Result;
import com.javarush.kalichinskaia.logic.ResultCode;

import java.util.List;

import static com.javarush.kalichinskaia.logic.executor.Messages.SUCCESS_MESSAGE;

public class Analyzer extends AbstractExecutor {
    @Override
    public Result execute(List<String> parameters) {
        String sourceAnalyze = parameters.get(0);
        String dictionaryAnalyze = parameters.get(1);
        String destinationAnalyze = parameters.get(2);
        //todo реализовать
        return new Result(ResultCode.SUCCESS, String.format(SUCCESS_MESSAGE, destinationAnalyze));
    }
}
