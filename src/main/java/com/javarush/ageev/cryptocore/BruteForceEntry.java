package com.javarush.ageev.cryptocore;

public class BruteForceEntry {
    private final Integer key;
    private final Integer spaceCount;
    private final String decryptedPreview;

    public BruteForceEntry(int key, int spaceCount, String decryptedPreview) {
        this.key = key;
        this.spaceCount = spaceCount;
        this.decryptedPreview = decryptedPreview;
    }

    public int getKey() {
        return key;
    }

    public Integer getSpaceCount() {
        return spaceCount;
    }

    public String getDecryptedPreview() {
        return decryptedPreview;
    }
}
