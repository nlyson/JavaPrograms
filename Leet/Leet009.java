/*
  Given an integer x, return true if x is palindrome integer.

  An integer is a palindrome when it reads the same backward as forward. For example, 121 is palindrome while 123 is not.



  Example 1:

  Input: x = 121
  Output: true
  Example 2:

  Input: x = -121
  Output: false
  Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
  Example 3:

  Input: x = 10
  Output: false
  Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
  Example 4:

  Input: x = -101
  Output: false


  Constraints:

  -231 <= x <= 231 - 1


*/

class Leet009 {
  
   	public static void main(String[] args)
    {
      System.out.println( isPalindrome(343) );
      System.out.println( isPalindrome(0) );
      System.out.println( isPalindrome(-343) );
      System.out.println( isPalindrome(243) );
      
    }
  
    public static boolean isPalindrome(int x) {
        
      	// Negative numbers can't be palis
        if(x < 0)
            return false;
        
        // Here's the idea:
        // Use mod to peel of last digit.  Add it to a total. 
        // Multiply the total by 10 before we add another digit.
        // Keep original number safe so we can compare
        // original and reverse when we are done.

        int temp = x;
        int rev = temp % 10;
        temp /= 10;
      
        while( temp > 0 )
        {
          rev = rev*10 + temp%10;
          temp /= 10;
        } 

        return x == rev;
    }
}
