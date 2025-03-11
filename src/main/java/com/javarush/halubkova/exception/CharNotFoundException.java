package com.javarush.halubkova.exception;

public class CharNotFoundException extends Exception{
    public CharNotFoundException(){
        super("Символ не найден в алфавите");
    }
}
