package com.javarush.artjomfadejev.artjomfadeev.src.main.java.com.artjomfadeev.util;

import com.javarush.artjomfadejev.artjomfadeev.src.main.java.com.artjomfadeev.constant.Const;

import java.nio.file.Path;

public class PathBuilder {

    private PathBuilder() {
    }

    public static Path get(String filename) {
        Path path = Path.of(filename);
        return path.isAbsolute()
                ? path
                : Path.of(Const.TXT_FOLDER + filename);
    }
}

