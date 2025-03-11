package com.javarush.kalichinskaia.console;

import com.javarush.kalichinskaia.console.args.*;

public enum AppMode {
    ENCRYPT_MODE(1, new EncryptArgsProvider()),
    DECRYPT_MODE(2, new DecryptArgsProvider()),
    BRUTEFORCE_MODE(3, new BruteForceArgsProvider()),
    ANALYZE_MODE(4, new AnalyzeArgsProvider()),
    EXIT_MODE(5, new ExitArgsProvider());

    private final int mode;
    private final ArgsProvider supplier;

    AppMode(int mode, ArgsProvider supplier) {
        this.mode = mode;
        this.supplier = supplier;
    }

    public int getMode() {
        return mode;
    }

    public ArgsProvider getSupplier() {
        return supplier;
    }

    @Override
    public String toString() {
        return "AppMode{" +
                "mode='" + mode + '\'' +
                ", supplier=" + supplier +
                '}';
    }
}
