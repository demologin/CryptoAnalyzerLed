package com.javarush.pukhov.command;

import java.util.HashMap;
import java.util.Map;

public class ActionContainer {

    private static ActionContainer actionContainer;
    private final Action action;
    private static final Map<String, Action> mapAction = new HashMap<>();

    static {
        final ActionName[] keys = ActionName.values();
        final Action[] values = {
                new EncryptorCaesar(),
                new DecryptKeys(),
                new Bruteforce(),
                new DecryptAnalyze(),
                new Exit()
        };

        for (int i = 0; i < keys.length; i++) {
            mapAction.put(keys[i].toString(), values[i]);
        }
    }

    private ActionContainer(String actionName) {
        action = mapAction.get(actionName);
    }

    public static ActionContainer get(int numberAction) {
        if (actionContainer == null) {
            String actionName = ActionName.values()[numberAction - 1].toString();
            actionContainer = new ActionContainer(actionName);
        }
        return actionContainer;
    }

    /**
     * @return the action
     */
    public Action getAction() {
        return action;
    }

}
