/*

https://projecteuler.net/problem=22

Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.

For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.

What is the total of all the name scores in the file?

*/

import java.util.*;
import java.io.*;

public class p22 {
	public static void main(String[] args) throws IOException {

		int[] charValue = new int[('Z' - 'A' ) + 1];

		Hashtable<String, Integer> letterValue = new Hashtable<String, Integer>();

		String letter;

		for (int i = 0, j = (int) 'A'; i < charValue.length; i++, j++) {

			charValue[i] = j - 64;

			letter = Character.toString((char) j);

			letterValue.put(letter, charValue[i]);
		}

		String file = "p022_names.txt";

		Scanner in = null;

		int sum, position;
		position = 1;

		String str, temp;

		char ch;

		Hashtable<String, Integer> nameValue = new Hashtable<String, Integer>();

		Hashtable<String, Integer> namePosition = new Hashtable<String, Integer>();

		Hashtable<Integer, String> nameIndex = new Hashtable<Integer, String>();

		try {

			in = new Scanner(new BufferedReader(new FileReader(file)));

			while (in.useDelimiter(",").hasNext()) {
					
					str = in.next();

					temp = "";

					sum = 0;

					for (int i = 1; i < str.length() - 1; i++) {

						ch = str.charAt(i);

						temp = temp + Character.toString(ch);

						sum = sum + letterValue.get(Character.toString(ch));
					}

					nameIndex.put(position,temp);

					nameValue.put(temp,sum);

					namePosition.put(temp,position);

					position++; 
			}
		} finally {

			if (in != null) {

				in.close();
			}
		}

		String[] arr = new String[position - 1];

		String name;

		for (int i = 0; i < arr.length; i++) {

			name = nameIndex.get(i + 1);

			arr[i] = name;
		}

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i].compareTo(arr[j]) > 0) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}

		sum = 0;

		int product;

		for (int i = 0; i < arr.length; i++) {

			product = nameValue.get(arr[i]) * (i + 1);

			sum = sum + product;
			
		}

		System.out.println("Total of all name score is: " + sum);
	}
}