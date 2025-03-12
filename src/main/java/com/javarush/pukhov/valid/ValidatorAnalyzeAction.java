package com.javarush.pukhov.valid;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import com.javarush.pukhov.command.Action;
import com.javarush.pukhov.constant.Constants;
import com.javarush.pukhov.constant.ErrorMessages;
import com.javarush.pukhov.exception.ActionException;
import com.javarush.pukhov.util.BuilderPath;

public class ValidatorAnalyzeAction<T extends List<String>> extends ValidatorCipherAction<T> {

    private Path dictionary;

    /**
     * @param action
     */
    public ValidatorAnalyzeAction(Action action) {
        super(action);
    }

    @Override
    public boolean check(T parameters) {
        super.check(parameters);
        int countParameters = container.getDefaultValues().size();
        try {
            if (parameters.size() == countParameters) {
                int indexDictionary = container.getIndexParameter(Constants.DICTIONARY);
                dictionary = BuilderPath.buildPath(parameters.get(indexDictionary));
                if (Files.notExists(dictionary)) {
                    String message = String.format(ErrorMessages.FILE_NOT_FOUND, dictionary);
                    throw new ActionException(message, new FileNotFoundException());
                }
            }
        } catch (IllegalArgumentException e) {
            String message = String.format(ErrorMessages.INCORRECT_PATH_FILE, dictionary);
            throw new ActionException(message, e);
        }
        return true;
    }

    /**
     * @return the dictionary
     */
    public Path getDictionary() {
        return dictionary;
    }

}
