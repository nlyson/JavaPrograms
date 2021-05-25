/*

  Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

  Assume the environment does not allow you to store 64-bit integers (signed or unsigned).



  Example 1:

  Input: x = 123
  Output: 321
  Example 2:

  Input: x = -123
  Output: -321
  Example 3:

  Input: x = 120
  Output: 21
  Example 4:

  Input: x = 0
  Output: 0


  Constraints:

  -231 <= x <= 231 - 1

*/

import java.util.Map;
import java.util.HashMap;

class Leet007 {
  
  	public static void main(String[] args)
    {
     
      // Test cases
	    System.out.println( reverse(1234) );
      System.out.println( reverse(Integer.MAX_VALUE));
      System.out.println( reverse(0) );
      System.out.println( reverse(Integer.MIN_VALUE));
      System.out.println( reverse(-1234) );
    
      
    }
  
    public static int reverse(int x) {
        
      	// Nope! This number reversed is too big!
        // I will get an overflow error when I try to make this
        // positive later.
        if(x == Integer.MIN_VALUE)
            return 0;
        
        boolean isPos = x >= 0;
        
        if(!isPos)
            x *= -1;

        long result = 0;
        
        

        result += x % 10;
        x /= 10;

      	// Peel of digits one at a time
        // Multiply result by 10 before adding on next digit
        // and you have your number reversed!
        while(x > 0 )
        {
          result = 10*result + x % 10;
          x /= 10;

        }

        
        if( isPos && result <= Integer.MAX_VALUE )
            return (int)result;
        else if( !isPos && -1*result >= Integer.MIN_VALUE  )
            return -1*(int)result;
        
        return 0;

    }

  
    
}
