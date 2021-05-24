/*

  Given a triangle of consecutive odd numbers:

               1
            3     5
         7     9    11
     13    15    17    19
  21    23    25    27    29
  ...
  find the triangle's row knowing its index (the rows are 1-indexed), e.g.:

  odd_row(1)  ==  [1]
  odd_row(2)  ==  [3, 5]
  odd_row(3)  ==  [7, 9, 11]
  Note: your code should be optimized to handle big inputs.

*/

import java.util.Arrays;

public class RowOfOddTriangle {
  
  public static void main(String[] args)
  {
	 System.out.println(Arrays.toString(oddRow(3)));
     System.out.println(Arrays.toString(oddRow(5)));
     System.out.println(Arrays.toString(oddRow(31)));
  }
  
 public static long[] oddRow(int n) {
   
     // Number of elements in each row is the same as the row number.
     long[] row = new long[n];

   	
     // Calculate first value of row using Algebra skills.
     // (Make a table and come up with a formula)
     // Type cast n to prevent overflow - n*n can be LARGE!!!!!!!
     long first = (long)n*n -n + 1;

	
     // Fill up array - elements are spaced out with a difference of 2
     for(int i=0; i<row.length; i++) {
       row[i] = first;
       first += 2;
     }




     return row;
    
  }
}
