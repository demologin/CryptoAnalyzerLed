package com.javarush.kazakov.commands;

import com.javarush.kazakov.core.Analyzer;
import com.javarush.kazakov.core.files.FileManager;

import java.nio.file.Path;
import java.util.Scanner;

import static com.javarush.kazakov.constants.Constants.*;
import static com.javarush.kazakov.constants.InteractiveConstants.*;

public class StatAnalysis extends AbstractCommand {

    public StatAnalysis() {
        input = DEFAULT_ENCRYPTED_PATH;
        representative = DEFAULT_REPRESENT_PATH;
        output = DEFAULT_DECRYPTED_PATH;
        scanner = new Scanner(System.in);
    }

    public StatAnalysis(Path input, Path representative){
        this.input = input;
        this.representative = representative;
    }

    @Override
    public void interact() {
        input = specify(SPECIFY_ENCRYPTED_INPUT_MESSAGE, input);
        representative = specify(SPECIFY_REPRESENT_MESSAGE, representative);
        System.out.println(call());
        decryptOffer();
    }

    @Override
    public String call() {
        FileManager inputFileManager = new FileManager(input);
        FileManager repFileManager = new FileManager(representative);
        Analyzer analyzer = new Analyzer(inputFileManager.collectData(), repFileManager.collectData());
        long start = System.currentTimeMillis();
        key = analyzer.getKey();
        long end = System.currentTimeMillis();
        return String.format(ANALYSIS_KEY_MESSAGE, end - start, key);
    }
}
