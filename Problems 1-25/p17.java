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

visual reference: https://www.englishclub.com/kids/numbers-chart.htm

*/

import java.util.*;

public class p17 {
	public static void main(String[] args) {

		Hashtable<Integer, String> ones = new Hashtable<Integer, String>();
		ones.put(0, "zero");
		ones.put(1, "one");
		ones.put(2, "two");
		ones.put(3, "three");
		ones.put(4, "four");
		ones.put(5, "five");
		ones.put(6, "six");
		ones.put(7, "seven");
		ones.put(8, "eight");
		ones.put(9, "nine");
		//Integer foo = new Integer(9);
		//System.out.print(ones.get(foo));
		//String foo = "eight";
		//System.out.print(ones.get(foo));

		Hashtable<Integer, String> tens = new Hashtable<Integer, String>();
		tens.put(10, "ten");
		tens.put(1, "teen");
		tens.put(11, "eleven");
		tens.put(12, "twelve");
		tens.put(2, "twen"); // twe-lve twe-nty
		tens.put(3, "thirty"); // thir-teen, thir-ty
		tens.put(4, "forty"); // for-ty
		tens.put(5, "fifty"); // fif-teen, fif-ty
		tens.put(6, "sixty");
		tens.put(7, "seventy");
		tens.put(8, "eighty");
		tens.put(9, "ninety");
		
		String[][] str = new String[20][];

		int j, k, digits, sum; 

		sum = 0;

		for (int i = 1; i <= 20; i++) {
			
			k = 0;

			j = i;
			
			digits = 0;

			while (j > 0) {

				k = k * 10 + j % 10;

				digits = digits + 1;

				j = j / 10;
			}
			
			str[i - 1] = new String[digits];

			Integer n;
			
			int index = 0;

			while (index < digits) {

				n = new Integer(k % 10);

				if (digits >= 3) {

				}
				else if (digits >= 2) {

				}
				else {
					
				}
				index++;

				//System.out.print(ones.get(n) + " ");
				k = k / 10;
			}
			//System.out.println();
		}

		for (int p = 0; p < str.length; p++) {

			System.out.print(str[p].length + ": ");
			
			//digits = str[p].length;

			for (int q = 0; q < str[p].length; q++) {
				
				//System.out.print("[" + q + "]" + str[p][q]); //ones.get(str[p][q]) + " ");

				//number = number * 10 + Integer.parseInt(ones.get(str[p][q]));

			}
			System.out.println();
		}
		
	}
}
