package com.javarush.pukhov.controller;

import com.javarush.pukhov.runner.Runner;

public class Controller {

    private final Runner runner;

    public Controller(Runner runner) {
        this.runner = runner;
    }

    public void start() {
        try {
            runner.run();
        } catch (Exception e) {
            /*
             * 
             */
        }
    }

}
