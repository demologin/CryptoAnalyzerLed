package com.javarush.pukhov.exception;

public class StatisticException extends ApplicationException {

    public StatisticException() {
    }

    public StatisticException(String message) {
        super(message);
    }

    public StatisticException(String message, Throwable cause) {
        super(message, cause);
    }

    public StatisticException(Throwable cause) {
        super(cause);
    }

}
