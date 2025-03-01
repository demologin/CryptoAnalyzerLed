package com.javarush.burdygin;


import com.javarush.burdygin.view.Menu;

import java.util.Scanner;

public class ConsoleRunner {
    public static char[] alphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ.\"’:-!? ".toCharArray();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        new Menu(scanner);
    }
}
