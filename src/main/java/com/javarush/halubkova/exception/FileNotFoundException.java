package com.javarush.halubkova.exception;

public class FileNotFoundException extends Exception{
    public FileNotFoundException(){
        super("Указанный файл не существует");
    }
}
