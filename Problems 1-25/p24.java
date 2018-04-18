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

		String[] arr = new String[digits];

		for (int i = 0; i < digits; i++) {

			arr[i] = Integer.toString(i);
		}

		ArrayList<String> permutationList = new ArrayList<String>();

		permutation(arr, arr.length, permutationList);

		String[] p = new String[factorial(digits)];
		
		int index = 0;
		for (String str:permutationList) {

			p[index] = str;
			System.out.println(p[index] + " | unordered term: " + index);
			index++;
		}

		String temp;
		int count = 0;
		for (int i = 0; i < p.length - 1; i++) {

			for (int j = i + 1; j < p.length; j++) {

				System.out.print(p[i] + " ");

				if (p[i].compareTo(p[j]) > 0) {
					System.out.println(">" + p[j] + " | count:" + count);
					temp = p[i];
					p[i] = p[j];
					p[j] = temp;
				}
				else {
					System.out.println("< " + p[j] + " | count:" + count);
				}
				
				count++;
			}

		}

		for (int i = 0; i < p.length; i++) {
			System.out.println(p[i]);
		}

	}
	// Reference: https://introcs.cs.princeton.edu/java/23recursion/Permutations.java.html
	public static void permutation(String[] arr, int n, List<String> numbers) {

		if (n == 1) {

			String concat = "";

			for (int i = 0; i < arr.length; i++) {

				concat = concat + arr[i];
			}

			System.out.println(concat + " | counting");

			numbers.add(concat);

			return;
		}

		for (int i = 0; i < n; i++) {

			swap(arr, i, n - 1);

			permutation(arr, n - 1, numbers);

			swap(arr, i, n - 1);
		}
	}
	// Reference: https://introcs.cs.princeton.edu/java/23recursion/Permutations.java.html
	public static void swap(String[] arr, int i, int j) {
		
		String temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static int factorial(int a) {

		int product = 1;

		for (int n = a; n >= 1; n--) {

			product = product * n;
		}

		return product;
	}
}