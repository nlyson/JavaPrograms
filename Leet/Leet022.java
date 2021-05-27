/*

  Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.



  Example 1:

  Input: n = 3
  Output: ["((()))","(()())","(())()","()(())","()()()"]
  Example 2:

  Input: n = 1
  Output: ["()"]


  Constraints:

  1 <= n <= 8

*/

import java.util.List;
import java.util.ArrayList;

public class TestRunner {
  
  
  	public static void main(String[] args)
    {
  		// Test cases
      	System.out.println( generateParenthesis(3) );
        System.out.println( generateParenthesis(4) );

    }
  
    public static List<String> generateParenthesis(int n) {
       
    	  List<String> results = new ArrayList<String>();
      
      	genHelper(results, 0, n, "");
     
      	return results;
       
    }
  
    // Recurively add these guys --> "(" and ")"
    // Example:   3
    //                                                                      (
    //                                                     /                                 \
    //                                                   ()                                   ((
    //                                                  /                                /           \
    //                                                 ()(                             (()             (((
    //                                               /     \                           /  \             \
    //                                             ()()    ()((                     (())  (()(           ((()
    //                                              /        \                        |      |             \
    //                                           ()()(       ()(()                  (())(   (()()           ((())
    //                                            /           \                       |        |                \
    //                                         ()()()         ()(())                (())()    (()())           ((()))

  	public static void genHelper(List<String> list, int start, int end, String s)
    {
      if(start == 0 && end == 0)
        list.add(s);
      else
      {
        if(start > 0)
          genHelper(list, start-1, end, s + ")");
        if(end > 0)
          genHelper(list, start+1, end-1, s + "(");
      }
   	
    }
  
  
  
 
}


