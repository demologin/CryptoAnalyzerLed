package com.javarush.pukhov.exception;

public class ActionContainerException extends ApplicationException {

    public ActionContainerException() {
    }

    public ActionContainerException(String message) {
        super(message);
    }

    public ActionContainerException(String message, Throwable cause) {
        super(message, cause);
    }

    public ActionContainerException(Throwable cause) {
        super(cause);
    }

}
