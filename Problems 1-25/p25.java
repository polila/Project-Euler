/*

The Fibonacci sequence is defined by the recurrence relation:

Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
Hence the first 12 terms will be:

F1 = 1
F2 = 1
F3 = 2
F4 = 3
F5 = 5
F6 = 8
F7 = 13
F8 = 21
F9 = 34
F10 = 55
F11 = 89
F12 = 144
The 12th term, F12, is the first term to contain three digits.

What is the index of the first term in the Fibonacci sequence to contain 1000 digits?

*/

import java.util.*;
import java.math.*;

public class p25 {

	public static void main(String[] args) {

		int digits;

		for (int i = 0; i <= 10000; i++) {

			digits = fibonacci(i).length();

			if (i <= 12) {
				System.out.println("Term: " + i + " = " + fibonacci(i) + " | Digits: " + digits);
			}


			if (digits == 1000) {
				System.out.println("Term: " + i + " = " + fibonacci(i));
				System.out.println("Digits: " + digits);
				break;
			}
		}

	}

	public static String fibonacci(int n) {

		BigDecimal i, j, temp;
		i = BigDecimal.ONE;
		j = BigDecimal.ZERO;

		if (n <= 1) {
			return j.toString();
		}
		else {
			while (n > 0) {
				temp = i;
				i = i.add(j);
				j = temp;
				n--;
			}
		}

		return j.toString();
	}
}