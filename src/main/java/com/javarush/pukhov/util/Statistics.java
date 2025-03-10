package com.javarush.pukhov.util;

import java.util.concurrent.ThreadLocalRandom;

import com.javarush.pukhov.constant.ErrorMessages;
import com.javarush.pukhov.exception.StatisticException;

public class Statistics {

    private Statistics() {
    }

    public static<T> double findBestDistanceWithArraySwaps(T[] array, double[][] original, double[][] genom) {
        int skipSwapCounter = 0;
        double bestProbeDistance = Double.MAX_VALUE;
        int generalLengthGenom = genom.length * genom.length;

        genom = getCloneArray(genom);

        while (skipSwapCounter < generalLengthGenom) {
            int[] indices = getRandomIndices(genom.length);
            int i = indices[0];
            int j = indices[1];

            Swapper.swapColumnsAndRow(genom, i, j);

            double distance = calcDistance(genom, original);
            if (distance < bestProbeDistance) {
                bestProbeDistance = distance;
                skipSwapCounter = 0;
                Swapper.swap(array, i, j);
            } else {
                Swapper.swapColumnsAndRow(genom, j, i); // revert
                skipSwapCounter++;
            }
        }
        return bestProbeDistance;
    }

    private static int[] getRandomIndices(int length) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int i = random.nextInt(length);
        int j;
        do {
            j = random.nextInt(length);
        } while (j == i);
        return new int[] { i, j };
    }

    private static double[][] getCloneArray(double[][] array) {
        double[][] genom = array.clone();
        for (int i = 0; i < array.length; i++) {
            genom[i] = array[i].clone();
        }
        return genom;
    }

    private static double calcDistance(double[][] firstMatrix, double[][] secondMatrix) {
        double destination = 0;
        boolean areMatricesValid = firstMatrix.length == secondMatrix.length
                && firstMatrix.length != 0
                && firstMatrix[0].length == secondMatrix[0].length
                && firstMatrix[0].length != 0;

        if (areMatricesValid) {
            for (int i = 0; i < firstMatrix.length; i++) {
                for (int j = 0; j < firstMatrix[i].length; j++) {
                    double delta = firstMatrix[i][j] - secondMatrix[i][j];
                    destination += delta * delta;
                }
            }
        } else {
            String message = String.format(ErrorMessages.INCORRECT_MATRIX_SIZE,
                    firstMatrix.length, firstMatrix[0].length,
                    secondMatrix.length, secondMatrix[0].length);
            throw new StatisticException(new IllegalArgumentException(message));
        }
        return Math.sqrt(destination);
    }
}
