package com.javarush.kalichinskaia.logic;

import com.javarush.kalichinskaia.logic.executor.*;

public enum Action {
    ENCRYPT("1", new Encryptor()),
    DECRYPT("2", new Decryptor()),
    BRUTEFORCE("3", new BruteForcer()),
    ANALYZE("4", new Analyzer()),
    EXIT("5", new ExitExecutor());

    private String code;

    private Executor executor;

    Action(String code, Executor executor) {
        this.code = code;
        this.executor = executor;
    }

    public String getCode() {
        return code;
    }

    public Executor getExecutor() {
        return executor;
    }

    @Override
    public String toString() {
        return "Action{" +
                "code='" + code + '\'' +
                '}';
    }
}
