package com.javarush.halubkova.exception;

public class FileNameException extends Exception{
    public FileNameException(){
        super("Введите корректное имя файла");
    }
}
