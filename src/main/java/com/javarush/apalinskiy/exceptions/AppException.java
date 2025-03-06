package com.javarush.apalinskiy.exceptions;

public class AppException extends RuntimeException {
    public AppException(String message) {
        System.out.println(message);
    }
}
