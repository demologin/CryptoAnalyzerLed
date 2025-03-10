package com.javarush.burdygin.alphabet;

public class AlphabetObject {

    char first;
    char second;
    char penultimate;
    char last;
    char[] exempts;

    public AlphabetObject(char first, char second, char penultimate, char last, char... exempts) {
        this.first = first;
        this.second = second;
        this.penultimate = penultimate;
        this.last = last;
        this.exempts = exempts;
    }

    public AlphabetObject(char first, char second, char penultimate, char last) {
        this.first = first;
        this.second = second;
        this.penultimate = penultimate;
        this.last = last;
    }
}
