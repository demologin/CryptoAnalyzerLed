package com.javarush.artjomfadejev.artjomfadeev.src.main.java.com.artjomfadeev.exception;

public class AppException extends RuntimeException{

    public AppException() {
    }

    public AppException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppException(Throwable cause) {
        super(cause);
    }

    public AppException(String message) {
        super(message);
    }
}
