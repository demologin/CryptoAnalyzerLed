package com.javarush.kazakov.commands.climode;

import com.javarush.kazakov.commands.Decrypt;

import java.nio.file.Path;

import static com.javarush.kazakov.constants.CLIConstants.*;
import static picocli.CommandLine.*;


@Command(name = "decrypt", description = "Runs Caesar to decrypt text", mixinStandardHelpOptions = true)
public class DecryptCLI implements Runnable {
    @Option(names = {"-i", "--input"}, description = ENC_INPUT_PATH, required = true)
    Path input;
    @Option(names = {"-o", "--output"}, description = DEC_OUTPUT_PATH, required = true)
    Path output;
    @Option(names = {"-k", "--key"}, description = DEC_KEY, required = true)
    int key;

    @Override
    public void run() {
        Decrypt decrypt = new Decrypt(input, output, key);
        System.out.println(decrypt.call());
    }
}
