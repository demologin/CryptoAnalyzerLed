package com.javarush.kazakov.core.files;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * This interface exists only for the sake of method {@code read(Processable)} of class {@code FileManager}
 *
 * @see FileManager
 * @param <T> the type of objects that this object may return
 */
@FunctionalInterface
public interface Processable<T> {
    T process(BufferedReader br) throws IOException;
}
