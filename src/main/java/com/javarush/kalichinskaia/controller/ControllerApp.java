package com.javarush.kalichinskaia.controller;

import com.javarush.kalichinskaia.logic.Action;
import com.javarush.kalichinskaia.logic.ResultCode;
import com.javarush.kalichinskaia.logic.executor.Executor;
import com.javarush.kalichinskaia.logic.Result;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ControllerApp {

    private final Map<String, Executor> executors = new HashMap<>();

    public ControllerApp() {
        for (Action action : Action.values()) {
            executors.put(action.getCode(), action.getExecutor());
        }
    }

    public void doExecute(List<String> args) {
        Executor executor = executors.get(args.getFirst());
        try {
            System.out.println(executor.execute(args));
        } catch (Exception e) {
            System.out.println(new Result(ResultCode.ERROR, e.getMessage()));
        }
    }
}
