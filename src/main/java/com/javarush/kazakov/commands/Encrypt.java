package com.javarush.kazakov.commands;

import java.nio.file.Path;
import java.util.Scanner;

import static com.javarush.kazakov.constants.Constants.DEFAULT_ENCRYPTED_PATH;
import static com.javarush.kazakov.constants.Constants.DEFAULT_INPUT_PATH;
import static com.javarush.kazakov.constants.InteractiveConstants.*;

public class Encrypt extends AbstractCommand {

    public Encrypt() {
        input = DEFAULT_INPUT_PATH;
        output = DEFAULT_ENCRYPTED_PATH;
        key = 1;
        scanner = new Scanner(System.in);
    }

    public Encrypt(Path input, Path output, int key) {
        this.input = input;
        this.output = output;
        this.key = key;
    }

    @Override
    public void interact() {
        input = specify(SPECIFY_INPUT_MESSAGE, input);
        output = specify(SPECIFY_OUTPUT_MESSAGE, output);
        key = specify(SPECIFY_KEY_MESSAGE, key);
        System.out.println(call());
    }

    @Override
    public String call() {
        return translate(ENCRYPTION_IS_DONE_MESSAGE);
    }
}
