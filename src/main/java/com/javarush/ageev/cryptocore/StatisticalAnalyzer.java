package com.javarush.ageev.cryptocore;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class StatisticalAnalyzer {
    private HashMap<String, Integer> dictLetterFrequency = new HashMap<>();
    private int dictLetterCount = 0;
    private HashMap<String, Integer> dictBigramFrequency = new HashMap<>();
    private HashMap<String, Integer> dictTrigramFrequency = new HashMap<>();
    Path exampleFilePath;

    public void setExampleFilePath(Path exampleFilePath) {
        this.exampleFilePath = exampleFilePath;
    }

    public boolean analyze() {



        return true;
    }
}
