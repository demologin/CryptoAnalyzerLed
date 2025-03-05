package com.javarush.zhdanovskikh;

public class Controller {
    public static void doAction(String action, String[] params){
        int key;
        switch (action){
            case "ENCODE":
                Action.processFile(params[0], params[1], Integer.parseInt(params[2]));
                break;
            case "DECODE":
                Action.processFile(params[0], params[1], -1*Integer.parseInt(params[2]));
                break;
            case "BRUTEFORCE":
                long chrCount;
                long maxChrCount=0;
                int forceKey=0;
                for (key = 0; key <= Constants.ALPHABET.length(); key++) {
                    chrCount = Action.countCharInFile(params[0], key);
                    if (chrCount > maxChrCount){
                        maxChrCount = chrCount;
                        forceKey = key;
                    }
                }
                if (maxChrCount == 0){
                    throw new RuntimeException ("Brute Force finished, but input file not decoded");
                }
                Action.processFile(params[0], params[1], -1 * forceKey);
                break;
            default:
                throw ( new RuntimeException ("Unsupported action: "+action));
        }
    }
}
