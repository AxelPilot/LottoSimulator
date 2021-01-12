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

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Main class
 */
public class Main {

    private static final long DEFAULT_BALANCE = 1000000;

    public static void main(String[] args) {
        long balance = DEFAULT_BALANCE;
        try {
            if (args.length > 0) balance = Long.parseLong(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid parameters. An integer value is required!");
        }

        int playAgain = 0;
        Scanner input = new Scanner(System.in);

        do {
            Lottery lottery = new Lottery();
            Player player = new Player(balance); // Each game starts with a balance of $1000000,-.
            int drawCount = 0;

            do {
                long[][] prizes = new long[4][2];
                // How many times do you want to play?

                boolean validInput = false;
                do {
                    System.out.println();
                    System.out.println("Balance: " + player.getBalance());
                    System.out.print("Number of draws: ");
                    try {
                        drawCount = input.nextInt();
                        validInput = true;
                    } catch (InputMismatchException e) {
                        System.out.println();
                        System.out.println("An integer value is required!");
                        System.out.println("Please try again!");
                        input.nextLine();
                    }
                } while (!validInput);

                int j = 0;
                while ((j < drawCount) && (player.getBalance() > 0)) {
                    j++;
                    // Let's play.
                    long[] prize = lottery.draw(player.submitTicket());

                    // Let's see what you won.
                    if (prize[1] > 0) {
                        prizes[(int) prize[0]][0]++;

                        player.collectPrize(prize[1]);
                    }
                }

                if (drawCount > 0) {
                    long[] p = lottery.getPrizes();

                    for (int i = 0; i < p.length; i++) {
                        prizes[i][1] = p[i];
                    }

                    // Displaying prizes won.
                    System.out.println("1st prize: " + prizes[0][0] + "x" + prizes[0][1] + " = " + prizes[0][0] * prizes[0][1]);
                    System.out.println("2nd prize: " + prizes[1][0] + "x" + prizes[1][1] + " = " + prizes[1][0] * prizes[1][1]);
                    System.out.println("3rd prize: " + prizes[2][0] + "x" + prizes[2][1] + " = " + prizes[2][0] * prizes[2][1]);
                    System.out.println("4th prize: " + prizes[3][0] + "x" + prizes[3][1] + " = " + prizes[3][0] * prizes[3][1]);

                }
            } while ((drawCount > 0) && (player.getBalance() > 0));

            // Your new balance is:
            System.out.println("Balance: " + player.getBalance());

            if (player.getBalance() <= 0) {
                System.out.println();
                System.out.println("You lost!");
            }

            boolean validInput = false;
            do {
                System.out.println();
                System.out.print("Do you want to play again? (1=Yes/0=No) ");
                try {
                    playAgain = input.nextInt();
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println();
                    System.out.println("An integer value is required!");
                    System.out.println("Please try again!");
                    input.nextLine();
                }
            } while (!validInput);

        } while (playAgain == 1);

        System.out.println();
        System.out.println("Game over!");
    }
}
