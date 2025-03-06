package com.javarush.burdygin.constant;

public class AlphabetLogic {

    public boolean isMiddleAlphabet(char c) {
        return c > Alphabet.SPACE && c < Alphabet.COMMERCIAL_AT                         //symbol      ' ' = 32, '@' = 64
                || c > Alphabet.A_LAT && c < Alphabet.Z_LAT                             //latin       'a' = 97, 'z' = 122
                || c > Alphabet.A_CYR && c < Alphabet.YA_CYR;                           //cyrillic    'а' = 1072, 'я' = 1103
    }

    public char charSwitch(char readString, int key) {
        //up
        if (key == 1) {
            switch (readString) {
                //for symbol
                case Alphabet.NEW_STRING -> readString = Alphabet.SPACE;                //'\n' -> ' '
                case Alphabet.SPACE -> readString = Alphabet.EXCLAMATION_MARK;          // ' ' -> '!'
                case Alphabet.COMMERCIAL_AT -> readString = Alphabet.CARRIAGE_RETURN;   // '@' -> '\r'
                case Alphabet.CARRIAGE_RETURN -> readString = Alphabet.A_LAT;           // '\r' -> 'a'
                //for latin
                case Alphabet.A_LAT -> readString = Alphabet.B_LAT;                     // 'a' -> 'b'
                case Alphabet.Z_LAT -> readString = Alphabet.A_CYR;                     // 'z' -> 'а'
                //for cyrillic
                case Alphabet.A_CYR -> readString = Alphabet.B_CYR;                     // 'а' -> 'б'
                case Alphabet.YA_CYR -> readString = Alphabet.YO_CYR;                   // 'я' -> 'ё'
                case Alphabet.YO_CYR -> readString = Alphabet.NEW_STRING;               // 'ё' -> '\n'
            }
        }
        //down
        if (key == -1) {
            switch (readString) {
                //for cyrillic
                case Alphabet.YO_CYR -> readString = Alphabet.YA_CYR;                   // 'ё' -> 'я'
                case Alphabet.YA_CYR -> readString = Alphabet.YU_CYR;                   // 'я' -> 'ю'
                case Alphabet.A_CYR -> readString = Alphabet.Z_LAT;                     // 'а' -> 'z'
                // for latin
                case Alphabet.Z_LAT -> readString = Alphabet.Y_LAT;                     // 'z' -> 'y'
                case Alphabet.A_LAT -> readString = Alphabet.CARRIAGE_RETURN;           // 'a' -> '\r'
                //for symbol
                case Alphabet.CARRIAGE_RETURN -> readString = Alphabet.COMMERCIAL_AT;   // '\r' -> '@'
                case Alphabet.COMMERCIAL_AT -> readString = Alphabet.QUESTION_MARK;     // '@' -> '?'
                case Alphabet.SPACE -> readString = Alphabet.NEW_STRING;                // ' ' -> '\n'
                case Alphabet.NEW_STRING -> readString = Alphabet.YO_CYR;               // '\n' -> 'ё'
            }
        }
        return readString;
    }
}
