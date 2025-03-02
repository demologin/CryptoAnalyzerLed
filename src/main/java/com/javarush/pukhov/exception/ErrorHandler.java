package com.javarush.pukhov.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.StringJoiner;

public class ErrorHandler {
    private final String START_ERROR_STACK = String.format("Exception in thread \"%s\" ",
            Thread.currentThread().getName());
    private final StringBuilder stackBuilder = new StringBuilder(START_ERROR_STACK);
    private final StringWriter sw = new StringWriter();
    private final PrintWriter pw = new PrintWriter(sw);
    private final StringJoiner errorMessage = new StringJoiner(" and ", "Message: ", "\n");

    public void addProcessing(String message, Exception e) {
        errorMessage.add(message);
        e.printStackTrace(pw);
    }

    public String getMessageError() {
        stackBuilder.append(sw.toString());
        return errorMessage.toString() + stackBuilder.toString();
    }

}
