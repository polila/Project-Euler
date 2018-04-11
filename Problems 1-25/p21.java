/*

Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.

For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284.
The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

Evaluate the sum of all the amicable numbers under 10000.

*/

import java.util.*;
import java.math.*;

public class p21 {

	public static void main(String[] args) {


		int n, i;
		n = 220;
		i = 2;

		int count, divisors;
		divisors = 2;

		do {

			count = 0;

			if (n % i == 0) {

				while (n % i == 0) {
					
					n = n / i;

					count++;
				}

				divisors = divisors * (count + 1);

				i = i + 3;
			}

			else {

				i = i + 1;
			}

		} while (i < n);

		System.out.println(divisors);

		int[] d = new int[divisors];

		
	}
}