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

		String con = "";

		for (int i = 0; i < digits; i++) {

			con += Integer.toString(i);
		}

		ArrayList<String> permutationList = new ArrayList<String>();

		permutation(con, permutationList);

		String[] p = new String[factorial(digits)];
		
		int index = 0;
		for (String str:permutationList) {
			if (index <= 1000000) {
				p[index] = str;
				System.out.println(p[index] + " | ordered term: " + index);
				index++;
			}
			else {
				break;
			}
		}
	}
	// Reference: https://introcs.cs.princeton.edu/java/23recursion/Permutations.java.html
    public  static void permutation(String s, List<String> arr) { permutation("", s, arr); }
    private static void permutation(String prefix, String s, List<String> arr) {
        int n = s.length();
        if (n == 0) arr.add(prefix);
        else {
            for (int i = 0; i < n; i++)
               permutation(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, n), arr);
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