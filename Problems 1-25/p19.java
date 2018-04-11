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

		Hashtable<Integer, String> months = new Hashtable<Integer, String>();
		months.put(1, "January");
		months.put(2, "February");
		months.put(3, "March");
		months.put(4, "April");
		months.put(5, "May");
		months.put(6, "June");
		months.put(7, "July");
		months.put(8, "August");
		months.put(9, "September");
		months.put(10, "October");
		months.put(11, "November");
		months.put(12, "December");

		int min, max;
		min = 1900;
		max = 2000;

		String[][] arr = new String[12 * (max - min + 1)][];

		// Total days starts at 1 to make modular arithmetic easier when accounting for days 
		// (i.e., 1 Monday, 2 Tuesday, etc.) and since the first day, hence, 0th day on 1 Jan 1900 is Monday.
		for (int year = min, index = 0, totalDays = 1; year <= max; year++) {

			for (int month = 1; month <= 12; month++, index++) {

				arr[index] = new String[numberOfDays(month,year)];

				int sum = 1;
				
				System.out.println(months.get(new Integer(month)) + " " + year);

				for (int day = 1; day <= numberOfDays(month, year); day++, totalDays++) {

					if (totalDays % 7 == 0) {

						arr[index][day - 1] = days.get(new Integer((totalDays % 7 + 7) % 365));							
					}
					else {

						arr[index][day - 1] = days.get(new Integer((totalDays % 7) % 365));							
					}

					if (sum > 7) {

						System.out.println();
						
						sum = 1;
					}

					System.out.print(totalDays + ":= " + arr[index][day - 1] + ", " + day + " | ");

					sum++;
				}

				System.out.println("\n");
			}
		}

		int count = 0;

		for (int i = 1; i < arr.length; i++) {

			if (arr[i][0] == "Sunday") {

				count++;
			}
		}
		// Subtract 1 from count since the total days were overstated by 1 before inititallizing array
		System.out.println("Number of Sundays that fell on the first of the month from: 1/Jan/1901 - 31/Dec/2000: " + (count - 1));
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

		return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}
}