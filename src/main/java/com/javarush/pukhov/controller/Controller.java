package com.javarush.pukhov.controller;

import com.javarush.pukhov.exception.ApplicationException;
import com.javarush.pukhov.io.OutputError;
import com.javarush.pukhov.runner.Runner;

public class Controller {

    private final Runner runner;
    private final OutputError outputError;
    private boolean isError;

    public Controller(Runner runner, OutputError outputError) {
        this.runner = runner;
        this.outputError = outputError;
    }

    public void start() {
        do {
            try {
                runner.run();
            } catch (ApplicationException e) {
                isError = true;
                outputError.print(e);
            }
        } while (isError);
    }
}
