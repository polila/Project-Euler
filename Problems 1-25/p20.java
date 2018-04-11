/*

n! means n × (n − 1) × ... × 3 × 2 × 1

For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

Find the sum of the digits in the number 100!

*/

import java.util.*;
import java.math.*;

public class p20 {
	
	public static void main(String[] args) {

		int n = 100;

		String str = factorial(BigInteger.valueOf(n)).toString();

		String[] arr = str.split("");

		int sum = 0;

		for (int i = 0; i < arr.length; i++) {

			sum = sum + Integer.parseInt(arr[i]);
		}

		System.out.print(n + "! = " + str + " \nsum of digits: " + sum);
	}

	public static BigInteger factorial(BigInteger k) {


		if (k.equals(BigInteger.ONE)) {
			return BigInteger.ONE;
		}
		else {

			return k.multiply(factorial(k.subtract(BigInteger.ONE)));
		}
	} 

}