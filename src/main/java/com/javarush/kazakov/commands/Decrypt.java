package com.javarush.kazakov.commands;

import java.nio.file.Path;
import java.util.Scanner;

import static com.javarush.kazakov.constants.Constants.DEFAULT_DECRYPTED_PATH;
import static com.javarush.kazakov.constants.Constants.DEFAULT_ENCRYPTED_PATH;
import static com.javarush.kazakov.constants.InteractiveConstants.*;

public class Decrypt extends AbstractCommand {

    public Decrypt() {
        input = DEFAULT_ENCRYPTED_PATH;
        output = DEFAULT_DECRYPTED_PATH;
        key = 1;
        scanner = new Scanner(System.in);
    }

    public Decrypt(Path input, Path output, int key) {
        this.input = input;
        this.output = output;
        this.key = negateValue(key);
    }

    @Override
    public void interact() {
        input = specify(SPECIFY_ENCRYPTED_INPUT_MESSAGE, input);
        output = specify(SPECIFY_OUTPUT_MESSAGE, output);
        key = negateValue(specify(SPECIFY_KEY_MESSAGE, key));
        System.out.println(call());
    }

    @Override
    public String call() {
        return translate(DECRYPTION_IS_DONE_MESSAGE);
    }

    private int negateValue(int val) {
        return val < 0 ? val : -val;
    }
}
