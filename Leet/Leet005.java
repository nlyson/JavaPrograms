/*
  Given a string s, return the longest palindromic substring in s.



  Example 1:

  Input: s = "babad"
  Output: "bab"
  Note: "aba" is also a valid answer.
  Example 2:

  Input: s = "cbbd"
  Output: "bb"
  Example 3:

  Input: s = "a"
  Output: "a"
  Example 4:

  Input: s = "ac"
  Output: "a"


  Constraints:

  1 <= s.length <= 1000
  s consist of only digits and English letters (lower-case and/or upper-case),

*/

class Leet005 {
  
    public static void main(String[] args)
    {
        // Test cases
       	System.out.println( longestPalindrome("abbba") );
        System.out.println( longestPalindrome("abba") );
        System.out.println( longestPalindrome("aba") );
        System.out.println( longestPalindrome("bb") );
        System.out.println( longestPalindrome("a") );
    }
  
    public static String longestPalindrome(String s) 
    {
      
      String longest = s.substring(0, 1);
      int len = s.length();
      int maxLen = 1;

      // Go through each character.  Try to expand out.  Stop when 
      //                  1) It stops being a pali or 2) You are about to go out of bounds
      // ****Note: I used 2 loops - one to check for even palis and one to check for odd palis
      //            

      // Check even palis
      for(int i=0; i<s.length()-1; i++)
      {

        // Check the next character - this is not a pali to begin with
        if( s.charAt(i) != s.charAt(i+1) )
          continue;

        int count = 2;


        int left = i-1;
        int right = i+2;

        while(left >= 0 && right < len && s.charAt(left) == s.charAt(right) )
        {
          count+=2;
          left--;
          right++;
        }

        if(count > maxLen)
        {
          maxLen = count;
          longest = s.substring(left+1, right);;
        }
      }


      // Check odd palis
      for(int i=1; i<s.length()-1; i++)
      {
        int count = 1;
        int left = i-1;
        int right = i+1;

        while(left >= 0 && right < len && s.charAt(left) == s.charAt(right) )
        {
          count += 2;
          left--;
          right++;
        }

        if(count > maxLen)
        {
          maxLen = count;
          longest = s.substring(left+1, right);
        }
      }




      return longest;
    }
}
