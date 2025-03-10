package com.javarush.smirnov;


import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {

        boolean flag = true;
        int mode = 0;
        Scanner scanner = new Scanner(System.in);

        while(flag){
            try{
                for (int i = 0; i < Constants.start.length; i++) {
                    System.out.println(Constants.start[i]);
                }
                String console = scanner.nextLine();
                mode = Integer.parseInt(console);
                flag = false;
            } catch (NumberFormatException e){
                System.out.println(Constants.incorInput);
            }

        }

        flag = true;
        while (flag){
            try {
                switch (mode){
                    case 1:
                        System.out.println(Constants.key);
                        String console = scanner.nextLine();
                        int key = Integer.parseInt(console);
                        Encode code = new Encode(key);
                        code.EnCode();
                        flag = false;
                        System.out.println(Constants.end);
                        break;
                    case 2:
                        System.out.println(Constants.key);
                        String console2 = scanner.nextLine();
                        int key2 = Integer.parseInt(console2);
                        Decode code2 = new Decode(key2);
                        code2.DeCode();
                        flag = false;
                        System.out.println(Constants.end);
                        break;
                    case 3:
                        System.out.println(Constants.end);
                        flag = false;
                        break;
                    default:
                        System.out.println(Constants.incorInput);
                }
            } catch (Exception e) {
                System.out.println(Constants.incorInput);
            }
        }
    }
}
