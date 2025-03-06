package com.javarush.chesnokov.result;

public class Result {

    public final ResultCode code;
    public final String message;

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