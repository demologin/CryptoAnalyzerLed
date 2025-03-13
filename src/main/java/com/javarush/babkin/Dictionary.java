package com.javarush.babkin;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {

    public static final char[] CHAR_SYMBOLS = {'й','ц','у','к','е','н','г','ш','щ','з','х','ъ'
            ,'ф','ы','в','а','п','р','о','л','д','ж','э'
            ,'я','ч','с','м','и','т','ь','б','ю','.'
            ,'Й','Ц','У','К','Е','Н','Г','Ш','Щ','З','Х','Ъ'
            ,'Ф','Ы','В','А','П','Р','О','Л','Д','Ж','Э'
            ,'Я','Ч','С','М','И','Т','Ь','Б','Ю'
            ,',','\\','-','\n','_',' ','~','<','>','{','}'
            ,'`','!','@','#','$','%','^','&','*','(',')'
            ,'1','2','3','4','5','6','7','8','9','0'};

    public static final Map<Character, Integer> DICTIONARY = new HashMap<Character, Integer>();

    static {
        for(int i = 0; i < CHAR_SYMBOLS.length; i++){
            DICTIONARY.put(CHAR_SYMBOLS[i], i);
        }
    }

    public static int getLengthCharSymbols() {
        return Dictionary.CHAR_SYMBOLS.length;
    }


}
