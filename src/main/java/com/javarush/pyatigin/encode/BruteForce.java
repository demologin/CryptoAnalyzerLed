package com.javarush.pyatigin.encode;

import com.javarush.pyatigin.ALPHABET;

import java.util.Scanner;

public class BruteForce {

    int lengthAlphabet = ALPHABET.getALPHABETLength();

    public String BruteForce(String line, int key) {
        for (int i = 1; i < lengthAlphabet; i++) {
            key = i;
            Decode decode = new Decode();
            String textEncode = decode.Decode(line, key);
            System.out.println(textEncode);
            System.out.println("BruteForce: 1 ok 2 not");
            Scanner scanner = new Scanner(System.in);
            int resultEncode = scanner.nextInt();
            if (resultEncode == 1) {
                System.out.println("Key " + key + " ok");
                return textEncode;
            }
        }
        return line;
    }
}
