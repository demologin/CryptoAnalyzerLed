package com.javarush.apalinskiy.view;

import com.javarush.apalinskiy.io.FilePathResolver;

import java.io.IOException;
import java.util.Scanner;

public class CommandRunner {
    public void Runner(int command) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Massages massages = new Massages();
        FilePathResolver resolver = new FilePathResolver();
        CommandBuilder builder = new CommandBuilder();
        switch (command){
            case 1:
                builder.build(scanner, resolver.getFreshPath(), resolver.getOutputPath(), command);
                break;
            case 2, 3:
                builder.build(scanner, resolver.getOutputPath(), resolver.getInputPath(), command);
                break;
        }
        massages.getDone();
    }
}
