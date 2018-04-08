/*

By starting at the top of the triangle below and moving to adjacent numbers on the row below,
the maximum total from top to bottom is 23.

3
7 4
2 4 6
8 5 9 3

That is, 3 + 7 + 4 + 9 = 23.

Find the maximum total from top to bottom of the triangle below:

75
95 64
17 47 82
18 35 87 10
20 04 82 47 65
19 01 23 75 03 34
88 02 77 73 07 63 67
99 65 04 28 06 16 70 92
41 41 26 56 83 40 80 70 33
41 48 72 33 47 32 37 16 94 29
53 71 44 65 25 43 91 52 97 51 14
70 11 33 28 77 73 17 78 39 68 17 57
91 71 52 38 17 14 91 43 58 50 27 29 48
63 66 04 68 89 53 67 30 73 16 69 87 40 31
04 62 98 27 23 09 70 98 73 93 38 53 60 04 23

NOTE: As there are only 16384 routes, it is possible to solve this problem by trying every route.
However, Problem 67, is the same challenge with a triangle containing one-hundred rows; 
it cannot be solved by brute force, and requires a clever method! ;o)

*/

import java.util.*;

public class p18 {
	
	public static void main(String[] args) {

		String str = "75 "+
					 "95 64 " +
					 "17 47 82 " +
					 "18 35 87 10 " +
					 "20 04 82 47 65 " +
					 "19 01 23 75 03 34 " +
					 "88 02 77 73 07 63 67 " +
					 "99 65 04 28 06 16 70 92 " +
					 "41 41 26 56 83 40 80 70 33 " +
					 "41 48 72 33 47 32 37 16 94 29 " +
					 "53 71 44 65 25 43 91 52 97 51 14 " +
					 "70 11 33 28 77 73 17 78 39 68 17 57 " + 
					 "91 71 52 38 17 14 91 43 58 50 27 29 48 " +
					 "63 66 04 68 89 53 67 30 73 16 69 87 40 31 " +
					 "04 62 98 27 23 09 70 98 73 93 38 53 60 04 23";

		String[] list = str.split(" ");

		int[][] arr = new int[15][];

		for (int i = 0, k = 0; i < arr.length; i++) {
			
			arr[i] = new int[i + 1];

			for (int j = 0; j < i + 1; j++, k++) {

				arr[i][j] = Integer.parseInt(list[k]);
			}
		}

		int[][] nCr = pascalTriangle(arr.length);


		int[][] sums = new int[15][];

		for (int i = 0; i < sums.length; i++) {

			sums[i] = new int[nCr[nCr.length - 1][i]];

			for (int j = 0; j < sums[i].length; j++) {
				
				sum[j] = routes(arr); 
			}
		}
	}

	public static int routes(int[] arr) {
		int sum = 0;

		

		return sum;
	}

	public static int[][] pascalTriangle(int size) {

		int[][] arr = new int[size][];

		arr[0] = new int[1];
		arr[0][0] = 1;

		for (int i = 1; i < size; i++) {

			arr[i] = new int[i + 1];

			for (int j = 0; j < i + 1; j++) {

				if (j == 0 || j == i) {
					arr[i][j] = 1;
				}

				else {
					arr[i][j] = 0;
				}
			}
		}

		for (int i = 2; i < size; i++) {

			for (int j = 1; j < arr[i].length - 1; j++) {

				arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
			}
		}

		return arr;
	}

	public static int binomialTerm(int n, int k) {

		int[][] arr = pascalTriangle(n);

		return arr[n-1][k];
	}
}