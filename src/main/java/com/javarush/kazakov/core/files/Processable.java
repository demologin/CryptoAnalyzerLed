package com.javarush.kazakov.core.files;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
public interface Processable<T> {
    T process(BufferedReader br) throws IOException;
}
