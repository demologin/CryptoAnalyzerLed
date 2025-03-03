package com.javarush.pukhov.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.StringJoiner;

public class ErrorHandlerConsole implements ErrorHandler {

    final String START_ERROR_STACK = String.format("Exception in thread \"%s\" ", Thread.currentThread().getName());
    final StringBuilder stackBuilder = new StringBuilder(START_ERROR_STACK);
    private final StringWriter sw = new StringWriter();
    private final PrintWriter pw = new PrintWriter(sw);
    private final StringJoiner errorMessage = new StringJoiner(" and ", "Message: ", "\n");

    @Override
    public void addProcessing(String message, Exception e) {
        errorMessage.add(message);
        e.printStackTrace(pw);
    }

    @Override
    public String getMessageError() {
        stackBuilder.append(sw.toString());
        int indexLastLS = stackBuilder.lastIndexOf(System.lineSeparator());
        int indexEndSB = stackBuilder.length();
        /* Delete last \n */
        stackBuilder.replace(indexLastLS, indexEndSB, "");
        return errorMessage.toString() + stackBuilder.toString();
    }

}
