/*

  The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

  P   A   H   N
  A P L S I I G
  Y   I   R
  And then read line by line: "PAHNAPLSIIGYIR"

  Write the code that will take a string and make this conversion given a number of rows:

  string convert(string s, int numRows);


  Example 1:

  Input: s = "PAYPALISHIRING", numRows = 3
  Output: "PAHNAPLSIIGYIR"
  Example 2:

  Input: s = "PAYPALISHIRING", numRows = 4
  Output: "PINALSIGYAHRPI"
  Explanation:
  P     I    N
  A   L S  I G
  Y A   H R
  P     I
  Example 3:

  Input: s = "A", numRows = 1
  Output: "A"


  Constraints:

  1 <= s.length <= 1000
  s consists of English letters (lower-case and upper-case), ',' and '.'.
  1 <= numRows <= 1000

*/

class Leet006 {
    public String convert(String s, int numRows) {
        
        
        if(numRows < 2)
			    return s;
		
        int len = s.length();
        
        String result = "";
      
        // If there are only 2 rows, even letters go first.  Odds go last.
        //  Ex: "abcdef"  ----->  a c e b d f
        if(numRows == 2)
		    {
          for(int i=0; i<len; i+=2)
            result += "" + s.charAt(i);
          for(int i=1; i<len; i+=2)
            result += "" + s.charAt(i);

          return result;
		    }
		
        // Used my Algebra skills and some tinkering to figure out when to add in the 
        // diagonals.
        // I notice that: 
        //                    1) Diagonal length --->  2 less than row length
        //                    2) Letters not in diagaonals are 2*numRows -2 apart
        //
        // Ex:  HELLOWORLD  4 ROWS                     HELLOWORLD 3 ROWS
        //        
        //      H      O                                H    O    L
        //      E    W R                                E  L W  R D
        //      L  O   L                                L    O
        //      L      D
        for(int j=0; j<numRows; j++)
        {

          for(int i=j; i<len; i+=(2*numRows-2))
          {

            result += "" + s.charAt(i);

            if( j > 0 && j<numRows-1 && i + 2*numRows - 4 - 2*(j-1) <len )
            {
              result += "" + s.charAt(i + 2*numRows - 4 - 2*(j-1));
            }
          }
        }
		
		
	return result;	
        
        
    }
}
