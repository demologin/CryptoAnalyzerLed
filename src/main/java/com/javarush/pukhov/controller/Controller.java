package com.javarush.pukhov.controller;

import com.javarush.pukhov.exception.ApplicationException;
import com.javarush.pukhov.io.Output;
import com.javarush.pukhov.runner.Runner;

public class Controller {

    private final Runner runner;
    private final Output outputError;

    public Controller(Runner runner, Output outputError) {
        this.runner = runner;
        this.outputError = outputError;
    }

    public void start() {
        try {
            runner.run();
        } catch (ApplicationException e) {
            outputError.print(e);
        }
    }

}
