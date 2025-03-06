package com.javarush.ageev.cryptocore;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class BruteForce {
    private static final int SAMPLE_SIZE = 1024;
    private final Path encryptedFilePath;
    private final ArrayList<BruteForceEntry> bruteForceList = new ArrayList<>();

    private final Caesar cipher = new Caesar();

    public BruteForce(Path encryptedFilePath) throws IOException {
        this.encryptedFilePath = encryptedFilePath;
        bruteForceProcessor();
    }

    private void bruteForceProcessor() throws IOException {
        String encryptedSample;
        try (BufferedReader reader = Files.newBufferedReader(encryptedFilePath)) {
            char[] buffer = new char[SAMPLE_SIZE];
            int bytesRead = reader.read(buffer, 0, SAMPLE_SIZE);
            encryptedSample = new String(buffer, 0, bytesRead);
        }

        for (int i = 1; i <= cipher.getMaxShift(); i++) {
            cipher.setShift(i);
            String decryptedSample = cipher.decrypt(encryptedSample);
            bruteForceList.add(new BruteForceEntry(i, (int) decryptedSample.chars().filter(ch -> ch == ' ').count(), decryptedSample));
        }
        bruteForceList.sort((o1, o2) -> o2.getSpaceCount().compareTo(o1.getSpaceCount()));
    }

    public List<BruteForceEntry> getBruteForceList() {
        return bruteForceList;
    }
}
