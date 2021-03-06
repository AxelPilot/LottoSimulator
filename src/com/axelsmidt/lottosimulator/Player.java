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

    protected Ticket submitTicket() {
        Ticket ticket = new Ticket();
        this.balance -= 1; // Each submitted lottery ticket costs $1.
        return ticket;
    }

    protected void collectPrize(long prize) {
        this.balance += prize;
    }

    protected long getBalance() {
        return this.balance;
    }

}
