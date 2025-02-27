package com.javarush.ageev.cryptocore;

import java.nio.file.Path;

public interface Cipher {
    public String textEncrypt (String str);
    public String textDecrypt (String str);

    public Boolean fileEncrypt (Path in, Path out);
    public Boolean fileDecrypt (Path in, Path out);
}
