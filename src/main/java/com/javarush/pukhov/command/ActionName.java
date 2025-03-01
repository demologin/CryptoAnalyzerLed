package com.javarush.pukhov.command;

import com.javarush.pukhov.constant.Constants;

public enum ActionName {
    ENCRYPT(Constants.ENCRYPT),
    DECRYPT_KEY(Constants.DECRYPT),
    BRUTEFORCE(Constants.BRUTE_FORCE),
    ANALYZE(Constants.ANALYZE),
    EXIT(Constants.EXIT);

    /**
     * @param actionName
     */
    private ActionName(String actionName) {
        this.actionName = actionName;
    }

    private String actionName;

    @Override
    public String toString() {
        return actionName;
    }

}
