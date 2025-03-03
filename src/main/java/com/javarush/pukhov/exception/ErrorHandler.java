package com.javarush.pukhov.exception;

public interface ErrorHandler {

    public void addProcessing(String message, Exception e);
    public String getMessageError();

}
