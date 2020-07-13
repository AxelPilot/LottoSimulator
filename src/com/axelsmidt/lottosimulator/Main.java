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

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int playAgain = 0;
        Scanner input = new Scanner(System.in);

        do {
            Lottery lottery = new Lottery();
            Player player = new Player(1000000); // Each game starts with a balance of $1000000,-.
            int drawCount;

            do {
                // How many times do you want to play?
                System.out.print("Number of draws: ");
                drawCount = input.nextInt();

                for (int i=0; i < drawCount; i++) {
                    // Let's play.
                    long prize = lottery.draw(player.submitTicket());

                    // Let's see what you won (if > $15).
                    if (prize > 15) {
                        System.out.println("Prize: " + prize);
                        player.collectPrize(prize);
                    }
                }

                // Your new balance is:
                System.out.println("Balance: " + player.getBalance());
            } while ((drawCount > 0) && (player.getBalance() > 0));

            if (player.getBalance() <= 0) {
                System.out.println("You lost!");
            }

            System.out.print("Do you want to play again? (1=Yes/0=No) ");
            playAgain = input.nextInt();

        } while (playAgain == 1);

    }
}
