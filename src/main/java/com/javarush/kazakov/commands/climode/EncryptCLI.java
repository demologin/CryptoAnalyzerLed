package com.javarush.kazakov.commands.climode;

import com.javarush.kazakov.commands.Encrypt;

import java.nio.file.Path;

import static com.javarush.kazakov.constants.CLIConstants.*;
import static picocli.CommandLine.*;

@Command(name = "encrypt", description = "Runs CryptoAnalyzer to encrypt text", mixinStandardHelpOptions = true)
public class EncryptCLI implements Runnable {
    @Option(names = {"-i", "--input"}, description = INPUT_PATH, required = true)
    Path input;
    @Option(names = {"-o", "--output"}, description = ENC_OUTPUT_PATH, required = true)
    Path output;
    @Option(names = {"-k", "--key"}, description = DEC_KEY, required = true)
    int key;

    @Override
    public void run() {
        Encrypt encrypt = new Encrypt(input, output, key);
        System.out.println(encrypt.call());
    }
}
