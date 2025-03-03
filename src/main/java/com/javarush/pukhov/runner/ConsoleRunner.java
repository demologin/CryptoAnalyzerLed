package com.javarush.pukhov.runner;

import com.javarush.pukhov.io.ConsoleInput;
import com.javarush.pukhov.io.ConsolePrinter;
import com.javarush.pukhov.io.Input;
import com.javarush.pukhov.io.Output;
import com.javarush.pukhov.view.console.ConsoleApp;

public class ConsoleRunner implements Runner {

    @Override
    public void run() {
        Input input = new ConsoleInput();
        Output output = new ConsolePrinter();
        ConsoleApp app = new ConsoleApp(input, output);
        app.start();
    }

}
