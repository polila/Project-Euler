/*

https://projecteuler.net/problem=15

Starting in the top left corner of a 2×2 grid,
and only being able to move to the right and down,
there are exactly 6 routes to the bottom right corner.

How many such routes are there through a 20×20 grid?

*/

import java.util.*;
import java.math.*;

public class p15 {
	
	public static void main(String[] args) {

		final int size = 20;
		BigInteger[][] grid = new BigInteger[size + 1][size + 1];

		// step sequence value in absolute terms;
		// east(0, 1), south(0,-1)
		// hence, there really is only 2 ways to make a move
		// and with each move having an absolute value of 1
		// each step is considered the direction of a vector
		// on the cartesian plane 2-D plane
		final BigInteger S = BigInteger.ONE; 

		for (int i = 0; i < 1; i++) {

			for (int j = 0; j < grid.length; j++) {

				grid[i][j] = S;
			}
			for (int k = 1; k < grid.length; k++) {

				grid[k][i] = S;
			}
		}
		
		for (int i = 1; i < grid.length; i++) {
			for (int j = 1; j < grid.length; j++) {
				grid[i][j] =  grid[i][j - 1].add(grid[i - 1][j]);
			}
		}
		/*
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
		*/
		System.out.println(grid[grid.length - 1][grid.length - 1]);
	}
}
