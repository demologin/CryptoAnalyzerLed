package com.javarush.chesnokov.result;

public class Result {

    private final ResultCode code;
    private final String message;

    public Result(ResultCode code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}