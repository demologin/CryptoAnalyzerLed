package com.javarush.kazakov.commands.climode;

import com.javarush.kazakov.commands.Decrypt;
import com.javarush.kazakov.commands.StatAnalysis;

import java.nio.file.Path;

import static com.javarush.kazakov.constants.CLIConstants.*;
import static picocli.CommandLine.*;

@Command(name = "analyze", description = "Runs Caesar to analyze encrypted text", mixinStandardHelpOptions = true)
public class AnalyzeCLI implements Runnable {
    @Option(names = {"-i", "--input"}, description = ENC_INPUT_PATH, required = true)
    Path input;
    @Option(names = {"-r", "--represent"}, description = REP_PATH, required = true)
    Path representative;
    @Option(names = {"-o", "--output"}, description = DEC_OUTPUT_PATH)
    Path output;

    @Override
    public void run() {
        StatAnalysis statAnalysis = new StatAnalysis(input, representative);
        System.out.println(statAnalysis.call());
        if (output != null) {
            System.out.println(new Decrypt(input, output, statAnalysis.getKey()).call());
        }
    }
}
