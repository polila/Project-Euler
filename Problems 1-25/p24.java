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

		int digits = 4;

		int[] arr = new int[digits];

		for (int i = 0; i < arr.length; i++) {
			
			arr[i] = i;
		}

		permutation(arr);
	}

	public static void permutation(int[] list) {

		int[] arr = list;

		for (int count = 0; count < factorial(list.length); count++) {

			String str = "";

			for (int n = 0; n < list.length; n++) {

				str = str + list[n];
			}

			System.out.println(str);

			int i, j, k;
			i = arr.length - 1;
			j = i - 1;

			while (j >= 1) {

				int k = arr[i];
				arr[i] = arr[j];
				arr[j] = k;
			
				i--;
				j--;
			}
		}


	}

	public static int factorial(int a) {

		int product = 1;

		for (int n = a; n >= 1; n--) {

			product = product * n;
		}

		return product;
	}
}