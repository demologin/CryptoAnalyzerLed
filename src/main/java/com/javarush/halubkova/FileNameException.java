package com.javarush.halubkova;

public class FileNameException extends Exception{
    public FileNameException(){
        super("Введите корректное имя файла");
    }
}
