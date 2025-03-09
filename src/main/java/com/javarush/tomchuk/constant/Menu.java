package com.javarush.tomchuk.constant;

import com.javarush.tomchuk.handlers.Analyzer;
import com.javarush.tomchuk.handlers.BruteForcer;
import com.javarush.tomchuk.handlers.Decoder;
import com.javarush.tomchuk.handlers.Encoder;
import com.javarush.tomchuk.util.PathBuilder;

import java.util.Objects;
import java.util.Scanner;

public class Menu {

    private Menu() {

    }

    public static StandartOperation chooseOperation() {
        System.out.println("Choose mode:");
        int i = 1;
        for (StandartOperation operation : StandartOperation.values()) {
            System.out.println(i++ + ". " + operation);
        }
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return switch (choice) {
            case 1 -> StandartOperation.ENCODE;
            case 2 -> StandartOperation.DECODE;
            case 3 -> StandartOperation.BRUTFORCE;
            case 4 -> StandartOperation.ANALYZE;
            case 5 -> StandartOperation.EXIT;
            default -> StandartOperation.UNSUPPORTED_OPERATION;
        };
    }

    private static String uploadTargetFilePaths() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Write target text file path or press Enter to choose standart text.txt file: ");
        String targetFilePath = scanner.nextLine();
        targetFilePath = Objects.equals(targetFilePath, "")
                ? PathBuilder.getStandartResultFileName()
                : targetFilePath;

        return targetFilePath;
    }

    private static String uploadSourceFilePath() {
        System.out.print("Write source text file path or press Enter to choose standart text.txt file: ");
        Scanner scanner = new Scanner(System.in);
        String sourceFilePath = scanner.nextLine();
        sourceFilePath = Objects.equals(sourceFilePath, "")
                ? PathBuilder.getStandartSourceFileName()
                : sourceFilePath;
        return sourceFilePath;
    }

    public static String[] uploadFilePaths() {
        String[] files = new String[2];
        files[0] = uploadSourceFilePath();
        files[1] = uploadTargetFilePaths();
        return files;
    }

    public static String getKey() {
        System.out.print("Write a key for encoding or decoding with: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static Result execute(StandartOperation operation, String[] arguments) {
        ResultCode resultCode = switch (operation) {
            case StandartOperation.DECODE -> new Decoder().handle(arguments);
            case StandartOperation.ENCODE -> new Encoder().handle(arguments);
            case StandartOperation.BRUTFORCE -> new BruteForcer().handle(arguments);
            case StandartOperation.ANALYZE -> new Analyzer().handle(arguments);
            default -> ResultCode.ERROR;
        };
        return Result.getResult(operation, resultCode);
    }
}
