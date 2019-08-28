package com.murali.ds.other;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SnackLadderGame {
	
	private static final boolean sixesThrowAgain = true;
	private static Random rand = new Random();
	
	private static final Map<Integer, Integer> snl = new HashMap(){{
		put(4, 14);
		put(9, 31);
		put(17, 7);
		put(20, 38);
		put(28, 84);
		put(40, 59);
		put(51, 67);
		put(54, 34);
		put(62, 19);
		put(63, 81);
		put(64, 60);
		put(71, 91);
		put(87, 24);
		put(93, 73);
		put(95, 75);
		put(99, 78);
	}};

	public static void play() {
		// three players starting on square one
		int[] players = {1, 1, 1};
		while (true) {
			for (int i = 0; i < players.length; ++i) {
				int ns = turn(i + 1, players[i]);
				if (ns == 100) {
					System.out.printf("Player %d wins!\n", i + 1);
					return;
				}
				players[i] = ns;
				System.out.println();
			}
		}
	}
	
	private static int turn(int player, int square) {
		int square2 = square;
		
		while (true) {
			int roll = rand.nextInt(6) + 1;
			System.out.printf("Player %d, on square %d, rolls a %d", player, square2, roll);
			if (square2 + roll > 100) {
				System.out.println(" but cannot move.");
			} else {
				square2 += roll;
				System.out.printf(" and moves to square %d\n", square2);
				if (square2 == 100) 
					return 100;
				
				if(snl.containsKey(square2)) {
					Integer next =  snl.get(square2);
					if (square2 < next) {
						System.out.printf("Yay! Landed on a ladder. Climb up to %d.\n", next);
						if (next == 100) return 100;
						square2 = next;
					} else if (square2 > next) {
						System.out.printf("Oops! Landed on a snake. Slither down to %d.\n", next);
						square2 = next;
					}
				}
			}
			
			if (roll < 6 || !sixesThrowAgain) 
				return square2;
			
			System.out.println("Rolled a 6 so roll again.");
		}
	}
}

