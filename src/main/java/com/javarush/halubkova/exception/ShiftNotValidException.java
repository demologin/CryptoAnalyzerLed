package com.javarush.halubkova.exception;

public class ShiftNotValidException extends Exception {
    public ShiftNotValidException(){
        super("Введите корректное значение ключа");
    }
}
