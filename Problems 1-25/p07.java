/*
https://projecteuler.net/problem=7

By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

What is the 10 001st prime number?
*/

import java.util.*;

public class p07 {

     public static void main(String []args){
         
       Scanner in = new Scanner(System.in);
       
       int[] p = new int[10001];
       
       p[0] = 2;
       p[1] = 3;
       p[2] = 5;
       p[3] = 7;
       p[4] = 11;
       p[5] = 13;
       
       int j;
       for (int i = 6; i < p.length; i++) {
           j = p[i - 1] + 1;
           do {
               if (isPrime(j, p, i - 1)) {
                   p[i] = j;
               }
               j++;
           } while (!isPrime(j - 1, p, i - 1));
       }
       
       System.out.print(p[p.length - 1]);
     }
     
     public static boolean isPrime (int n, int[] arr, int index) {
         for (int i = 0; i < index; i++) {
             if (n % arr[i] == 0) {
                 return false;
             }
         }
         
         return true;
     }
}
