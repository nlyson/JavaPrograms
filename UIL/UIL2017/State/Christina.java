/*

  Program Name: Christina.java 
  Test Input File: christina.dat 
  
  In a recent computer science class, Christina has learned about string manipulation, 
  and wants to use the names of her friends to practice her newly learned techniques. She decides to list all of her friends in a datafile, input them, and then 
  use a special coding system to combine the names in certain situations to create some unique and interesting name combinations. 

  For example, she'll use the letter 'U' to indicate uppercasing the entire name, 'L' to lowercase it, and 'R' to keep the name in its regular original format. 
  Furthermore, she decides to reverse the order of the letters in the name in a similar fashion by using 'u', 'l', and 'r' which still performs the uppercase, 
  lowercase, or keep regular casing, but reverses the order of the letters in the entire name. She puts all of the names into a list, and then indicates which 
  name to use with a 01 indicating the first name in the list, and 12 (if there are 12 names) to indicate the last name. In the sample data below, her name is 
  in position 3 of the list of names, and so a code string of "03U" will produce her name in all uppercase letters, resulting in CHRISTINA. She then tries several 
  codes, like "03u12R05L", which produces this result: ANITSIRHCZacharyeric The first portion of the code, "03u", causes her name, "Christina", to be shown 
  in all uppercase letters, in reverse letter order. The next part, "12R", takes the 12th name in the list, "Zachary", and keeps it in regular initial case form, 
  normal letter order. Finally, "05L" takes "Eric", and lowercases it, in normal letter order. All codes will consist of three characters, as shown in the 
  examples here. Input: An initial value N, followed by N names (1 < N < 100), all spelled with initial uppercase letters, followed by all lowercased letters. 
  Following all of the names are several code strings which will produce interesting name combinations according to the rules stipulated above. 

  Output: The resulting name combination string produced by each of the code strings at the end of the data file. 

  Sample Input: 
  12 
  Arun 
  Changpu 
  Christina 
  Dai 
  Eric 
  Guang 
  Keerthi 
  Matthew 
  Rohan 
  Sasha 
  Yulia 
  Zachary 
  03u12R05L
  01u05L06R 
  12R07U 
  10l03R09u 
  08R09u12l03u11l 
  12L05U 

  Sample Output: 
  ANITSIRHCZacharyeric 
  NURAericGuang
  ZacharyKEERTHI 
  ahsasChristinaNAHOR 
  MatthewNAHORyrahcazANITSIRHCailuy 
  zacharyERIC

*/
import java.util.Scanner;
import java.io.File;
import java.io.IOException;;

public class UILRunner {
	public static void main(String[] args) throws IOException {
		
		Scanner scan = new Scanner( new File("christina.dat") );
		
		String[] names = new String[scan.nextInt()];
		
		scan.nextLine();
		
		for(int i=0; i<names.length; i++)
			names[i] = scan.nextLine();
		
	
		while( scan.hasNextLine() )
		{
			String inputLine = scan.nextLine();
			
      
      
      // Take 3 character chunks out of inputLine
      // Use the first to letters to figure out the name
      // THe last letter tells us what to do with it.
			while(inputLine.length() > 0)
			{
			
				String name = names[Integer.parseInt(inputLine.substring(0, 2)) - 1];
				
				char code = inputLine.charAt(2);
				if(code == 'r' || code == 'u' || code == 'l')
					name = reverse(name);
				
				if(code == 'u' || code == 'U')
					name = name.toUpperCase();
				
				if(code == 'l' || code == 'L')
					name = name.toLowerCase();
				
				System.out.print(name);
				
				inputLine = inputLine.substring(3);
			
			
			}
			System.out.println();
			
		}
		
		

	}
	
	public static String reverse(String s)
	{
		String reverse = "";
		
		for(int i=0; i<s.length(); i++)
			reverse = s.charAt(i) + reverse;
		
		return reverse;
	}

}
