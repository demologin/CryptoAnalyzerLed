package com.javarush.halubkova;

public class FileNotFoundException extends Exception{
    public FileNotFoundException(){
        super("Указанный файл не существует");
    }
}
