/*

https://projecteuler.net/problem=17

If the numbers 1 to 5 are written out in words: 
one, two, three, four, five, then there are 
3 + 3 + 5 + 4 + 4 = 19 letters used in total.
If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words,
how many letters would be used?
NOTE: Do not count spaces or hyphens. 
For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. 
The use of "and" when writing out numbers is in compliance with British usage.

*/

import java.util.*;

public class p17 {
	public static void main(String[] args) {

		Hashtable<Integer, String> ones = new Hashtable<Integer, String>();
		ones.put(1, "one");
		ones.put(2, "two");
		ones.put(3, "three");
		ones.put(4, "four");
		ones.put(5, "five");
		ones.put(6, "six");
		ones.put(7, "seven");
		ones.put(8, "eight");
		ones.put(9, "nine");
		Integer foo = new Integer(9);
		System.out.print(ones.get(foo));

		Hashtable<Integer, String> tens = new Hashtable<Integer, String>();
		tens.put(10, "ten");
		tens.put(1, "teen");
		tens.put(11, "eleven");
		tens.put(12, "twelve");
		tens.put(2, "twen"); // twe-lve twe-nty
		tens.put(3, "thir"); // thir-teen, thir-ty
		tens.put(4, "for"); // for-ty
		tens.put(5, "fif"); // fif-teen, fif-ty
		tens.put(6, ones.get(6));
		tens.put(7, ones.get(7));
		tens.put(8, ones.get(8));
		tens.put(9, ones.get(9));

		String[][] str = new String[1000][];

		int j, k, digits, sum; 

		sum = 0;

		for (int i = 1; i <= 12; i++) {
			
			j = i;
			
			digits = 0;

			k = 0;

			while (j > 0) {

				k = k * 10 + (j % 10);

				digits = digits + 1;

				j = j / 10;
			}
			
			str[i] = new String[digits];

			Integer n;
			
			while (k > 0 && digits >= 0) {

				n = new Integer(k % 10);

				str[i][digits - 1] = ones.get(n);
				System.out.println(ones.get(n));
				k = k / 10;

				digits = digits - 1;
			}
			System.out.println();
		}

		for (int m = 0; m < str.length; m++) {
			for (int n = 0; n < str[m].length; n++) {
				System.out.print(str[m][n] + "-->");
			}
			System.out.println();
		}
	}
}
