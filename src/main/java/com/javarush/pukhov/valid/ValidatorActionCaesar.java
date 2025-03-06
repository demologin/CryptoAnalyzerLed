package com.javarush.pukhov.valid;

import java.util.List;

import com.javarush.pukhov.command.Action;
import com.javarush.pukhov.constant.Constants;
import com.javarush.pukhov.exception.ActionException;
import com.javarush.pukhov.view.console.constants.Messages;

public class ValidatorActionCaesar<T extends List<String>> extends ValidatorCipherAction<T> {


    private int key;

    public ValidatorActionCaesar(Action action) {
        super(action);
    }

    @Override
    public boolean check(T parameters) {
        super.check(parameters);
        int indexKey = container.getIndexParameter(Constants.KEY);
        try {
            key = Integer.parseInt(parameters.get(indexKey));
        } catch (NumberFormatException e) {
            String message = String.format(Messages.INCORRECT_NUMBER, parameters.get(indexKey));
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
