package com.javarush.pukhov.runner;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

import com.javarush.pukhov.io.ConsoleInput;
import com.javarush.pukhov.io.ConsolePrinter;
import com.javarush.pukhov.io.Input;
import com.javarush.pukhov.io.Output;
import com.javarush.pukhov.view.console.ConsoleApp;

public class ConsoleRunner implements Runner {

    @Override
    public void run() {
        Input<InputStream, Reader> input = new ConsoleInput<>();
        Output<OutputStream, Writer> output = new ConsolePrinter<>();
        ConsoleApp app = new ConsoleApp(input, output);
        app.start();
    }
}
