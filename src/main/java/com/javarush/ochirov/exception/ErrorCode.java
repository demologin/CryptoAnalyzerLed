package com.javarush.ochirov.exception;

public enum ErrorCode
{
    PARSE_KEY_ERROR(701),
    INCORRECT_FILE_ERROR(702),
    INCORRECT_MODE_ERROR(703);

    private final int code;

    ErrorCode(int code)
    {
        this.code = code;
    }

    public int getCode()
    {
        return code;
    }
}
