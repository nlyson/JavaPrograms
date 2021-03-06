/*

Program Name: Arun.java Test Input File: None
In a dream of going to the State UIL programming contest one afternoon as he was napping, Arun came up with the following interesting pattern. Can you replicate it?
Input: None
Output: Write a program that displays exactly the output you see below.
Exact Output Expected:
SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS
STATEUILCOMPUTERSCIENCEPROGRAMMINGCONTEST
TSETNOCGNIMMARGORPECNEICSRETUPMOCLIUETATS
TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT
STATEUILCOMPUTERSCIENCEPROGRAMMINGCONTEST
TSETNOCGNIMMARGORPECNEICSRETUPMOCLIUETATS
IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII
STATEUILCOMPUTERSCIENCEPROGRAMMINGCONTEST
TSETNOCGNIMMARGORPECNEICSRETUPMOCLIUETATS
OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
STATEUILCOMPUTERSCIENCEPROGRAMMINGCONTEST
TSETNOCGNIMMARGORPECNEICSRETUPMOCLIUETATS
UUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU
STATEUILCOMPUTERSCIENCEPROGRAMMINGCONTEST
TSETNOCGNIMMARGORPECNEICSRETUPMOCLIUETATS
RRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR
STATEUILCOMPUTERSCIENCEPROGRAMMINGCONTEST
TSETNOCGNIMMARGORPECNEICSRETUPMOCLIUETATS
IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII
STATEUILCOMPUTERSCIENCEPROGRAMMINGCONTEST
TSETNOCGNIMMARGORPECNEICSRETUPMOCLIUETATS
CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC
STATEUILCOMPUTERSCIENCEPROGRAMMINGCONTEST
TSETNOCGNIMMARGORPECNEICSRETUPMOCLIUETATS
RRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR
STATEUILCOMPUTERSCIENCEPROGRAMMINGCONTEST
TSETNOCGNIMMARGORPECNEICSRETUPMOCLIUETATS
RRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR
STATEUILCOMPUTERSCIENCEPROGRAMMINGCONTEST
TSETNOCGNIMMARGORPECNEICSRETUPMOCLIUETATS
MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
STATEUILCOMPUTERSCIENCEPROGRAMMINGCONTEST
TSETNOCGNIMMARGORPECNEICSRETUPMOCLIUETATS
GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG
STATEUILCOMPUTERSCIENCEPROGRAMMINGCONTEST
TSETNOCGNIMMARGORPECNEICSRETUPMOCLIUETATS
NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN
STATEUILCOMPUTERSCIENCEPROGRAMMINGCONTEST
TSETNOCGNIMMARGORPECNEICSRETUPMOCLIUETATS
SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS
STATEUILCOMPUTERSCIENCEPROGRAMMINGCONTEST
*/

public class Arun {
  
  	public static void main(String[] args)
    {
    	String word = "STATEUILCOMPUTERSCIENCEPROGRAMMINGCONTEST";
      
      
      	// Nothing really tricky about this one.  Just make sure we don't 
        // print the word in reverse on the last go around of the pattern.
        //
        // Pattern: Letter index increases by 3, then word forwards, then backwards
   		for(int i=0; i<word.length(); i+=3)
        {
          for(int j=0; j<word.length(); j++)
            System.out.print(word.charAt(i));
          System.out.println();
          
          for(int j=0; j<word.length(); j++)
            System.out.print(word.charAt(j));
          System.out.println();
          
          if(i+3 < word.length())
          {
            for(int j=word.length()-1; j>=0; j--)
              System.out.print(word.charAt(j));
            System.out.println();
          }
          
          
          
        }
      
      
    }
 
}
