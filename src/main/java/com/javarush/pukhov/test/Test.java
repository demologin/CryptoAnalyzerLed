package com.javarush.pukhov.test;

import com.javarush.pukhov.command.ActionName;

public class Test {
    public static void main(String[] args) {
        // testActionName("123");
        testActionNameSize(10);
    }

    private static void testActionNameSize(int index) {
        ActionName name = ActionName.values()[index];
        System.out.println(name);
    }

    private static void testActionName(String checkString) {
        ActionName name = ActionName.valueOf(checkString);
        System.out.println(name);
    }

}
