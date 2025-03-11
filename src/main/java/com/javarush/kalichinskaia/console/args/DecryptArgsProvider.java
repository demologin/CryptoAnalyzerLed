package com.javarush.kalichinskaia.console.args;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.javarush.kalichinskaia.console.AppMode.DECRYPT_MODE;

public class DecryptArgsProvider implements ArgsProvider {

    @Override
    public List<String> get(Scanner scanner) {
        List<String> args = new ArrayList<>();
        args.add(String.valueOf(DECRYPT_MODE.getMode()));

        System.out.println("Enter source (full path OR only filename) :");
        String answer = scanner.nextLine();
        args.add(answer);

        System.out.println("Enter destination (full path OR only filename) :");
        String answerDestination = scanner.nextLine();
        args.add(answerDestination);

        System.out.println("Enter key (int number) :");
        String answerKey = scanner.nextLine();
        if (answerKey == "") {
            answerKey = "1";
        }
        args.add(answerKey);

        return args;
    }
}
