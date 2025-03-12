package com.javarush.pukhov;

import com.javarush.pukhov.controller.Controller;
import com.javarush.pukhov.io.ConsolePrinter;
import com.javarush.pukhov.io.OutputError;
import com.javarush.pukhov.runner.ConsoleRunner;
import com.javarush.pukhov.runner.Runner;

public class ApplicationAnalyzer {

    private ApplicationAnalyzer() {
    }

    public static void main(String[] args) {
        ApplicationAnalyzer analyzer = new ApplicationAnalyzer();
        Runner runner = new ConsoleRunner();
        OutputError outputError = new ConsolePrinter();
        Controller controller = new Controller(runner, outputError);
        analyzer.start(controller);
    }

    private void start(Controller controller) {
        controller.start();
    }
}
