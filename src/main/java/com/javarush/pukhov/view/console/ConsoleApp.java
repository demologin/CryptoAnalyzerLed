package com.javarush.pukhov.view.console;

import com.javarush.pukhov.command.Action;
import com.javarush.pukhov.command.Exit;
import com.javarush.pukhov.io.Input;
import com.javarush.pukhov.io.Output;
import com.javarush.pukhov.view.console.constants.Menu;
import com.javarush.pukhov.view.console.constants.Messages;

public class ConsoleApp {
    Input input;
    Output output;

    /**
     * @param input
     * @param output
     */
    public ConsoleApp(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void start(){
        Action action = null;
        do {
            output.print(Messages.REQUEST_SELECT_MODE);
            output.print(Menu.get());
        } while (!(action instanceof Exit));
    }

}
