/*

https://projecteuler.net/problem=14

n → 3n + 1 (n is odd)

Using the rule above and starting with 13, we generate the following sequence:

13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?

NOTE: Once the chain starts the terms are allowed to go above one million.

*/

import java.util.*;
import java.math.*;

public class p14 {
	
	public static void main (String[] args) {

		
		int limit, i, n, number;
		limit = 1000000;
		n = 1;
		number = n;

		BigInteger x, max;
		max = BigInteger.ZERO;

		for (i = n; i < limit; i = i + 2) {

			x = countTerms(BigInteger.valueOf(i));

			if (max.compareTo(x) < 0) {
				max = x;
				number = i;
			}

			System.out.println("number: " + i + " | terms: " + x);
		}

		System.out.println("\nnumber: " + number + " | terms: " + max);
		
		//System.out.print(countTerms(BigInteger.valueOf(13)));
		
	}

	public static BigInteger countTerms(BigInteger n) {

		if (n.equals(BigInteger.ONE)) {

			return BigInteger.valueOf(1);
		}
		else if (even(n)) {

			return (BigInteger.ONE).add(
				countTerms(
					n.divide(BigInteger.valueOf(2))));
		}
		else {
			return (BigInteger.ONE).add(
				countTerms(
					(n.multiply(BigInteger.valueOf(3))).add(BigInteger.ONE)));
		}
	}

	public static boolean even(BigInteger a) {
		return a.mod(new BigInteger("2")).equals(BigInteger.ZERO);
	}
}
