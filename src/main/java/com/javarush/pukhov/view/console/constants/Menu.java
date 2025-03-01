package com.javarush.pukhov.view.console.constants;

import com.javarush.pukhov.command.ActionName;

public final class Menu {

    private Menu() {
    }

    private static final String MENU_STRING;

    static {
        StringBuilder menuBuilder = new StringBuilder();

        ActionName[] listActions = ActionName.values();
        for (int i = 0; i < listActions.length; i++) {
            menuBuilder.append(i + 1).append(".").append(listActions[i]).append("\n");
        }
        MENU_STRING = menuBuilder.toString();
    }

    public static String get() {
        return MENU_STRING;
    }

}
