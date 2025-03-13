package com.javarush.babkin;


import java.nio.file.Path;
import java.util.Scanner;

public class Options {

    public Options() {
        System.out.println(Textconstant.MENU_TEXT);

        Scanner scanner = new Scanner(System.in);
        int numberOption = 0;
        int zeroOption = 0;
        int totalOption = 4;
        String str = "";
        boolean boo = false;

        while (!boo) {

            str = scanner.nextLine();

            try {
                numberOption = Integer.parseInt(str);
                if ((!(numberOption > zeroOption)) || (!(numberOption < totalOption))) {
                    System.out.println(Textconstant.TEXT_NUMBER);
                } else if (numberOption == 1) {

                    System.out.println(Textconstant.TEXT_FILE_INPUT_INCRYPT);
                    String dst = scanner.nextLine();

                    if (dst == "") {
                        dst = "Textfile.txt";
                    }
                    System.out.println(Textconstant.TEXT_FILE_OUTPUT_INCRYPT);
                    String src = scanner.nextLine();

                    if (src == "") {
                        src = "Fileincrypt.txt";
                    }
                    System.out.println(Textconstant.TEXT_KEY);
                    String keyCrypt = scanner.nextLine();
                    int key = Integer.parseInt(keyCrypt);
                    Incryptfile.doIncrypt(dst, src, key);

                    boo = true;
                } else if (numberOption == 2) {

                    System.out.println(Textconstant.TEXT_FILE_INPUT_DICRYPT);
                    String dst = scanner.nextLine();
                    if (dst == "") {
                        dst = "Textfileincrypt.txt";
                    }
                    System.out.println(Textconstant.TEXT_FILE_OUTPUT_DICRYPT);
                    String src = scanner.nextLine();
                    if (src == "") {
                        src = "Filedicrypt.txt";
                    }
                    System.out.println(Textconstant.TEXT_KEY);
                    String keyCrypt = scanner.nextLine();
                    int key = Integer.parseInt(keyCrypt);
                    Dicryptfile.doDicrypt(dst, src, key);

                    boo = true;
                } else if (numberOption == 3) {
                    System.out.println(Textconstant.TEXT_EXIT);
                    boo = true;
                }

            } catch (NumberFormatException e) {
                System.out.println(Textconstant.TEXT_NUMBER);
            }
        }
    }
}
