package com.javarush.kazakov.commands;

import com.javarush.kazakov.core.Analyzer;
import com.javarush.kazakov.core.Collector;
import com.javarush.kazakov.core.files.FileManager;

import java.nio.file.Path;
import java.util.Scanner;

import static com.javarush.kazakov.constants.Constants.*;
import static com.javarush.kazakov.constants.InteractiveConstants.HACKING_KEY_MESSAGE;
import static com.javarush.kazakov.constants.InteractiveConstants.SPECIFY_ENCRYPTED_INPUT_MESSAGE;

public class BruteForce extends AbstractCommand {

    public BruteForce() {
        input = DEFAULT_ENCRYPTED_PATH;
        output = DEFAULT_DECRYPTED_PATH;
        scanner = new Scanner(System.in);
    }

    public BruteForce(Path input) {
        this.input = input;
    }

    @Override
    public void interact() {
        input = specify(SPECIFY_ENCRYPTED_INPUT_MESSAGE, input);
        System.out.println(call());
        decryptOffer();
    }

    @Override
    public String call() {
        FileManager fileManager = new FileManager(input);
        Analyzer analyzer = new Analyzer(fileManager.collectData(), new Collector(DEFAULT_INPUT_PATH));
        long start = System.currentTimeMillis();
        key = analyzer.guessKey();
        long end = System.currentTimeMillis();
        return String.format(HACKING_KEY_MESSAGE, end - start, key);
    }
}
