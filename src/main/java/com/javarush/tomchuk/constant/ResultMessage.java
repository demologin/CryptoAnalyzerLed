package com.javarush.tomchuk.constant;


public enum ResultMessage {
    SUCCESSFULLY_DECODED,
    SUCCESSFULLY_ENCODED,
    SUCCESSFULLY_BRUTFORCED,
    SUCCESSFULLY_ANALYZED,
    OPERATION_ERROR,
    UNEXPECTED_RESULT;

    public static ResultMessage getResultMessage(String operationName, ResultCode resultCode) {
        if (resultCode != ResultCode.ERROR) {
            return switch (operationName) {
                case "DECODE" -> SUCCESSFULLY_DECODED;
                case "ENCODE" -> SUCCESSFULLY_ENCODED;
                case "BRUTFORCE" -> SUCCESSFULLY_BRUTFORCED;
                case "ANALYZE" -> SUCCESSFULLY_ANALYZED;
                default -> UNEXPECTED_RESULT;
            };
        }
        return OPERATION_ERROR;
    }

}
