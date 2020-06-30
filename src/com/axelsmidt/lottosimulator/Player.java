package com.axelsmidt.lottosimulator;

import java.security.SecureRandom;
import java.util.Arrays;

public class Player {
    private long balance;

    public Player(int balance) {
        this.balance = balance;
    }

    public int[] deliverTicket() {
        int[] ticket = new int[7];
        SecureRandom randomNumbers = new SecureRandom();

        int n;
        int i = 0;
        while (i <= 6) {
            n = randomNumbers.nextInt(34) + 1;
            // Ensure that the same number is not drawn multiple times.
            if (Lottery.isUnique(ticket, n)) {
                ticket[i] = n;
                i++;
            }
        }
        Arrays.sort(ticket);

/*
        System.out.print(ticket[0] + ", ");
        System.out.print(ticket[1] + ", ");
        System.out.print(ticket[2] + ", ");
        System.out.print(ticket[3] + ", ");
        System.out.print(ticket[4] + ", ");
        System.out.print(ticket[5] + ", ");
        System.out.println(ticket[6]);
 */
        this.balance -= 1; // Each submitted lottery ticket costs $1.
        return ticket;
    }

    public void collectPrize(long prize) {
        this.balance += prize;
    }

    public long getBalance() {
        return this.balance;
    }

}
