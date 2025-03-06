package com.javarush.kazakov.core.exceptions;

/**
 * {@code CryptoAnalyzerException} is the standard app exception for wrapping any of <em>checked
 * exceptions</em>.
 */
public class CryptoAnalyzerException extends RuntimeException {
    public CryptoAnalyzerException() {
    }

    public CryptoAnalyzerException(String message) {
        super(message);
    }

    public CryptoAnalyzerException(String message, Throwable cause) {
        super(message, cause);
    }

    public CryptoAnalyzerException(Throwable cause) {
        super(cause);
    }
}
