package com.javarush.babkin;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {

    private static final char[] CHAR_SYMBOLS = {'й','ц','у','к','е','н','г','ш','щ','з','х','ъ'
            ,'ф','ы','в','а','п','р','о','л','д','ж','э'
            ,'я','ч','с','м','и','т','ь','б','ю','.'
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
