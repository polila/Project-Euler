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

public class p17 {
	public static void main(String[] args) {

		//[1,1000]
		final int thousand = 1;
		int hundredsDigit, hundred, and;
		//100,101,...,999
		hundredsDigit = 9 * 100;
		//101,102, 
		hundred = 9 * 100;
		//101,102,...,199,201,...,901,...,999
		and = 99 * 9;
		
		String s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12;
		s1 = "one".length();letters
		s2 = "two".length();
		s3 = "three".length();
		s4 = "four".length();
		s5 = "five".length();
		s6 = "six".length();
		s7 = "seven".length();
		s8 = "eight".length();
		s9 = "nine".length();
		s10 = "ten".length();
		s11 = "eleven".length();
		s12 = "twelve".length();

		//String[] arr = new String[]

		char ch = '8';

		String str = Character.toString(ch);

		System.out.print(ch + " | " + str);
	}
}
