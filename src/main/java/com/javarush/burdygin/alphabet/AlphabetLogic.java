package com.javarush.burdygin.alphabet;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class AlphabetLogic {


    static List<AlphabetObject> alphabetsObjects;

    public static int alphabetLength() {
        int result = 0;
        for (AlphabetObject alphabetObject : alphabetsObjects) {
            result += alphabetObject.last - (alphabetObject.first - 1);
            if (alphabetObject.exempts != null) {
                result += alphabetObject.exempts.length;
            }
        }
        return result;
    }

    public AlphabetLogic(List<AlphabetObject> alphabetsObjects) {
        AlphabetLogic.alphabetsObjects = alphabetsObjects;
    }

    public boolean isMiddleAlphabet(char c) {
        boolean result = false;
        for (AlphabetObject alphabetsObject : alphabetsObjects) {
            if (c > alphabetsObject.first && c < alphabetsObject.last) {
                result = true;
                break;
            }
        }
        return result;
    }

    public char charSwitch(char c, int key) {
        boolean isSwitched = false;
        for (int i = 0; i < alphabetsObjects.size()
                && !isSwitched
                && key == 1; i++) {
            AlphabetObject alphabetObject = alphabetsObjects.get(i);
            AlphabetObject nextAlphabetObject = i != alphabetsObjects.size() - 1 ? alphabetsObjects.get(i + 1) : alphabetsObjects.getFirst();

            if (c == alphabetObject.first) {
                c = alphabetObject.second;
                isSwitched = true;
            } else if (c == alphabetObject.last) {
                if (alphabetObject.exempts != null) {
                    c = alphabetObject.exempts[0];
                } else {
                    c = nextAlphabetObject.first;
                }
                isSwitched = true;
            } else if (alphabetObject.exempts != null) {
                if (c == alphabetObject.exempts[alphabetObject.exempts.length - 1]) {
                    c = nextAlphabetObject.first;
                    isSwitched = true;
                } else {
                    for (int j = 0; j < alphabetObject.exempts.length - 1 && !isSwitched; j++) {
                        if (c == alphabetObject.exempts[j]) {
                            c = alphabetObject.exempts[j + 1];
                            isSwitched = true;
                        }
                    }
                }

            }
        }

        for (int i = alphabetsObjects.size() - 1; i >= 0
                && !isSwitched
                && key == -1; i--) {
            AlphabetObject alphabetObject = alphabetsObjects.get(i);
            AlphabetObject previousAlphabetObject = i != 0 ? alphabetsObjects.get(i - 1) : alphabetsObjects.getLast();

            if (c == alphabetObject.last) {
                c = alphabetObject.penultimate;
                isSwitched = true;
            } else if (c == alphabetObject.first) {
                if (previousAlphabetObject.exempts != null) {
                    c = previousAlphabetObject.exempts[previousAlphabetObject.exempts.length - 1];
                } else {
                    c = previousAlphabetObject.last;
                }
                isSwitched = true;
            } else if (alphabetObject.exempts != null) {
                if (c == alphabetObject.exempts[0]) {
                    c = alphabetObject.last;
                    isSwitched = true;
                } else {
                    for (int j = alphabetObject.exempts.length - 1; j > 0 && !isSwitched; j--) {
                        if (c == alphabetObject.exempts[j]) {
                            c = alphabetObject.exempts[j - 1];
                            isSwitched = true;
                        }
                    }
                }
            }
        }
        return c;
    }

    public char getMostUsageSymbol(Path sourceFilePath) {
        int symbol = 0;
        int symbolCounter = 0;
        for (AlphabetObject alphabetsObject : alphabetsObjects) {
            int[] intermediateAlphabetResult = checkMostUsageSymbolFromAlphabet(alphabetsObject, symbolCounter, sourceFilePath);
            int[] intermediateResult = charCalculator(intermediateAlphabetResult[0], symbolCounter, symbol, intermediateAlphabetResult[1]);
            symbol = intermediateResult[0];
            symbolCounter = intermediateResult[1];
            if (alphabetsObject.exempts != null) {
                int[] intermediateAlphabetExemptsResult = checkAlphabetExempts(alphabetsObject, symbolCounter, sourceFilePath);
                int[] intermediateResultWithExempts = charCalculator(intermediateAlphabetExemptsResult[0], symbolCounter, symbol, intermediateAlphabetExemptsResult[1]);
                symbol = intermediateResultWithExempts[0];
                symbolCounter = intermediateResultWithExempts[1];
            }
        }
        return (char) symbol;
    }


    private int[] checkMostUsageSymbolFromAlphabet(AlphabetObject alphabetsObject, int symbolCounter, Path sourceFilePath) {
        int middleCounter;
        int middleChar = 0;
        for (int i = alphabetsObject.first; i <= alphabetsObject.last; i++) {
            middleCounter = checkingTheTextForCharCount(sourceFilePath, (char) i);
            int[] intermediateCharResult = charCalculator(middleCounter, symbolCounter, middleChar, i);
            middleChar = intermediateCharResult[0];
            symbolCounter = intermediateCharResult[1];
        }
        return new int[]{symbolCounter, middleChar};
    }

    private int[] checkAlphabetExempts(AlphabetObject alphabetsObject, int symbolCounter, Path sourceFilePath) {
        int middleCounter;
        int middleChar = 0;
        for (int i = 0; i < alphabetsObject.exempts.length; i++) {
            middleCounter = checkingTheTextForCharCount(sourceFilePath, alphabetsObject.exempts[i]);
            int[] intermediateCharExemptResult = charCalculator(middleCounter, symbolCounter, middleChar, alphabetsObject.exempts[i]);
            middleChar = intermediateCharExemptResult[0];
            symbolCounter = intermediateCharExemptResult[1];
        }
        return new int[]{symbolCounter, middleChar};
    }

    private int checkingTheTextForCharCount(Path sourceFilePath, char c) {
        int middleCounter = 0;
        try (BufferedReader bufferedReader = Files.newBufferedReader(sourceFilePath)) {
            while (bufferedReader.ready()) {
                char a = Character.toLowerCase((char) bufferedReader.read());
                if (a == c) {
                    middleCounter++;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return middleCounter;
    }

    private int[] charCalculator(int middleCounter, int symbolCounter, int middleChar, int currentChar) {
        if (middleCounter > symbolCounter) {
            middleChar = currentChar;
            symbolCounter = middleCounter;
        }
        return new int[]{middleChar, symbolCounter};
    }
}
