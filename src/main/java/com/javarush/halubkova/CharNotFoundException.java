package com.javarush.halubkova;

public class CharNotFoundException extends Exception{
    public CharNotFoundException(){
        super("Символ не найден в алфавите");
    }
}
