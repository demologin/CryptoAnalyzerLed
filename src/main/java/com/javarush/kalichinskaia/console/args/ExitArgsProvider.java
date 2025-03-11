package com.javarush.kalichinskaia.console.args;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.javarush.kalichinskaia.console.AppMode.EXIT_MODE;

public class ExitArgsProvider implements ArgsProvider {

    @Override
    public List<String> get(Scanner scanner) {
        List<String> args = new ArrayList<>();
        args.add(String.valueOf(EXIT_MODE.getMode()));

        System.out.println("The exit is completed");

        return args;
    }
}
