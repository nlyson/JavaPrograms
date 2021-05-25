/*
  Program Name: Changpu.java Test Input File: changpu.dat Changpu has just learned about numbers and their complements, 
  especially since a complement is slightly different than the opposite of a number. 
  
  He decides to write a simple program to test his newfound knowledge, but needs a little help. For fun, he wants to take any number, 
  negative or non-negative, and print its complement if it is even, otherwise just print its opposite value if it is odd. For example, the values 0 and -1 are complement values. So are 1 and -2, 2 and -3, 3 and -4, and so on. Opposites are different. The opposite of 1 is -1, 2’s opposite is -2, and so on. Input: A series of two-digit integers, all on one line, with single space separation. Output: For each input integer N, if it is even, print N and its complement value, otherwise print N and its opposite value, with single space separation.
  
  Sample Input:
  83 -70 81 -13 51
  
  Sample Output:
  83 -83
  -70 69
  81 -81
  -13 13
  51 -51

*/

import java.util.Scanner;
import java.io.File;
import java.io.IOException;;

public class Changpu {
	public static void main(String[] args) throws IOException {
		
		Scanner scan = new Scanner( new File("changpu.dat") );
		
		while(scan.hasNextInt()) {
			
			int n = scan.nextInt();
			
      
      // Complement of a number - flip and subtract 1
			if(n % 2 == 0)
				System.out.println(n + " " + (-1*n - 1) );
			else
				System.out.println(n + " " + -1*n);
			
		}

	}

}
