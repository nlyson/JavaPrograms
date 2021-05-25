/*

  Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).

  The algorithm for myAtoi(string s) is as follows:

  Read in and ignore any leading whitespace.
  Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
  Read in next the characters until the next non-digit charcter or the end of the input is reached. The rest of the string is ignored.
  Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
  If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
  Return the integer as the final result.
  Note:

  Only the space character ' ' is considered a whitespace character.
  Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.


  Example 1:

  Input: s = "42"
  Output: 42
  Explanation: The underlined characters are what is read in, the caret is the current reader position.
  Step 1: "42" (no characters read because there is no leading whitespace)
           ^
  Step 2: "42" (no characters read because there is neither a '-' nor '+')
           ^
  Step 3: "42" ("42" is read in)
             ^
  The parsed integer is 42.
  Since 42 is in the range [-231, 231 - 1], the final result is 42.
  Example 2:

  Input: s = "   -42"
  Output: -42
  Explanation:
  Step 1: "   -42" (leading whitespace is read and ignored)
              ^
  Step 2: "   -42" ('-' is read, so the result should be negative)
               ^
  Step 3: "   -42" ("42" is read in)
                 ^
  The parsed integer is -42.
  Since -42 is in the range [-231, 231 - 1], the final result is -42.
  Example 3:

  Input: s = "4193 with words"
  Output: 4193
  Explanation:
  Step 1: "4193 with words" (no characters read because there is no leading whitespace)
           ^
  Step 2: "4193 with words" (no characters read because there is neither a '-' nor '+')
           ^
  Step 3: "4193 with words" ("4193" is read in; reading stops because the next character is a non-digit)
               ^
  The parsed integer is 4193.
  Since 4193 is in the range [-231, 231 - 1], the final result is 4193.
  Example 4:

  Input: s = "words and 987"
  Output: 0
  Explanation:
  Step 1: "words and 987" (no characters read because there is no leading whitespace)
           ^
  Step 2: "words and 987" (no characters read because there is neither a '-' nor '+')
           ^
  Step 3: "words and 987" (reading stops immediately because there is a non-digit 'w')
           ^
  The parsed integer is 0 because no digits were read.
  Since 0 is in the range [-231, 231 - 1], the final result is 0.
  Example 5:

  Input: s = "-91283472332"
  Output: -2147483648
  Explanation:
  Step 1: "-91283472332" (no characters read because there is no leading whitespace)
           ^
  Step 2: "-91283472332" ('-' is read, so the result should be negative)
            ^
  Step 3: "-91283472332" ("91283472332" is read in)
                       ^
  The parsed integer is -91283472332.
  Since -91283472332 is less than the lower bound of the range [-231, 231 - 1], the final result is clamped to -231 = -2147483648.


  Constraints:

  0 <= s.length <= 200
  s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'.

*/

class Leet008 {
  
  	public static void main(String[] args)
    {
     
      // Test cases
	    System.out.println( myAtoi("42") );
      System.out.println( myAtoi("-42") );
      System.out.println( myAtoi("        -42") );
      System.out.println( myAtoi("4193 with words") );
      System.out.println( myAtoi("-91283472332") );

    }
  
    public static int myAtoi(String s) {
        
        
        // Get rid of white space
		    s = s.trim();
        
      	// Easy case
        if(s.equals(""))
            return 0;
        
      	// Get rid of cases that don't start with '+', '-', or digit
        if(  !(  s.charAt(0) == '-' || s.charAt(0) == '+' 
                || (s.charAt(0) >= '0' && s.charAt(0) <= '9') )   )
		    return 0;
            
            
      	// Plus sign is optional, so put it there if it's not there
        if(s.charAt(0) != '-' && s.charAt(0) != '+')
          s = "+" + s;
		
      	// Nothing to do if there is only a sign (no digits)
        if(s.length() == 1)
            return 0;
		
      	// Count past any leading zeros
        // Lz will contain the start of the number without those zeros
        int lz = 1;
        while( lz < s.length() && s.charAt(lz) == '0' )
            lz++;
        
        s = s.charAt(0) + s.substring(lz);
		
      
      	// Find the last number - stop counting when you encounter a non digit
		    int endNum = 1;
        if(endNum >= s.length() || s.charAt(endNum) < '0' || s.charAt(endNum) > '9')
			      return 0;
        while( endNum < s.length() && s.charAt(endNum) >= '0' && s.charAt(endNum) <= '9' )
            endNum++;

		    s = s.substring(0, endNum);
        
      
      	// MIN and MAX values are 11 digits including sign
        // Get rid of anything longer.
        if( s.length() > 11 )
        {
            if(s.charAt(0) == '-')
                return Integer.MIN_VALUE;
            else
                return Integer.MAX_VALUE;
        }
		
      
      	// Convert string to a long, compare, and return.
        long answer = Long.parseLong(s);

        if(answer < Integer.MIN_VALUE)
          return Integer.MIN_VALUE;
        if(answer > Integer.MAX_VALUE)
          return Integer.MAX_VALUE;

		    return (int)answer;
        
        
    }

  
    
}
