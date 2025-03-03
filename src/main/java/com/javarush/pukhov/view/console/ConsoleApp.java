package com.javarush.pukhov.view.console;

import java.util.ArrayList;
import java.util.List;

import com.javarush.pukhov.command.Action;
import com.javarush.pukhov.command.Exit;
import com.javarush.pukhov.io.Input;
import com.javarush.pukhov.io.Output;
import com.javarush.pukhov.view.console.menu.Menu;

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

    public void start() {
        Action action = null;
        do {
                Menu menu = Menu.getInstance();
                output.print(menu.show());
                action = menu.selectAction(input.read());
                List<String> parameters = new ArrayList<>(4);
                while (menu.isExistsSubqueries()) {
                    output.print(menu.showSubquery());
                    String answer = input.read();
                    if (answer.isEmpty()) {
                        parameters.add(menu.getDefaultValue());
                    }
                }
                action.execute(parameters);
        } while (!(action instanceof Exit));
    }

}
