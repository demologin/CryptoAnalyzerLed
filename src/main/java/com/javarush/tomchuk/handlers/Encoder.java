package com.javarush.tomchuk.handlers;

import com.javarush.tomchuk.constant.Alphabet;
import com.javarush.tomchuk.constant.ResultCode;

public class Encoder extends ActionHandler {

    @Override
    public ResultCode handle(String... arguments) {
        String sourcePath = arguments[0];
        String targetPath = arguments[1];
        try {
            int codeKey = Integer.parseInt(arguments[2]);
            Character[] characters = readChars(sourcePath);
            if (characters == null) {
                return ResultCode.ERROR;
            }
            for (int i = 0; i < characters.length; i++) {
                int alphabetIndex = Alphabet.getIndex(characters[i]);
                characters[i] = alphabetIndex != -1
                        ? Alphabet.getCharPlus(alphabetIndex, codeKey)
                        : characters[i];
            }
            return writeChars(targetPath, characters);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return ResultCode.ERROR;
        }
    }
}
