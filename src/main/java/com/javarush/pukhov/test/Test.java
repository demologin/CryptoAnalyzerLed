package com.javarush.pukhov.test;

import java.util.StringJoiner;

import com.javarush.pukhov.command.ActionName;
import com.javarush.pukhov.view.console.constants.Messages;

public class Test {
    public static void main(String[] args) {
        // testActionName("123");
        // testActionNameSize(10);
        testErrorMessage();
    }

    private static void testErrorMessage() {
        StringJoiner joiner = new StringJoiner(" and ");
        // joiner.add(Messages.INCORRECT_NUMBER);
        System.out.println(joiner.length());
        // joiner.add("%1$s - is not an action");
        String message = String.format(joiner.toString(),"uipo");
        System.out.println(message);
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
