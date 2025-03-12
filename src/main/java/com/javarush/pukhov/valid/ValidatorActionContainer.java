package com.javarush.pukhov.valid;

import com.javarush.pukhov.command.ActionName;
import com.javarush.pukhov.exception.ActionContainerException;
import com.javarush.pukhov.exception.ErrorHandler;
import com.javarush.pukhov.view.console.constants.Messages;

public class ValidatorActionContainer implements Validator<String> {

    private final ErrorHandler errorHandler;
    private String validValue;
    private String checkedObject;

    /**
     * @param handler
     */
    public ValidatorActionContainer(ErrorHandler handler) {
        this.errorHandler = handler;
    }

    @Override
    public boolean check(String object) {

        checkedObject = object;
        int index = getIndexActionNameFor(checkedObject);
        if (index != -1) {
            validValue = getActionNameFor(index);
        } else {
            validValue = getActionNameFor(checkedObject);
        }
        if (!validValue.isEmpty()) {
            return true;
        } else {
            throw new ActionContainerException(errorHandler.getMessageError());
        }
    }

    private String getActionNameFor(int index) {
        int startIndex = 1;
        int endIndex = ActionName.values().length;
        try {
            if (index < startIndex || index > endIndex) {
                throw new ArrayIndexOutOfBoundsException();
            }
            return ActionName.values()[index - 1].toString();
        } catch (ArrayIndexOutOfBoundsException e) {
            String message = String.format(Messages.INCORRECT_INDEX,
                    checkedObject, startIndex, endIndex);
            errorHandler.addProcessing(message, e);
            return "";
        }
    }

    private String getActionNameFor(String object) {
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

    private int getIndexActionNameFor(String object) {
        try {
            String checkString = object;
            return Integer.parseInt(checkString);
        } catch (NumberFormatException e) {
            String message = String.format(Messages.INCORRECT_NUMBER,
                    object);
            errorHandler.addProcessing(message, e);
            return -1;
        }
    }

    @Override
    public String getValidValue() {
        return validValue;
    }

}
