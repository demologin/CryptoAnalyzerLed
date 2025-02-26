package com.javarush.pukhov;

import com.javarush.pukhov.controller.Controller;
import com.javarush.pukhov.runner.ConsoleRunner;
import com.javarush.pukhov.runner.Runner;

public class ApplicationAnalyzer {


    private ApplicationAnalyzer() {
    }

    public static void main(String[] args) {
        ApplicationAnalyzer analyzer = new ApplicationAnalyzer();
        Runner runner = new ConsoleRunner();
        Controller controller = new Controller(runner);
        analyzer.start(controller);
    }

    private void start(Controller controller) {
        controller.start();
    }
}
