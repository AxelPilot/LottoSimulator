package com.axelsmidt.lottosimulator;

import java.security.SecureRandom;
import java.util.Arrays;

/*
 *
 */
public class Lottery {

    /*
     * Draws the winning numbers, compares the result to the submitted lottery ticket,
     * and returns the prize won.
     */
    public long draw(int[] ticket) {
        SecureRandom randomNumbers = new SecureRandom();
        int[] numbers = new int[7];

        // Draw winning numbers.
        for (int i = 0; i <= 6; i++) {
            numbers[i] = randomNumbers.nextInt(33) + 1;
        }

        // Sort winning numbers in ascending order.
        Arrays.sort(numbers);

        return checkPrize(numbers, ticket);
    }

    /*
     * Check which prize was won, if any.
     */
    private long checkPrize(int[] numbers, int[] ticket) {
        int correctNumberCount = 0;
        long prize = 0;

        for (int i = 0; i <= 6; i++) {
            if (Arrays.binarySearch(numbers, ticket[i]) >= 0) {
                correctNumberCount++;
            }
        }

        switch (correctNumberCount) {
            case 7: // 1st prize.
                prize = 14869835;
                break;
            case 6: // 2nd prize.
                prize = 4095;
                break;
            case 5: // 3rd prize.
                prize = 120;
                break;
            case 4: // 4th prize.
                prize = 50;
        }

        return prize;

    }
}
