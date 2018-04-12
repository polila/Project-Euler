/*

Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.

For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284.
The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

Evaluate the sum of all the amicable numbers under 10000.

reference:
https://artofproblemsolving.com/wiki/index.php?title=Divisor_function
https://artofproblemsolving.com/wiki/index.php?title=Greatest_common_divisor
https://en.wikipedia.org/wiki/Amicable_numbers
*/

import java.util.*;
import java.math.*;

public class p21 {

	public static void main(String[] args) {
		
		int sum = 0;
		
		for (int i = 2; i < 10000; i++) {
		
			if (amicablePair(i)) {
		
				sum = sum + i;

				System.out.println("i: " + i + " | d(n): " + d(i) + " | sum: " + sum);
			}

			//System.out.println("i: " + i + " | d(n): " + d(i) + " | amicable number: " + amicablePair(i));
		}

		System.out.println(sum);
	}
	// A function to compute the sum of proper divisors of a number n.
	public static int d(int n) {

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

	public static boolean amicablePair(int n) {

		return d(d(n)) == n && d(n) != n;
	}

	public static boolean isPrime(int n) {

		if (n > 3) {
			if (n % 2 == 0 || n % 3 == 0) {
				return false;
			}
		}

		int range = sqrt(n / (double) (1.0));

		int d = 2;

		while (d < (int) range) {
			if (n % d == 0) {
				return false;
			}
			if (d * d >= n) {
				return d == n;
			}
			else {
				d++;
			}
		}

		return true;
	}

	public static int sqrt(double x) {

		double guess, q;
		guess = 1;

		while (abs(x  - guess * guess) >= 0.001){

			q = x / guess;

			guess = (guess + q) / 2;
		}

		return (int) guess;
	}

	public static double abs(double a) {
		
		double b = a;

		if (b < 0) {
			b = b * (-1);
		}

		return b;
	}
}