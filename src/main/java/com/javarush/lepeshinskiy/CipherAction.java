package com.javarush.lepeshinskiy;

public enum CipherAction {
    ENCRYPT("encryption"),
    DECRYPT("decryption"),
    BRUTE_FORCE("brute_force");

    private final String displayName;

    CipherAction(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}