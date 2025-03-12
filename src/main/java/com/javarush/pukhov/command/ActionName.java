package com.javarush.pukhov.command;

import com.javarush.pukhov.constant.Constants;

public enum ActionName {
    ENCRYPT(Constants.ENCRYPT),
    DECRYPT(Constants.DECRYPT),
    BRUTEFORCE(Constants.BRUTE_FORCE),
    ANALYZE(Constants.ANALYZE),
    EXIT(Constants.EXIT);

    /**
     * @param actionName
     */
    private ActionName(String actionName) {
        this.actionNameString = actionName;
    }

    private final String actionNameString;

    @Override
    public String toString() {
        return actionNameString;
    }

}
