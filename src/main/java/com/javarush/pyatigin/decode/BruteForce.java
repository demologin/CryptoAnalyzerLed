//Пространственный символ (пробел) - около 15-20%
//        О - около 10.97%
//        Е - около 8.45%
//        А - около 7.96%
//        И - около 7.34%
//        Н - около 6.70%
//        Т - около 6.62%
//        С - около 5.43%
//        Р - около 4.95%
//        Л - около 4.29%
package com.javarush.pyatigin.decode;

import com.javarush.pyatigin.ALPHABET;

import java.util.Scanner;

public class BruteForce {

    int lengthAlphabet = ALPHABET.getALPHABETLength();

    public String BruteForce(String line, int key) {

        for (int i = 1; i < lengthAlphabet; i++) {
            key = i;
            Decode decode = new Decode();
            String textEncode = decode.Decode(line, key);
            //добавить варианты
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
