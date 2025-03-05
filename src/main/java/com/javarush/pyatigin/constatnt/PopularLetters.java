package com.javarush.pyatigin.constatnt;

public class PopularLetters {
    private static final char[] popularLetters = {' ', 'е', 'а', 'и', 'н', 'т', 'с', 'р', 'л'};

    public static int getPopularLettersLength() {
        return popularLetters.length;
    }

    public static char getCharPopularLetters(int index) {
        return popularLetters[index];
    }

    //Подумать как вернуть Большие буквы
//    public static int getIndexOfpopularLetters(char c) {
//        for (int i = 0; i < popularLetters.length; i++) {
//            if (popularLetters[i] == Character.toLowerCase(c)) {
//                return i;
//            }
//        }
//        //Подумать как через ошибку вернуть что нет char
//        return -1;
}

