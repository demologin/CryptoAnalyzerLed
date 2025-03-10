package com.javarush.smirnov;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class PathBuilder {
    public static Path GetPathFile(){
        boolean flag = false;

        Path pathFile = null;

        Scanner scanner = new Scanner(System.in);
        while(!flag){
            System.out.println(Constants.path);
            pathFile = Path.of(scanner.nextLine());
            flag = Files.isRegularFile(pathFile);
            if (!flag){
                System.out.println(Constants.incorInput);
            }
        }
        return pathFile;
    }

    public static Path GetPathFileToSaveEncoding(){
        boolean flag = false;
        Path pathSaveFileToEncoding = null;

        Scanner scanner = new Scanner(System.in);

        while(!flag){
            System.out.println(Constants.pathSaveEncoding);
            pathSaveFileToEncoding = Path.of(scanner.nextLine());
            flag = Files.isRegularFile(pathSaveFileToEncoding);
            if (!flag){
                System.out.println(Constants.incorInput);
            }
        }

        return pathSaveFileToEncoding;
    }

    public static Path GetPathFileToSaveDecoding() {
        boolean flag = false;
        Path pathSaveFileToDecoding = null;

        Scanner scanner = new Scanner(System.in);

        while(!flag){
            System.out.println(Constants.pathSaveDecoding);
            pathSaveFileToDecoding = Path.of(scanner.nextLine());
            flag = Files.isRegularFile(pathSaveFileToDecoding);
            if (!flag){
                System.out.println(Constants.incorInput);
            }
        }
        return pathSaveFileToDecoding;
    }
}
