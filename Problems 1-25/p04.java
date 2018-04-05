/* 
https://projecteuler.net/problem=4
A palindromic number reads the same both ways.
The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
Find the largest palindrome made from the product of two 3-digit numbers.
*/

import java.util.*;

public class p04 {
  
  public static void main(String[] args) {
    
    int[] arr;
    
    int count = 0;
    
    for (int i = 999; i > 99; i--) {
      for (int j = i; j > 99; j--) {
        if (isPalindrome(i * j)) {
          count++;
        }
      }
    }
        
    arr = new int[count];
    
    for (int i = 999; i > 99; i--) {
      for (int j = i; j > 99; j--) {
        if (isPalindrome(i * j)) {
        	arr[i] = i * j;
        }
      }
    }
    
    Arrays.sort(arr);
    
    int max = arr[count-1];
    
    System.out.print(max);
  }
  
  public static boolean isPalindrome(int ab) {
        
    int count = 0;
    
    for (int i = ab; i > 0; i = i / 10) {
      count++;
    }
    
    int left, right;
            
    for (int i = 0, exp = count - 1; i < count / 2; i++, exp--) {
                
      left =  (ab / ((int)Math.pow(10, exp))) % 10;
                
      right = (ab / ((int) Math.pow(10, i))) % 10;
                
      if (left != right) {
        return false;
      }
    }
    
    return true;
    
  }
}
