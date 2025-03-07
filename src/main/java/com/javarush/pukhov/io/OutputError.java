package com.javarush.pukhov.io;

import java.io.OutputStream;
import java.io.Writer;

public interface OutputError extends Output<OutputStream,Writer> {
    public void print(RuntimeException e);
}
