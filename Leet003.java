/*

  Given a string s, find the length of the longest substring without repeating characters.



  Example 1:

  Input: s = "abcabcbb"
  Output: 3
  Explanation: The answer is "abc", with the length of 3.
  Example 2:

  Input: s = "bbbbb"
  Output: 1
  Explanation: The answer is "b", with the length of 1.
  Example 3:

  Input: s = "pwwkew"
  Output: 3
  Explanation: The answer is "wke", with the length of 3.
  Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
  Example 4:

  Input: s = ""
  Output: 0


  Constraints:

  0 <= s.length <= 5 * 104
  s consists of English letters, digits, symbols and spaces.

*/

import java.util.Map;
import java.util.HashMap;

class Leet003 {
  
  	public static void main(String[] args)
    {
      
      // Test cases
	    System.out.println( lengthOfLongestSubstring("a") );
      System.out.println( lengthOfLongestSubstring("abcde") );
      System.out.println( lengthOfLongestSubstring("aabcd") );
      System.out.println( lengthOfLongestSubstring("aaabc") );
      
    }
  

  
  public static int lengthOfLongestSubstring(String s) {

    // Create a map with
    // 1) Characters already found
    // 2) Where they where found
    Map<Character, Integer> found = new HashMap<Character, Integer>();

    int left = 0;
    int longest = 0;

    // Keep sliding 'right' along
    for(int right=0; right<s.length(); right++)
    {
      // If this character hasn't been found yet, this
      // is a valid one.  See if it's longer than the longest
      if(!found.containsKey(s.charAt(right)))
        longest = Math.max(longest, right-left+1);
      else
      {
        // We already found it, but it's all good.
        // Still valid substring... we found it before we moved the left pointer
        if( found.get(s.charAt(right)) < left)
          longest = Math.max(longest, right-left+1);
        
        // Nope.  Not a valid substring.  Move left pointer up by 1
        else
          left = found.get(s.charAt(right)) + 1;
      }

	  // Add this letter to our already found letters and move along
      found.put(s.charAt(right), right);

    }

    return longest;

    
  
  }

  
    
}
