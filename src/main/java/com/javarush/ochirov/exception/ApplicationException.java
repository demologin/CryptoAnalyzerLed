package com.javarush.ochirov.exception;

import com.javarush.ochirov.StringConstantsContainer;

public class ApplicationException extends RuntimeException
{
    private final Integer errorCode;

    public ApplicationException(String message, Throwable cause, ErrorCode errorCode)
    {
        super(message, cause);
        this.errorCode = errorCode.getCode();
    }

    public ApplicationException(String message, ErrorCode errorCode)
    {
        super(message);
        this.errorCode = errorCode.getCode();
    }

    @Override
    public String toString()
    {
        return StringConstantsContainer.ERROR_CODE + errorCode.toString();
    }
}
