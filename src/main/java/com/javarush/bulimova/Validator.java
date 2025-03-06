package com.javarush.bulimova;

public class Validator extends RuntimeException {
    public Validator() {
    }

    public Validator(String message) {
        super(message);
    }

    public Validator(String message, Throwable cause) {
        super(message, cause);
    }

    public Validator(Throwable cause) {
        super(cause);
    }


}
