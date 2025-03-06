package com.javarush.apalinskiy.view;

import com.javarush.apalinskiy.constants.Const;
import com.javarush.apalinskiy.io.FilePathResolver;
import com.javarush.apalinskiy.logic.Bruteforce;
import com.javarush.apalinskiy.logic.Decryption;
import com.javarush.apalinskiy.logic.Encryption;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class CommandBuilder {
    Messages massages = new Messages();
    Encryption encryption = new Encryption();
    Decryption decryption = new Decryption();
    Bruteforce bruteforce = new Bruteforce();
    FilePathResolver resolver = new FilePathResolver();

    public void build(Scanner scanner, Path input, Path output, int command) throws IOException {
        massages.getMessage(input, Const.input);
        Path inputPath = resolver.buildPath(scanner.nextLine().trim(), input);
        massages.getMessage(output, Const.output);
        Path outputPath = resolver.buildPath(scanner.nextLine().trim(), output);
        if (command == 1) {
            massages.getKey();
            encryption.encryption(scanner.nextInt(), inputPath, outputPath);
        } else if (command == 2) {
            massages.getKey();
            decryption.decryption(scanner.nextInt(), inputPath, outputPath);
        } else {
            bruteforce.bruteforce(inputPath, outputPath);
        }
    }
}
