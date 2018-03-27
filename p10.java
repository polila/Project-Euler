/*
https://projecteuler.net/problem=10

The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

Find the sum of all the primes below two million.


*/

import java.util.*;

public class p10 {

	public static void main(String[] args) {

		int range = 2000000;

		int i = 2;

		long sum = 0;
		
		int index = 1;
		
		while (i < range) {
			if (isPrime(i)) {
				sum = sum + i;
				System.out.println("p[" + index +  "]:=" + i + "  |  sum:= " + sum);
				index++;
			}
			i++;
		}
	}

	public static boolean isPrime(int n) {

		int max = (int) Math.sqrt(n);

		for (int i = 2; i <= max; i++) {
			// if n not prime, then there exist a divisor <= to sqrt of n.
			// hence, if i*i > n, and i does not divide n, then we can stop checking since n is prime.
			if (Math.pow(i, 2) > n) {
				// returns true if and only if i equals n.
				return  n % i == 0;
			}
			else if (n % i == 0) {
				return false;
			}
			else {
				continue;
			}
		}

		return true;
	}
}
