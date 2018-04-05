/*

https://projecteuler.net/problem=16

215 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

What is the sum of the digits of the number 21000?

*/

import java.util.*;
import java.math.*;

public class p16 {
	public static void main(String[] args) {

		//nCr(15,0)

		int a = 2;
		// x + y = a
		// 1 + 1 = 2
		// binomial expansion
		int x, y, exp;
		x = 1;
		y = 1;
		//exp = 15;
		//exp = 1000;
		exp = 2000;

		BigInteger sum, coefficient; 
		sum = BigInteger.ZERO;

		long startTime, endTime;
		startTime = System.nanoTime();
		for (int n = exp, k = 0; k <= 500; k++) {

			coefficient = nCr(n, k);

			System.out.println("(n,k) | (" + n + "," + k + "):= " + coefficient);

			sum = sum.add(nCr(n, k));
		}
		sum = sum.multiply(BigInteger.valueOf(2)).subtract(nCr(1000, 500));
		//endTime = System.nanoTime();

		System.out.println("\n(x+y)^n = (n,0)*(x)^n*(y)^0 + (n,1)*(x)^(n-1)*(y)^1 +.....+ (n,n)*(x)^(n-n)*(y)^n");
		System.out.println("\n(" + x + "+" + y + ")^" + exp + " = " + "(" + a + ")^" + exp);
		System.out.println("\nbase 10: " + sum);
		System.out.println("\nbase 2: "+ sum.toString(2));
		System.out.println("\nbit length: " + sum.bitLength());

		BigInteger digitSum, countTerms; 
		digitSum = BigInteger.ZERO;
		countTerms = BigInteger.ZERO;

		while (sum.compareTo(BigInteger.ONE) >= 0) {
			digitSum = digitSum.add(sum.mod(BigInteger.valueOf(10)));
			sum = sum.divide(BigInteger.valueOf(10));
		}

		System.out.println("sum of digits:= " + digitSum);
		endTime = System.nanoTime();
		System.out.println("execution time:= " + ((endTime - startTime) / 1000000000) + " seconds");
	}

	public static /*void*/ BigInteger nCr(int row, int column) {

		int rows = row + 1;
		
		BigInteger[][] arr = new BigInteger[rows][];
		arr[0] = new BigInteger[1];
		arr[0][0] = BigInteger.ONE;

		for (int i = 1; i < rows; i++) {
			arr[i] = new BigInteger[i + 1];
			arr[i][0] = BigInteger.ONE;
			arr[i][arr[i].length - 1] = BigInteger.ONE;
		}

		for (int i = 2; i < arr.length; i++) {
			for (int j = 1; j < arr[i].length - 1; j++) {
				arr[i][j] = arr[i-1][j - 1].add(arr[i - 1][j]);
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				// System.out.print(arr[i][j] + " ");
			}
			// System.out.println();
		}
		
		return arr[row][column];
	}
}
