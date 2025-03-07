package com.javarush.burkhanova;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleApp {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello! This is a console application. Please select option: ");
        String introMessage = "--------------------\n" +
                "Please select mode:\n" +
                "1. Encrypt\n" +
                "2. Decrypt\n" +
                "3. Brute force\n" +
                "4. Exit\n" +
                "5. Help\n" +
                "--------------------\n";
        System.out.println(introMessage);

        Scanner scanner = new Scanner(System.in);
        Validator validator = new Validator();

        while (true) {

            String text = scanner.nextLine().toLowerCase();

            switch (text) {

                case "1":
                    FileData encryptData = getFileData(scanner, validator, false);
                    FileProcessor.encryptFile(encryptData.inputPath, encryptData.outputPath, encryptData.key);
                    System.out.println("The file has been successfully encrypted and saved in " + encryptData.outputPath);
                    break;


                case "2":

                    FileData decryptData = getFileData(scanner, validator, false);
                    FileProcessor.decryptFile(decryptData.inputPath, decryptData.outputPath, decryptData.key);
                    System.out.println("The file has been successfully decrypted and saved in " + decryptData.outputPath);
                    break;

                case "3":
                    FileData bruteForceData = getFileData(scanner, validator, true);
                    FileProcessor.bruteForceFile(bruteForceData.inputPath, bruteForceData.outputPath);
                    System.out.println("The file has been successfully brute forced and saved in " + bruteForceData.outputPath);
                    break;

                case "4":
                    return;
                case "5":
                    System.out.println(introMessage);
                    break;


            }

        }


    }


    public static FileData getFileData(Scanner scanner, Validator validator, boolean isBruteForce) {

        System.out.println("Please provide input path: ");
        String inputPath = scanner.nextLine();
        while (!validator.isFileExists(inputPath,false)) {
            inputPath = scanner.nextLine();
        }


        System.out.println("Please provide output path: ");
        String outputPath = scanner.nextLine();
        while (!validator.isFileExists(outputPath,true)) {
            outputPath = scanner.nextLine();
        }



        if (isBruteForce) {
            return new FileData(inputPath, outputPath);
        }

        System.out.println("Please provide shift value: ");
        int key = scanner.nextInt();

        while (!validator.isValidKey(key, Cipher.ALPHABET)) {
            key = scanner.nextInt();
        }


        return new FileData(inputPath, outputPath, key);


    }

    public static class FileData {
        String inputPath;
        String outputPath;
        int key;


        public FileData(String inputPath, String outputPath, int key) {
            this.inputPath = inputPath;
            this.outputPath = outputPath;
            this.key = key;

        }

        public FileData(String inputPath, String outputPath) {
            this.inputPath = inputPath;
            this.outputPath = outputPath;


        }
    }


}
