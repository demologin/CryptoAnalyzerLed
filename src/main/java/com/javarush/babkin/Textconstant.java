package com.javarush.babkin;

public class Textconstant {
    public static final String TEXT_NUMBER = "Enter a number option from 1 to 3";

    public static final String TEXT_VARIANT = "Choose an option:";
    public static final String TEXT_CODE = "1.Encode the text";
    public static final String TEXT_UNCODE = "2.Decode the text";
    public static final String TEXT_EXIT = "3.Exit";

    public static final String TEXT_FILE_INPUT = "Select the file path from where the text will be copied (Either the default folder will be selected. -)";
    public static final String TEXT_FILE_OUTPUT_INCRYPT = "Select the file path where the encoded text will be copied (Either the default folder will be selected. -)";
    public static final String TEXT_FILE_OUTPUT_DICRYPT = "Select the file path to which the decoded text will be copied (Either the default folder will be selected. -)";
    public static final String TEXT_KEY = "Enter the key";


    public static final String MENU_TEXT = String.format("%s%n%s%n%s%n%s", TEXT_VARIANT, TEXT_CODE, TEXT_UNCODE, TEXT_EXIT);
}
