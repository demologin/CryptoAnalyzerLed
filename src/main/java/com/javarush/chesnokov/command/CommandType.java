package com.javarush.chesnokov.command;

public enum CommandType {
    ENCRYPT(1, "Encrypt"),
    DECRYPT(2, "Decrypt"),
    BRUTE_FORCE(3, "Brute force"),
    EXIT(5, "Exit");

    private final int code;
    private final String commandName;

    CommandType(int code, String commandName) {
        this.code = code;
        this.commandName = commandName;
    }

    public int getCode() {
        return code;
    }

    public String getCommandName() {
        return commandName;
    }

    public static CommandType fromCode(int code) {
        for (CommandType com : values()) {
            if (com.code == code) {
                return com;
            }
        }
        return null;
    }
}
