package com.javarush.tomchuk.constant;


public enum Result {
    SUCCESSFULLY_DECODED(),
    SUCCESSFULLY_ENCODED(),
    SUCCESSFULLY_BRUTEFORCED(),
    SUCCESSFULLY_ANALYZED(),
    SUCCESSFULLY_EXITED(),
    OPERATION_ERROR();

    public static String getMessage(Result result) {
        return switch (result) {
            case SUCCESSFULLY_DECODED -> "File was successfully decoded!";
            case SUCCESSFULLY_ENCODED -> "File was successfully encoded!";
            case SUCCESSFULLY_BRUTEFORCED -> "File was successfully bruteforced!";
            case SUCCESSFULLY_ANALYZED -> "File was successfully analyzed and decoded!";
            case SUCCESSFULLY_EXITED -> "You successfully returned to the Menu!";
            case OPERATION_ERROR -> "There was an ERROR. Program terminated with exit command";
        };
    }


    public static Result getResult(StandartOperation operationName, ResultCode resultCode) {
        if (resultCode != ResultCode.ERROR) {
            return switch (operationName) {
                case DECODE -> SUCCESSFULLY_DECODED;
                case ENCODE -> SUCCESSFULLY_ENCODED;
                case BRUTFORCE -> SUCCESSFULLY_BRUTEFORCED;
                case ANALYZE -> SUCCESSFULLY_ANALYZED;
                case EXIT -> SUCCESSFULLY_EXITED;
                default -> OPERATION_ERROR;
            };
        }
        return OPERATION_ERROR;
    }

}
