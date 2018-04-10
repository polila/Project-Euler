/*

https://projecteuler.net/problem=19

You are given the following information, but you may prefer to do some research for yourself.

1 Jan 1900 was a Monday.
Thirty days has September,
April, June and November.
All the rest have thirty-one,
Saving February alone,
Which has twenty-eight, rain or shine.
And on leap years, twenty-nine.
A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?

*/

import java.util.*;

public class p19 {

	public static void main(String[] args) {

		Hashtable<Integer, String> days = new Hashtable<Integer, String>();
		days.put(1, "Monday");
		days.put(2, "Tuesday");
		days.put(3, "Wednesday");
		days.put(4, "Thursday");
		days.put(5, "Friday");
		days.put(6, "Saturday");
		days.put(7, "Sunday");

		String[][] months = new String[100 * 12][];

		int sum = 0;

		for (int year = 1901; year <= 2018; year++) {

			for (int month = 1; month <= 12; month++) {

				for (int day = 1; day <= numberOfDays(month, year); day++) {
	
					sum = sum + 1;
				}
			}
		}

		System.out.print(sum);
	}

	public static int numberOfDays (int month, int year) {

		int days = 0;

		switch (month) {
			case 7: 
			case 4: 
			case 6: 
			case 11:
				days = 30;
				break;
			case 2:
				if (isLeapYear(year)) {
					days = 29;
				} 
				else {
					days = 28;
				}
				break;
			default: days = 31;
				break;   
		}

		return days;
	}

	public static boolean isLeapYear(int year) {

		return (year % 4 == 0 && year % 100  != 0) || (year % 400 == 0);
	}
}