/*

https://projecteuler.net/problem=23

A perfect number is a number for which the sum of its proper divisors is exactly equal to the number.
For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.

A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.

As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant numbers is 24.
By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers.
However, this upper limit cannot be reduced any further by analysis
even though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.

Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.

*/

import java.util.*;
import java.math.*;

public class p23 {

	public static void main(String[] args) {

		int limit = 28123;

		int[] arr = abundants(limit);

		int sum = 0;

		for (int i = 1; i <= limit; i++) {

			if (!abundantSum(i, arr)) {

				sum = sum + i;
			}
		}

		System.out.print(sum);
	}

	public static boolean abundantSum(int x, int[] arr) {

		for (int i = 0; i < arr.length; i++) {

			int n , count;

			for (int j = i; j < arr.length; j++) {

				n = arr[i] + arr[j];

				if (n == x) {

					return true;
				}
			}
		}

		return false;
	}

	public static int[] abundants(int range) {

		int count = 0;

		for (int i = 1; i <= range; i++) {
			if (isAbundant(i)) {
				count++;
			}
		}

		int[] arr = new int[count];

		for (int i = 0, j = 1; j <= range; j++) {

			if (isAbundant(j)) {

				arr[i] = j;
				i++;
			}
		}

		return arr;
	}

	public static boolean isAbundant(int n) {
		
		return d(n) > n;
	}

	public static boolean isDeficient(int n) {
		
		return d(n) < n;
	}

	public static boolean isPerfect(int n) {

		return d(n) == n;
	}
	// A function to compute the sum of proper divisors of a number n.
	public static int d(int n) {
		if (n == 0) {
			return -1;
		}

		if (isPrime(n)) {
			// Prime numbers have exactly one proper divisor, 1.
			return 1;
		}

		int i, count, divisors, number;
		i = 2;
		number = n;

		int sum = 1;

		do {

			divisors = 0;

			if (n % i == 0) {

				count = 0;

				// Find prime factors.
				while (n % i == 0) {

					n = n / i;
					// Count how many times factor can be raised.
					count++;
				}

				int j, product;
				j = 0;
				product = 1;

				while (j < count) {
					
					product = product * i;
					// Sum the factor and itself raised to
					// the possible powers it can be raised.
					divisors = divisors + product;

					j++;
				}
				// The sum of divisors can be expressed
				// as the prodduct of the sum of the
				// factors and the powers it can be raised;
				// (1 + 1p^1 + 1p^2 + . . . + 1p^k) x (1 + 2p^1 + 2p^2 + . . . + 2pk)
				sum = sum * (1 + divisors);
			}

			i++;

		} while (i <= n);

		// Subtract n since proper divisors
		// are divisors other than the number itself.
		sum = sum - number;

		return sum;
	}

	public static boolean isPrime(int n) {

		if (n <= 1) {
			return false;
		}

		else if (n <= 3){
			return true;
		}

		else if (n % 2 == 0 || n % 3 == 0) {
			return false;
		}

		else {

			int i = 5;

			while (i * i <= n) {

				if (n % i == 0 || n % (i + 2) == 0) {

					return false;
				}

				i = i + 6;
			}
		}

		return true;
	}
}