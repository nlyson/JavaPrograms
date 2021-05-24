import java.util.Map;
import java.util.HashMap;

class Leet012 {
  
  	public static void main(String[] args)
    {
      // Test cases
      System.out.println(intToRoman(3));
      System.out.println(intToRoman(4));
      System.out.println(intToRoman(9));
      System.out.println(intToRoman(58));
      
    }
  
  
    public static String intToRoman(int num) {
        
      // Get out if it's not a valid number.
      if(num < 1 || num > 3999)
          return "";
    
      int[] nums ={1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
      
      
      // Create mapping of possible conversions
      Map<Integer, String> map  = new HashMap<Integer, String>() {{
          put(1000, "M");
          put(900, "CM");
          put(500, "D");
          put(400, "CD");
          put(100, "C");
          put(90, "XC");
          put(50, "L");
          put(40, "XL");
          put(10, "X");
          put(9, "IX");
          put(5, "V");
          put(4, "IV");
          put(1, "I");

      }};
      
      // Keep subtracting off until there is nothing left.
      // Put conversion in result string each time something is subtracted out.
      int i=0;
      String result = "";
      while(num > 0)
      {
        if(num >= nums[i])
        {
          result += map.get(nums[i]);
          num = num - nums[i];
          
        }
        else
          i++;
        
        
      }
      
      return result;
    }
}
