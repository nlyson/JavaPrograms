/*

  Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

  An input string is valid if:

  Open brackets must be closed by the same type of brackets.
  Open brackets must be closed in the correct order.

*/

import java.util.Stack;

public class Leet020 {
  
  	public static void main(String[] args)
    {
      
        // Test cases
  		  System.out.println( isValid("(([]))"));
      	System.out.println( isValid("[](){}"));
        System.out.println( isValid("][(){}"));
      	System.out.println( isValid("[](){"));
      	System.out.println( isValid("") );
      	System.out.println( isValid("([)]"));
      	System.out.println( isValid("(("));
     	
    }
  
  	public static boolean isValid(String s) {
      
        // Can't happen if there are an odd # of sybmols
      	if( s.length() % 2 == 1 )
          return false;
        
        // We are going to push open symbols onto a stack
        // When I come across a close symbol, I am going to pop one off the stack and compare
        // If they don't match, it's not balanced.
		    Stack<Character> stack = new Stack<Character>();

        for(int i=0; i<s.length(); i++)
        {
          if(s.charAt(i) == '[' || s.charAt(i) == '(' || s.charAt(i) == '{')
          	stack.push(s.charAt(i));
          else if( stack.empty() )
            return false;
          else
          {
            if(s.charAt(i) == ')' && stack.pop() != '(')
              return false;
            else if(s.charAt(i) == ']' && stack.pop() != '[')
              return false;
            else if(s.charAt(i) == '}' && stack.pop() != '{')
              return false;
          }
        }
      
        // No symbols left over, good!!!  It's balanced.
      	if(stack.empty())
        	return true;
        
      
        // Uh-oh.  We have some symbols left in the stack.  Not balanced.
      	return false;
        
    }
 
}
