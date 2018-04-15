/*

https://projecteuler.net/problem=24

A permutation is an ordered arrangement of objects.
For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4.
If all of the permutations are listed numerically or alphabetically, we call it lexicographic order.
The lexicographic permutations of 0, 1 and 2 are:

012   021   102   120   201   210

What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?

*/

import java.util.*;
import java.math.*;

public class p24 {

	public static void main(String[] args) {

		int digits = 10;
		
		permutation(digits,factorial(digits));
		
	}

	public static void permutation(int n, int range) {

		int[] arr = new int[n];
		int[] duplicate = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = i;
			duplicate[i] = i;
		}

		int count, i, j, temp, index;
		count = 0;
		i = arr.length - 1;
		j = i - 1;

		String[] str = new String[range];

		index = 0;

		while (count < range) {

			int a = 0;

			while (a < factorial(arr.length - 1)) {

				if (j == 0) {
					i = arr.length - 1;
					j = i - 1;
				}

				String concat = "";

				for (int m = 0; m < arr.length; m++) {
					concat = concat + Integer.toString(arr[m]);
				}

				str[count] = concat;

				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;

				i--;
				j--;
				a++;
				count++;
			}

			index++;
			if (index > arr.length - 1) {
				break;
			}

			temp = duplicate[index - 1];
			arr[0] = duplicate[index];
			arr[index] = temp;

		}

		BigDecimal[] list = new BigDecimal[str.length];

		for (int p = 0; p < str.length; p++) {
			list[i] = new BigDecimal(str[p]);
			System.out.println(list[i]);
		}

		//return str;
	} 

	public static int factorial (int a) {

		int product = 1;

		for (int n = a; n >= 1; n--) {

			product = product * n;
		}

		return product;
	}
}