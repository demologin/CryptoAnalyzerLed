package com.javarush.pukhov.command;

import java.io.OutputStream;
import java.io.Writer;
import java.util.List;

import com.javarush.pukhov.constant.Constants;
import com.javarush.pukhov.io.ConsolePrinter;
import com.javarush.pukhov.io.Output;

public final class Exit implements Action {

    Output<OutputStream, Writer> output = new ConsolePrinter();

    @Override
    public void execute(List<String> parameters) {
        output.print(Constants.EXIT_PROGRAM);
    }
}
