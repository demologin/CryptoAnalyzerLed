package com.javarush.ageev.cryptocore;

import java.io.IOException;
import java.nio.file.Path;

public interface Cipher {
    public char encrypt(char in);

    public char decrypt(char in);

    public String encrypt(String in);

    public String decrypt(String in);

    public boolean encrypt(Path in, Path out) throws IOException;

    public boolean decrypt(Path in, Path out);
}
