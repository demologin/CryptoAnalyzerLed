package com.javarush.pukhov.io;

import java.io.OutputStream;
import java.io.Writer;

public interface Output<T extends OutputStream,J extends Writer> {
    public void print(String message);

    public T getOutputStream();

    public J getWriter();
}
