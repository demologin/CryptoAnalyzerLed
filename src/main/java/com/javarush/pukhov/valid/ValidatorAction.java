package com.javarush.pukhov.valid;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import com.javarush.pukhov.command.Action;
import com.javarush.pukhov.command.ActionContainer;
import com.javarush.pukhov.constant.Constants;
import com.javarush.pukhov.exception.ActionException;
import com.javarush.pukhov.util.BuilderPath;

public class ValidatorAction<T extends List<String>> implements Validator<T> {

    private final Action action;
    private T validValue;
    private Path source;
    private Path destination;

    /**
     * @param action
     */
    public ValidatorAction(Action action) {
        this.action = action;
    }

    @Override
    public boolean check(T parameters) {
        ActionContainer container = ActionContainer.get(action.toString());
        int countParameters = container.getDefaultValues().size();
        try {
            if (parameters.size() == countParameters) {
                source = BuilderPath.buildPath(parameters.get(0));
                destination = BuilderPath.buildPath(parameters.get(1));
                if (Files.notExists(source)) {
                    String message = String.format(Constants.FILE_NOT_FOUND, source);
                    throw new ActionException(message, new FileNotFoundException());
                }
            }
        } catch (IllegalArgumentException e) {
            String message = String.format(Constants.INCORRECT_PATH_FILE, source);
            throw new ActionException(message, e);
        }
        validValue = parameters;
        return true;
    }

    @Override
    public T getValidValue() {
        return validValue;
    }

    /**
     * @return the src
     */
    public Path getSource() {
        return source;
    }

    /**
     * @return the destination
     */
    public Path getDestination() {
        return destination;
    }

}
