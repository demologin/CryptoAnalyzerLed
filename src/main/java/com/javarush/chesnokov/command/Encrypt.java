package com.javarush.chesnokov.command;


import com.javarush.chesnokov.Alphabet;
import com.javarush.chesnokov.result.Result;

public class Encrypt extends AbstractCommand {

    @Override
    public Result execute(String[] parameters) {

        String source = parameters[0];
        String target = parameters[1];
        int shift = Integer.parseInt(parameters[2]);
        String alphabet = new Alphabet().getAlphabet();

        return copyWithKey(source, target, shift, alphabet);
    }
}
