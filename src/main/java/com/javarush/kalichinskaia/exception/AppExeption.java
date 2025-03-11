package com.javarush.kalichinskaia.exception;

public class AppExeption extends RuntimeException{

    public AppExeption() {
    }

    public AppExeption(String message) {
        super(message);
    }

    public AppExeption(String message, Throwable cause) {
        super(message, cause);
        System.out.println(message);
    }

    public AppExeption(Throwable cause) {
        super(cause);
    }

    public AppExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
