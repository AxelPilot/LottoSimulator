package com.axelsmidt.lottosimulator;

import java.security.SecureRandom;
import java.util.Arrays;

/*
 *
 */
public class Lottery {

    /*
     * Draws the winning numbers, compares the result to the delivered coupon,
     * and returns the prize won.
     */
    public long draw(int[] coupon) {
        SecureRandom randomNumbers = new SecureRandom();
        int[] numbers = new int[7];
        int prize = 0;

        // Draw winning numbers.
        for (int i = 0; i <= 6; i++) {
            numbers[i] = randomNumbers.nextInt(33) + 1;
        }

        // Sort winning numbers in ascending order.
        Arrays.sort(numbers);

        return checkPrize(numbers, coupon);
    }

    /*
     * Check which prize was won, if any.
     */
    private long checkPrize(int[] numbers, int[] coupon) {
        int correctNumberCount = 0;
        long prize = 0;

        for (int i = 0; i <= 6; i++) {
            if (Arrays.binarySearch(numbers, coupon[i]) >= 0) {
                correctNumberCount++;
            }
        }

        switch (correctNumberCount) {
            case 7:
                prize = 14869835;
                break;
            case 6:
                prize = 4095;
                break;
            case 5:
                prize = 120;
                break;
            case 4:
                prize = 50;
        }

        return prize;

    }
}
