package com.axelsmidt.lottosimulator;

public class Player {
    private long balance;

    public Player(int balance) {
        this.balance = balance;
    }

    public int[] submitTicket() {
        int[] ticket;
        ticket = Lottery.generateUniqueNumbers(7);
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
