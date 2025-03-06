package com.javarush.apalinskiy.view;

import com.javarush.apalinskiy.exceptions.AppException;
import com.javarush.apalinskiy.exceptions.ExceptionMessage;
import com.javarush.apalinskiy.io.FilePathResolver;

import java.io.IOException;
import java.util.Scanner;

public class OperatorSwitch {
    public void Switch() throws IOException {
        Scanner scanner = new Scanner(System.in);
        Messages massages = new Messages();
        FilePathResolver resolver = new FilePathResolver();
        CommandBuilder builder = new CommandBuilder();
        int command = Integer.parseInt(scanner.nextLine().trim());
        switch (command) {
            case 1:
                builder.build(scanner, resolver.getFreshPath(), resolver.getOutputPath(), command);
                break;
            case 2, 3:
                builder.build(scanner, resolver.getOutputPath(), resolver.getInputPath(), command);
                break;
            case 4:
                break;
            default:
                throw new AppException(ExceptionMessage.getMessage());
        }
        massages.getDone();
    }
}
