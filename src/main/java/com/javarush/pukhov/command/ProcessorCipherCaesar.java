package com.javarush.pukhov.command;

import java.util.Map;

import com.javarush.pukhov.constant.AlphabetCaesar;
import com.javarush.pukhov.exception.ApplicationException;

public class ProcessorCipherCaesar {

    private final int key;
    private final int mode;

    /**
     * @param key
     * @param mode
     */
    public ProcessorCipherCaesar(int key, int mode) {
        this.key = key;
        this.mode = mode;
    }



    public void processSymbolsWithKey(char[] buf, int countSymbols) {
        Map<Character, Integer> alphabet = AlphabetCaesar.getAlphabet();
        for (int i = 0; i < countSymbols; i++) {
            try {
                if (alphabet.containsKey(buf[i])) {
                    int indexAlphabet = alphabet.get(buf[i]);
                    int indexNewChar = Math.abs(indexAlphabet + key * mode) % alphabet.size();
                    char newChar = AlphabetCaesar.getSymbol(indexNewChar);
                    buf[i] = newChar;
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
                String message = String.format("i = %d, buf[i] = %c", i, buf[i]);
                throw new ApplicationException(message, e);
            }
        }
    }

}
