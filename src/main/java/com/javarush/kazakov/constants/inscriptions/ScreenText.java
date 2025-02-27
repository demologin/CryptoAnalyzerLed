package com.javarush.kazakov.constants.inscriptions;

import com.javarush.kazakov.constants.Constants;

import java.util.function.Supplier;

import static com.javarush.kazakov.constants.InteractiveConstants.WELCOME_MESSAGE;

public enum ScreenText {
    WELCOME(ScreenText::getWelcomeInscriptions),
    ENCRYPT(ScreenText::getEncryptInscriptions),
    DECRYPT(ScreenText::getDecryptInscriptions),
    BRUTE_FORCE(ScreenText::getBruteForceInscriptions),
    ANALYSIS(ScreenText::getAnalysisInscriptions);

    private final Inscriptions inscriptions;

    ScreenText(Supplier<Inscriptions> inscriptionsSupplier) {
        this.inscriptions = inscriptionsSupplier.get();
    }

    public Inscriptions getInscriptions() {
        return inscriptions;
    }

    private static Inscriptions getWelcomeInscriptions() {
        return new Inscriptions().setWelcome(WELCOME_MESSAGE);
    }

    private static Inscriptions getEncryptInscriptions() {
        return new Inscriptions()
                .setMode("Encrypt")
                .setInput("Specify input text file")
                .setOutput("Specify encrypted output text file")
                .setOpen("Open Input File")
                .setSave("Save Encrypted File")
                .setInputPath(Constants.DEFAULT_INPUT_PATH.toString())
                .setOutputPath(Constants.DEFAULT_ENCRYPTED_PATH.toString());
    }

    private static Inscriptions getDecryptInscriptions() {
        return new Inscriptions()
                .setMode("Decrypt")
                .setInput("Specify encrypted input text file")
                .setOutput("Specify decrypted output text file")
                .setOpen("Open Encrypted File")
                .setSave("Save Decrypted File")
                .setInputPath(Constants.DEFAULT_ENCRYPTED_PATH.toString())
                .setOutputPath(Constants.DEFAULT_DECRYPTED_PATH.toString());
    }

    private static Inscriptions getBruteForceInscriptions() {
        return new Inscriptions()
                .setMode("Brute Force")
                .setInput("Specify encrypted input text file")
                .setOutput("Specify brute force decrypted output text file (optional)")
                .setOpen("Open Encrypted File")
                .setSave("Save Decrypted File")
                .setInputPath(Constants.DEFAULT_ENCRYPTED_PATH.toString());
    }

    private static Inscriptions getAnalysisInscriptions() {
        return new Inscriptions()
                .setMode("Analysis")
                .setInput("Specify encrypted input text file")
                .setOutput("Specify brute force decrypted output text file (optional)")
                .setOpen("Open Encrypted File")
                .setSave("Save Decrypted File")
                .setInputPath(Constants.DEFAULT_ENCRYPTED_PATH.toString())
                .setRepresent("Specify representative text file")
                .setRepresentPath(Constants.DEFAULT_REPRESENT_PATH.toString())
                .setRepresentOpen("Open representative file");
    }
}
