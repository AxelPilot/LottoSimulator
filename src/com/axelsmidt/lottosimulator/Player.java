/*
 * Copyright (c) 2020 Axel Smidt.
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

/**
 * Player class
 */
class Player {
    private long balance;

    public Player(long balance) {
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
