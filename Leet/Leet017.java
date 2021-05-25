/*
  Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

  A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.





  Example 1:

  Input: digits = "23"
  Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
  Example 2:

  Input: digits = ""
  Output: []
  Example 3:

  Input: digits = "2"
  Output: ["a","b","c"]


  Constraints:

  0 <= digits.length <= 4
  digits[i] is a digit in the range ['2', '9'].


*/

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class TestRunner {
  
  	public static void main(String[] args)
    {
        // Test cases
		    System.out.println( letterCombinations("234") );
      
    }
  

  	public static List<String> letterCombinations(String digits) {

        List<String> combos = new ArrayList<String>();

        // Store letters for each key in String array
        //  ex: keypad[2] will give "abc"
        String[] keypad = {"", "", "abc", "def", "ghi", "jkl", "mno",
                           "pqrs", "tuv", "wxyz"};

        // Easy - done if digits is empty.  Return empty list.
        if( digits.length() < 1 )
          return combos;


        // Get first digit and put it in list   Ex:  digits = "234"    combos --> ["a", "b", "c"]
        int digit = Integer.parseInt( digits.substring(0, 1));
        
        for(int i=0; i<keypad[digit].length(); i++)
            combos.add(keypad[digit].substring(i, i+1));
        
      
        // We are going to look at each other digit and
        // 1) Find out how many letters are with that digit ---> keyLength
        // 2) Add keyLength-1 duplicates of my list to my list   Ex: combos ---> ["a", "b", "c"]
        //                                                           digit = 3 ("def")
        //                                                           Now we have: 
        //                                                           combos --> ["a", "b", "c", "a", "b", "c", "a", "b", "c"]
        //
        // 
        // 3) Add each letter from digit to orignal and copies.
        //                                                          Now we have:
        //                                                          combos --> ["ad", "bd", "cd", "ae", "be", "ce", "af", "bf", "cf"]
        // 4) Rinse. Repeat.
      	for(int i=1; i<digits.length(); i++)
        {
          	digit = Integer.parseInt( digits.substring(i, i+1));
          
          	int keyLength = keypad[digit].length();
          
          	// Duplicate keys
            int len = combos.size();
            for(int j=0; j<keyLength-1; j++)
            {
               for(int k=0; k<len; k++)
               {
                 combos.add(combos.get(k));
               }
            }
          
          	// Add each new letter to the end of each string in combos
          	for(int j=0; j<keyLength; j++)
            {
              
              for(int k=0; k<len; k++)
              {
                combos.set(j*len + k, combos.get(j*len + k) + keypad[digit].charAt(j) );
              }
        
            }
   	     
        }
      	
        
    	return combos;
       
    }

        
   
        
        
    
}
