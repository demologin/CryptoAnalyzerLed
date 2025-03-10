package com.javarush.pukhov.util;

public final class Swapper {

    private Swapper() {
    }

    public static <T> void swap(T[] array, int i, int j) {
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void swap(double[] array, int i, int j) {
        double tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void swap(char[] array, int i, int j) {
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void swapColumnsAndRow(double[][] array, int i, int j) {
        // swap row
        swap(array, i, j);

        // swap columns
        for (int k = 0; k < array[i].length; k++) {
            double value = array[k][i];
            array[k][i] = array[k][j];
            array[k][j] = value;
        }
    }
}
