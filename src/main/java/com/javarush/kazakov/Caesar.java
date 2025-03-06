package com.javarush.kazakov;

import com.javarush.kazakov.commands.climode.AnalyzeCLI;
import com.javarush.kazakov.commands.climode.BruteForceCLI;
import com.javarush.kazakov.commands.climode.DecryptCLI;
import com.javarush.kazakov.commands.climode.EncryptCLI;
import picocli.CommandLine;
import picocli.CommandLine.Command;

import static com.javarush.kazakov.constants.InteractiveConstants.WELCOME_MESSAGE;

@Command(name = "Caesar",
        subcommands = {
                EncryptCLI.class,
                DecryptCLI.class,
                BruteForceCLI.class,
                AnalyzeCLI.class,
                GUIMode.class
        },
        version = "CryptoAnalyzer 0.0.1",
        mixinStandardHelpOptions = true,
        description = WELCOME_MESSAGE + " Run with no arguments starts interactive mode.")
public class Caesar implements Runnable {

    public static void main(String... args) {
        CommandLine commandLine = new CommandLine(new Caesar());
        int exitCode = commandLine.execute(args);
        System.exit(exitCode);
    }

    @Override
    public void run() {
        new InteractiveMode().run();
    }
}