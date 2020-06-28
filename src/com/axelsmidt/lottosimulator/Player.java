package com.axelsmidt.lottosimulator;

import java.security.SecureRandom;
import java.util.Arrays;

public class Player {
    private long balance;

    public Player(int balance) {
        this.balance = balance;
    }

    public int[] deliverTicket() {
        int[] coupon = new int[7];
        SecureRandom randomNumbers = new SecureRandom();

        for (int i = 0; i <= 6; i++) {
            coupon[i] = randomNumbers.nextInt(33) + 1;
            this.balance -= 5;
        }
        Arrays.sort(coupon);
        return coupon;
    }

    public void collectPrize(long prize) {
        this.balance += prize;
    }

    public long getBalance() {
        return this.balance;
    }

}
