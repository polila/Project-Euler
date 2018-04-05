/*

https://projecteuler.net/problem=9

A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

a2 + b2 = c2
For example, 32 + 42 = 9 + 16 = 25 = 52.

There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.

reference: http://www.friesian.com/pythag.htm

*/

import java.util.*;

public class p09 {

	public static void main(String[] args) {

		int a, b, c, sum, product;
		
		int foo = 200;

		boolean found = false;

		do {

			a = foo;

			b = a + 1;

			c = b + 1;

			sum = 0;
			
			product = 1;
			
			int i = b;
			
			int j = c;

			for (i = b; a + i < 1000; i++) {
				for (j = c; a + i + j <= 1000; j++) {
					sum = a + i + j;
					if (sum == 1000  && a * a + i * i == j * j) {
						product = a * i * j;
						found = true;
						System.out.println("(" + a + "," + i + "," + j + "): "  + product);
						break;
					}
				}
			if (found) {break;}
			}
		} while (a + b + c <= 1000 && !found);
	}
}
