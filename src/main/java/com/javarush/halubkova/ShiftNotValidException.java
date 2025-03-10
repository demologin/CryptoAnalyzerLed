package com.javarush.halubkova;

public class ShiftNotValidException extends Exception {
    public ShiftNotValidException(){
        super("Введите корректное значение ключа");
    }
}
