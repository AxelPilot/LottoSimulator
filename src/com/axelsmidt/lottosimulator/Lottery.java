/*
 * Copyright (c) 2020 Axel Smidt <http://AxelSmidt.com>.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package com.axelsmidt.lottosimulator;

import java.security.SecureRandom;
import java.util.Arrays;

/*
 * Main lottery class.
 */
public class Lottery {

    int[] numbers;

    /*
     * Draws the winning numbers, compares the result to the submitted lottery ticket,
     * and returns the prize won.
     */
    public long draw(int[] ticket) {
        SecureRandom randomNumbers = new SecureRandom();

        // Draw winning numbers.
        this.numbers = Lottery.generateUniqueNumbers(7);
        return checkPrize(ticket);
    }

    /*
     * Check which prize was won, if any.
     */
    private long checkPrize(int[] ticket) {
        int correctNumberCount = 0;
        long prize = 0;

        for (int i = 0; i <= 6; i++) {
            if (Arrays.binarySearch(this.numbers, ticket[i]) >= 0) {
                correctNumberCount++;
            }
        }

        switch (correctNumberCount) {
            case 7: // 1st prize.
                prize = 1500000;
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

    /*
     * Generates a sorted array the length of "count," with a sequence of
     * randomly generated unique int numbers.
     */
    public static int[] generateUniqueNumbers(int count) {
        SecureRandom randomNumbers = new SecureRandom();
        int[] a = new int[count];
        int n;
        int i = 0;
        while (i < count) {
            n = randomNumbers.nextInt(34) + 1;
            // Ensure that the same number is not drawn multiple times.
            if (Lottery.isUnique(a, n)) {
                a[i] = n;
                i++;
            }
        }

        // Sort winning numbers in ascending order.
        Arrays.sort(a);
        return a;
    }

    /*
     * Returns true if int n does not exist within int[] a.
     * Otherwise returns false.
     */
    private static boolean isUnique(int[] a, int n) {
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
}
