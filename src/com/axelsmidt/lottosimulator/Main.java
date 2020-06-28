package com.axelsmidt.lottosimulator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Lottery lottery = new Lottery();
        Player player = new Player(1000000);
        int drawCount;

        do {
            Scanner input = new Scanner(System.in);

            System.out.print("Number of draws: ");
            drawCount = input.nextInt();

            for (int i=0; i < drawCount; i++) {
                long prize = lottery.draw(player.deliverCoupon());
                if (prize > 120) {
                    System.out.println("Prize: " + prize);
                    player.collectPrize(prize);
                }
            }

            System.out.println("Balance: " + player.getBalance());
        } while ((drawCount > 0) && (player.getBalance() > 0));

        if (player.getBalance() <= 0) {
            System.out.println("You lost!");
        }
    }
}
