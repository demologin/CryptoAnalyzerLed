package com.javarush.pukhov.test;

import com.javarush.pukhov.command.ActionName;

public class Test {
    public static void main(String[] args) {
        testActionName();
    }

    private static void testActionName() {
        ActionName name = ActionName.valueOf("123");
        System.out.println(name);
    }
}
