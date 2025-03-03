package com.javarush.pukhov.command;

import static com.javarush.pukhov.view.console.constants.Messages.FILE_ANALYZE;
import static com.javarush.pukhov.view.console.constants.Messages.FILE_BRUTEFORCE;
import static com.javarush.pukhov.view.console.constants.Messages.FILE_DECRYPT;
import static com.javarush.pukhov.view.console.constants.Messages.FILE_DICTIONARY;
import static com.javarush.pukhov.view.console.constants.Messages.FILE_ENCRYPT;
import static com.javarush.pukhov.view.console.constants.Messages.FILE_SOURCE;
import static com.javarush.pukhov.view.console.constants.Messages.INPUT_DESTINATION_ANALYZE;
import static com.javarush.pukhov.view.console.constants.Messages.INPUT_DESTINATION_BRUTEFORCE;
import static com.javarush.pukhov.view.console.constants.Messages.INPUT_DESTINATION_ENCRYPT;
import static com.javarush.pukhov.view.console.constants.Messages.INPUT_DESTINATION_KEY;
import static com.javarush.pukhov.view.console.constants.Messages.INPUT_DICTIONARY;
import static com.javarush.pukhov.view.console.constants.Messages.INPUT_KEY;
import static com.javarush.pukhov.view.console.constants.Messages.INPUT_SOURCE_DECRYPT;
import static com.javarush.pukhov.view.console.constants.Messages.INPUT_SOURCE_ENCRYPT;
import static com.javarush.pukhov.view.console.constants.Messages.KEY;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.javarush.pukhov.exception.ErrorHandler;
import com.javarush.pukhov.exception.ErrorHandlerConsole;
import com.javarush.pukhov.valid.Validator;
import com.javarush.pukhov.valid.ValidatorActionContainer;

public class ActionContainer {

    private final Action action;
    private final List<String> subqueries;
    private final List<String> defaultFiles;
    private static final Map<String, Action> mapAction = new HashMap<>();
    private static final Map<String, List<String>> mapDefaultFiles = new HashMap<>();
    private static final Map<String, List<String>> mapSubqueries = new HashMap<>();

    static {
        final ActionName[] keys = ActionName.values();
        final Action[] valuesAction = {
                new EncryptorCaesar(),
                new DecryptKeys(),
                new Bruteforce(),
                new DecryptAnalyze(),
                new Exit()
        };

        final List<String>[] valuesFile = new List[] {
                List.of(FILE_SOURCE, FILE_ENCRYPT, KEY),
                List.of(FILE_ENCRYPT, FILE_DECRYPT, KEY),
                List.of(FILE_ENCRYPT, FILE_BRUTEFORCE),
                List.of(FILE_ENCRYPT, FILE_DICTIONARY, FILE_ANALYZE),
                Collections.EMPTY_LIST
        };

        final List<String>[] valuesSubquery = new List[] {
                List.of(INPUT_SOURCE_ENCRYPT,
                        INPUT_DESTINATION_ENCRYPT,
                        INPUT_KEY),
                List.of(INPUT_SOURCE_DECRYPT,
                        INPUT_DESTINATION_KEY,
                        INPUT_KEY),
                List.of(INPUT_SOURCE_DECRYPT,
                        INPUT_DESTINATION_BRUTEFORCE),
                List.of(INPUT_SOURCE_DECRYPT,
                        INPUT_DICTIONARY,
                        INPUT_DESTINATION_ANALYZE),
                Collections.EMPTY_LIST
        };

        for (int i = 0; i < keys.length; i++) {
            mapAction.put(keys[i].toString(), valuesAction[i]);
            mapSubqueries.put(keys[i].toString(), valuesSubquery[i]);
            mapDefaultFiles.put(keys[i].toString(), valuesFile[i]);
        }
    }

    private ActionContainer(String actionName) {
        action = mapAction.get(actionName);
        subqueries = mapSubqueries.get(actionName);
        defaultFiles = mapDefaultFiles.get(actionName);
    }

    public static ActionContainer get(String actionString) {
        ActionContainer actionContainer = null;
        ErrorHandler errorHandler = new ErrorHandlerConsole();
        Validator<String> validator = new ValidatorActionContainer<>(errorHandler);
        if (validator.check(actionString)) {
            String validValue = validator.getValidValue();
            actionContainer = new ActionContainer(validValue);
            return actionContainer;
        }
        return actionContainer;
    }

    /**
     * @return the action
     */
    public Action getAction() {
        return action;
    }

    /**
     * @return the subqueries
     */
    public List<String> getSubqueries() {
        return subqueries;
    }

    /**
     * @return the defaultFiles
     */
    public List<String> getDefaultFiles() {
        return defaultFiles;
    }

}
