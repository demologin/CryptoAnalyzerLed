package com.javarush.zhdanovskikh;
import java.util.Arrays;

public class MyRunner {


    public static void main(String[] args) {
        if (args.length < 4){
            System.out.println("Не указаны аргументы:");
            System.out.println("ENCODE | DECODE | BRUTEFORCE From_File To_File Key");
            System.exit(1);
        }

        String action = args[0].toUpperCase();
        String [] params = Arrays.copyOfRange(args,1,args.length);
        System.out.printf("Execute action: %s Read file: %s Write file %s Key: %s%n", action, params[0], params[1], params[2]);
        try {
            Controller.doAction(action, params);
            System.out.println("Completed sucessfully");
        } catch (RuntimeException e) {
            System.out.printf("Execution failed with reason: %s %n",e.getMessage());
        }
    }
}