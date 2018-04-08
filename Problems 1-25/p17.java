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

		int sum = 0;

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
		ones.put(0, " ");

		int a = 1;

		Integer b;
		
		while (a < 10) {

			b = new Integer(a % 10);

			sum = sum + ones.get(b).length();

			System.out.println("number: " + a + " | word: " + ones.get(b) + " | length of word: " + ones.get(b).length() + " | sum of letters: " + sum);

			a++;
		}

		int range = 999;

		String[][] str = new String[range - 9][];

		int j, k, digits; 

		for (int i = 10; i <= range; i++) {
			
			k = 0;

			j = i;
			
			digits = 0;

			while (j > 0) {

				k = k * 10 + j % 10;

				digits = digits + 1;

				j = j / 10;
			}
			
			str[i - 10] = new String[digits];
			
			int index = 0;

			Integer n;

			while (index < digits) {

				n = new Integer(k % 10);

				str[i - 10][index] = ones.get(new Integer(k % 10));

				k = k / 10;
				
				index++;
			}
		}

		Hashtable<String, String> tens = new Hashtable<String, String>();
		tens.put("one", "teen");
		tens.put("two", "twenty");
		tens.put("three", "thirty");
		tens.put("four", "forty");
		tens.put("five", "fifty");
		tens.put("six", "sixty");
		tens.put("seven", "seventy");
		tens.put("eight", "eighty");
		tens.put("nine", "ninety");

		String hundred, ten, one, conCat;

		for (int p = 0; p < str.length; p++) {
			
			hundred = "";

			ten = "";

			one = "";

			digits = str[p].length;
			
			if (digits == 3) {
			
				hundred = str[p][0] + "hundred";

				if (str[p][1] == " " && str[p][2] == " ") {

					hundred = hundred;

				}
				else {

					hundred += "and";

					one = str[p][2];

					if (str[p][1] != " ") {

						ten = tens.get(str[p][1]);

						if (ten == "teen") {
							
							String temp = ten;

							switch (one) {
								case " ": ten = "ten"; one = "";
									break;
								case "one": ten = "eleven"; one = "";
									break;
								case "two": ten = "twelve"; one = "";
									break;
								case "three": ten = "thir"; one = temp;
									break;
								case "five": ten = "fif"; one = temp;
									break;
								case "eight": ten = "eigh"; one = temp;
									break;
								default: ten = one; one = temp;
									break;
							}
						}
					}

					if ((one != "") && (one != "teen") && (str[p][2] != " ")) {
						one = str[p][2];
					}
				}
			}

			else {

				ten = tens.get(str[p][0]);

				one = str[p][1];

				if (ten == "teen") {
							
				String temp = ten;

					switch (one) {
						case " ": ten = "ten"; one = "";
							break;
						case "one": ten = "eleven"; one = "";
							break;
						case "two": ten = "twelve"; one = "";
							break;
						case "three": ten = "thir"; one = temp;
							break;
						case "five": ten = "fif"; one = temp;
							break;
						case "eight": ten = "eigh"; one = temp;
							break;
						default: ten = one; one = temp;
							break;
					}
				}
			}
			if (one == "" || one == " ") {
				conCat = hundred + "" + ten;
			}
			else {
				conCat = hundred + "" + ten + "" + one;
			}
			sum += conCat.length();

			System.out.println("number: " + (p+10) + " | word: " + hundred  + " " + ten + " " + " "+ one +  " | concatenated: " + conCat + " | length of word: " + conCat.length() + " | sum of letters: " + sum);
		}

		sum = sum + "onethousand".length();

		System.out.println("\nThe sum of the letters from 1 to " + (range + 1) + " is: " + sum);
	}
}