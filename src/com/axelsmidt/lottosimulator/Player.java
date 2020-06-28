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

        for (int i = 0; i <= 6; i++) {
            ticket[i] = randomNumbers.nextInt(33) + 1;
        }
        Arrays.sort(ticket);
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
