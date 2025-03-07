package com.javarush.burdygin.constant;

public interface Alphabet {
    char NEW_STRING = 10;
    char CARRIAGE_RETURN = 13;
    char SPACE = 32;
    char EXCLAMATION_MARK = 33;
    char QUESTION_MARK = 63;
    char COMMERCIAL_AT = 64;
    char A_LAT = 97;
    char B_LAT = 98;
    char Y_LAT = 121;
    char Z_LAT = 122;
    char A_CYR = 1072;
    char B_CYR = 1073;
    char YU_CYR = 1102;
    char YA_CYR = 1103;
    char YO_CYR = 1105;
    int ALPHABET_LENGTH = (COMMERCIAL_AT-(SPACE-1))+(Z_LAT-(A_LAT-1))+(YA_CYR-(A_CYR-1)+3); //symbol alphabet = 33, lat alphabet = 26, cyr alphabet = 32, 'yo' + '\n' + '\r' = 3
}
