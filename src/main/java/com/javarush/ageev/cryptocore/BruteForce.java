package com.javarush.ageev.cryptocore;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;

public class BruteForce {
    private final int SAMPLE_SIZE = 1024;
    private Path encryptedFilePath;
    private ArrayList<BruteForceEntry> bruteForceList = new ArrayList<>();

    private String encryptedSample;
    public BruteForce (Path encryptedFilePath) {
        this.encryptedFilePath = encryptedFilePath;
        bruteForceProcessor();
    }

    private void bruteForceProcessor() {
        try (BufferedReader reader = Files.newBufferedReader(encryptedFilePath)) {
            char[] buffer = new char[SAMPLE_SIZE];
            int bytesRead = reader.read(buffer, 0, SAMPLE_SIZE);

            encryptedSample = new String(buffer, 0, bytesRead);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Caesar cipher = new Caesar();

        for (int i = 1; i <= cipher.getMaxShift(); i++) {
            cipher.setShift(i);
            String decryptedSample = cipher.decrypt(encryptedSample);
            bruteForceList.add(new BruteForceEntry(i, (int) decryptedSample.chars().filter(ch -> ch == ' ').count(), decryptedSample));
        }
        bruteForceList.sort((o1, o2) -> o2.getSpaceCount().compareTo(o1.getSpaceCount()));
    }

    public ArrayList<BruteForceEntry> getBruteForceList() {
        return bruteForceList;
    }
}
