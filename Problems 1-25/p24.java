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


public class p24 {

	public static void main(String[] args) {

		int digits = 4;

		permutation(digits,factorial(digits));
	}

	public static void permutation(int n, int range) {

		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = i + 1;
		}

		int count, i, j, temp, index;
		count = 0;
		i = arr.length - 1;
		j = i - 1;

		String[] str = new String[range];

		while (count < range) {

			if (j < 0) {

				i = arr.length - 1;
				j = i - 1;

				temp = arr[i];
				arr[i] = arr[0];
				arr[0] = temp;
			}
			else {

				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;

				i--;
				j--;
			}

			String concat = "";

			for (int k = 0; k < arr.length; k++) {
				concat = concat + Integer.toString(arr[k]);
			}
			str[count] = concat;

			count++;
		}

		int[] list = new int[str.length];

		for (int k = 0; k < str.length; k++) {
			
			list[k] = Integer.valueOf(str[k]);
			System.out.println(list[k] + " term: " + (k + 1));
		}

		Arrays.sort(list);

		for (int k = 0; k < list.length; k++) {
			//System.out.println(list[k] + " term: " + (k + 1));
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