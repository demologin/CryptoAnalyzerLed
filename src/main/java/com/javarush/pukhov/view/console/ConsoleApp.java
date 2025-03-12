package com.javarush.pukhov.view.console;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import com.javarush.pukhov.command.Action;
import com.javarush.pukhov.command.Exit;
import com.javarush.pukhov.io.Input;
import com.javarush.pukhov.io.Output;
import com.javarush.pukhov.view.console.menu.Menu;

public class ConsoleApp {
    Input<InputStream, Reader> input;
    Output<OutputStream, Writer> output;

    /**
     * @param input
     * @param output
     */
    public ConsoleApp(Input<InputStream, Reader> input, Output<OutputStream, Writer> output) {
        this.input = input;
        this.output = output;
    }

    public void start() {
        Action action;
        Menu menu = Menu.getInstance();
        do {
            output.print(menu.show());
            action = menu.selectAction(input.read());
            List<String> parameters = new ArrayList<>(4);
            while (menu.isExistsSubqueries()) {
                output.print(menu.showSubquery());
                String answer = input.read();
                if (answer.isEmpty()) {
                    parameters.add(menu.getDefaultValue());
                } else {
                    parameters.add(answer);
                }
            }
            action.execute(parameters);
        } while (!(action instanceof Exit));
    }

}
