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

import com.javarush.pyatigin.constatnt.PopularLetters;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class StatisticalAnalyse {
    public LinkedList<Character> statisticalAnalysis(String line) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = line.toCharArray();
        for (char aChar : chars) {
            map.put(aChar, map.getOrDefault(aChar, 0) + 1);
        }
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < PopularLetters.getPopularLettersLength(); i++) {
            Character maxKey = getMaxKey(map);
            list.add(maxKey);
            map.remove(maxKey);
        }
        System.out.println(list);
        return list;
    }

    public static Character getMaxKey(Map<Character, Integer> map) {
        Character maxKey = null;
        Integer maxValue = Integer.MIN_VALUE;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }
// Потестить что получиться если одникаковое кол-во букв
        return maxKey;
    }
}

