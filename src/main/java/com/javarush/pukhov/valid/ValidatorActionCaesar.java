package com.javarush.pukhov.valid;

import java.util.List;

import com.javarush.pukhov.command.Action;
import com.javarush.pukhov.exception.ActionException;
import com.javarush.pukhov.view.console.constants.Messages;

public class ValidatorActionCaesar<T extends List<String>> extends ValidatorAction<T> {

    private int key;

    public ValidatorActionCaesar(Action action) {
        super(action);
    }

    @Override
    public boolean check(T parameters) {
        super.check(parameters);
        try {
            key = Integer.parseInt(parameters.get(2));
        } catch (NumberFormatException e) {
            String message = String.format(Messages.INCORRECT_NUMBER, key);
            throw new ActionException(message, e);
        }
        return true;
    }

    /**
     * @return the key
     */
    public int getKey() {
        return key;
    }

}
