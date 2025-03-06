package com.javarush.kazakov.commands.climode;

import com.javarush.kazakov.commands.BruteForce;
import com.javarush.kazakov.commands.Decrypt;

import java.nio.file.Path;

import static com.javarush.kazakov.constants.CLIConstants.DEC_OUTPUT_PATH;
import static com.javarush.kazakov.constants.CLIConstants.ENC_INPUT_PATH;
import static picocli.CommandLine.*;

@Command(name = "bf", description = "Runs CryptoAnalyzer to brute force decrypt text", mixinStandardHelpOptions = true)
public class BruteForceCLI implements Runnable {
    @Option(names = {"-i", "--input"}, description = ENC_INPUT_PATH, required = true)
    Path input;
    @Option(names = {"-o", "--output"}, description = DEC_OUTPUT_PATH)
    Path output;

    @Override
    public void run() {
        BruteForce bruteForce = new BruteForce(input);
        System.out.println(bruteForce.call());
        if (output != null) {
            System.out.println(new Decrypt(input, output, bruteForce.getKey()).call());
        }
    }
}
