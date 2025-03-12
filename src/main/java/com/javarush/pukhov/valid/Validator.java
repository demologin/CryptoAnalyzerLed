package com.javarush.pukhov.valid;

public interface Validator<T> {
    public boolean check(T object);

    public T getValidValue();

}
