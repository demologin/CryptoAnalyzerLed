package com.javarush.pukhov.runner;

import com.javarush.pukhov.io.ConsoleInput;
import com.javarush.pukhov.io.ConsolePrinter;
import com.javarush.pukhov.io.Input;
import com.javarush.pukhov.io.Output;
import com.javarush.pukhov.io.OutputError;
import com.javarush.pukhov.view.console.ConsoleApp;

public class ConsoleRunner implements Runner {

    @Override
    public void run() {
        Input input = new ConsoleInput();
        OutputError outputError = new ConsolePrinter();
        Output output = outputError;
        ConsoleApp app = new ConsoleApp(input, output, outputError);
        app.start();
    }

}
