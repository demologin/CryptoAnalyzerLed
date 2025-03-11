package com.javarush.halubkova.exception;

public class CharNotFoundException extends RuntimeException {
    public CharNotFoundException() {
        super("Символ не найден в алфавите");
    }
}
