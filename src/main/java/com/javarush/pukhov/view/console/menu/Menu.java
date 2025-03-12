package com.javarush.pukhov.view.console.menu;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringJoiner;

import com.javarush.pukhov.command.Action;
import com.javarush.pukhov.command.ActionContainer;
import com.javarush.pukhov.command.ActionName;
import com.javarush.pukhov.view.console.constants.Messages;

public final class Menu {

    private Menu() {
    }

    private static final String MENU_STRING;
    private static Menu menu;
    private Queue<String> subqueries;
    private String defaultValue;
    private Queue<String> defaultValues;

    static {
        StringBuilder menuBuilder = new StringBuilder();
        StringJoiner joiner = new StringJoiner("\n", Messages.LINE, Messages.LINE);
        ActionName[] listActions = ActionName.values();

        joiner.add("\n" + Messages.REQUEST_SELECT_MODE);

        for (int i = 0; i < listActions.length; i++) {
            menuBuilder.append(i + 1).append(". ").append(listActions[i]).append("\n");
        }

        joiner.add(menuBuilder);
        MENU_STRING = joiner.toString();
    }

    public static Menu getInstance() {
        if (menu == null) {
            menu = new Menu();
        }
        return menu;
    }

    public Action selectAction(String action) {
        ActionContainer actionContainer = ActionContainer.get(action);
        subqueries = new ArrayDeque<>(actionContainer.getSubqueries());
        defaultValues = new ArrayDeque<>(actionContainer.getDefaultValues());
        return actionContainer.getAction();
    }

    public boolean isExistsSubqueries() {
        return !subqueries.isEmpty();
    }

    public String showSubquery() {
        defaultValue = defaultValues.poll();
        return subqueries.poll();
    }

    /**
     * @return the defaultFile
     */
    public String getDefaultValue() {
        return defaultValue;
    }

    public String show() {
        return MENU_STRING;
    }

}
