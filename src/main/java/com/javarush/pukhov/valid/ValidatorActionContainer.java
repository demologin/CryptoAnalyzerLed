package com.javarush.pukhov.valid;

import com.javarush.pukhov.command.ActionName;
import com.javarush.pukhov.exception.ActionContainerException;
import com.javarush.pukhov.exception.ErrorHandler;
import com.javarush.pukhov.view.console.constants.Messages;

public class ValidatorActionContainer<T extends CharSequence> implements Validator<T> {

    private final ErrorHandler errorHandler;
    private T validValue;
    private T checkedObject;

    /**
     * @param handler
     */
    public ValidatorActionContainer(ErrorHandler handler) {
        this.errorHandler = handler;
    }

    @Override
    public boolean check(T object) {

        checkedObject = object;
        int index = getIndexActionNameFor(checkedObject);
        if (index != -1) {
            validValue = (T) getActionNameFor(index);
        } else {
            validValue = (T) getActionNameFor(checkedObject);
        }
        if (!validValue.isEmpty()) {
            return true;
        } else {
            throw new ActionContainerException(errorHandler.getMessageError());
        }
    }

    private String getActionNameFor(int index) {
        try {
            return ActionName.values()[index - 1].toString();
        } catch (ArrayIndexOutOfBoundsException e) {
            String message = String.format(Messages.INCORRECT_NUMBER,
                    checkedObject);
            errorHandler.addProcessing(message, e);
            return "";
        }
    }

    private String getActionNameFor(T object) {
        try {
            if (object instanceof String checkString) {
                ActionName actionName = ActionName.valueOf(checkString.toUpperCase().replace(" ", ""));
                return actionName.toString();
            }
        } catch (IllegalArgumentException e) {
            String message = String.format(Messages.INCORRECT_ACTION, object);
            errorHandler.addProcessing(message, e);
        }
        return "";
    }

    private int getIndexActionNameFor(T object) {
        try {
            String checkString = object.toString();
            return Integer.parseInt(checkString);
        } catch (NumberFormatException e) {
            String message = String.format(Messages.INCORRECT_NUMBER,
                    object);
            errorHandler.addProcessing(message, e);
            return -1;
        }
    }

    @Override
    public T getValidValue() {
        return validValue;
    }

}
