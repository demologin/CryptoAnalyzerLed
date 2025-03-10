package com.javarush.burdygin.exception;

/**
 * Я создал это исключение поскольку потратил 2 часа на поиск причины,
 * по которой класс BruteForce не вызывал методы repeater() и
 * зацикливался, а причиной оказался пустой файл-источник
 */

public class EmptyFileException extends RuntimeException {
    public EmptyFileException() {
    }
}
