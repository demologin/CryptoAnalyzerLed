package com.javarush.pyatigin.decode;

import com.javarush.pyatigin.constatnt.ALPHABET;
import com.javarush.pyatigin.constatnt.PopularLetters;

import java.util.LinkedList;
import java.util.Scanner;
// Подумать логику, когда алфавит не знаем
public class BruteForce {

    public String getBruteForce(String line) {
        LinkedList<Character> list = new StatisticalAnalyse().statisticalAnalysis(line);
        for (int i = 0; i < list.size(); i++) {
            char c = list.get(i);
            int index = ALPHABET.getIndexOfAlphabet(PopularLetters.getCharPopularLetters(i));
            int index1 = ALPHABET.getIndexOfAlphabet(c);
            int key = Math.abs(index - index1);
            Decode decode = new Decode();
            String textDecode = decode.getDecode(line, key);
            System.out.println(textDecode);
            System.out.println("BruteForce: 1 ok 2 not");
            Scanner scanner = new Scanner(System.in);
            int resultEncode = scanner.nextInt();
            if (resultEncode == 1) {
                System.out.println("Key " + key + " ok");
                return textDecode;
            }
        }
        //Если не удалось, то включить простой брут как был
        return line;
    }
}
