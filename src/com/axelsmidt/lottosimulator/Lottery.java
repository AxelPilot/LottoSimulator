package com.axelsmidt.lottosimulator;

import java.security.SecureRandom;
import java.util.Arrays;

/*
 *
 */
public class Lottery {

    int[] numbers = new int[7];

    /*
     * Draws the winning numbers, compares the result to the submitted lottery ticket,
     * and returns the prize won.
     */
    public long draw(int[] ticket) {
        SecureRandom randomNumbers = new SecureRandom();

        // Draw winning numbers.
        int n;
        int i = 0;
        while (i <= 6) {
            n = randomNumbers.nextInt(34) + 1;
            // Ensure that the same number is not drawn multiple times.
            if (isUnique(this.numbers, n)) {
                this.numbers[i] = n;
                i++;
            }
        }

        // Sort winning numbers in ascending order.
        Arrays.sort(this.numbers);

        return checkPrize(this.numbers, ticket);
    }

    private boolean isUnique(int[] a, int n) {
        boolean unique = true;
        if (a.length > 1) {
            for (int i = 0; i < a.length; i++) {
                if (a[i] == n) {
                    unique = false;
                }
            }
        }
        return unique;
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
                prize = 50000;
                break;
            case 6: // 2nd prize.
                prize = 350;
                break;
            case 5: // 3rd prize.
                prize = 15;
                break;
            case 4: // 4th prize.
                prize = 5;
        }

        return prize;
    }

    public int[] getLotteryNumbers() {
        return numbers;
    }
}
