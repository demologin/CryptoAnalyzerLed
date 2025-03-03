package com.javarush.pukhov.exception;

public class ActionException extends ApplicationException {

    public ActionException() {
    }

    public ActionException(String message) {
        super(message);
    }

    public ActionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ActionException(Throwable cause) {
        super(cause);
    }

}
