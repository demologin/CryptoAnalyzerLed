package com.javarush.pukhov.io;

import java.io.InputStream;
import java.io.Reader;

public interface Input<T extends InputStream,J extends Reader> {
    public String read();

    public T getInputStream();

    public J getReader();
}
