package com.javarush.kalichinskaia.console.args;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.javarush.kalichinskaia.console.AppMode.BRUTEFORCE_MODE;

public class BruteForceArgsProvider implements ArgsProvider {

    @Override
    public List<String> get(Scanner scanner) {
        List<String> args = new ArrayList<>();
        args.add(String.valueOf(BRUTEFORCE_MODE.getMode()));

        System.out.println("Enter source (full path OR only filename");
        String answer = scanner.nextLine();
        args.add(answer);

        System.out.println("Enter destination (full path OR only filename");
        String answerDestination = scanner.nextLine();
        args.add(answerDestination);

        return args;
    }
}
