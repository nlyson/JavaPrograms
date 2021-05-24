import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

class Leet1 {

public static void main(String[] args)
{
  // Test cases
  System.out.println( Arrays.toString(twoSum( new int[]{2,7,11,15}, 9 ) ) );
  System.out.println( Arrays.toString(twoSum( new int[]{3, 2, 4}, 6 ) ) );
  System.out.println( Arrays.toString(twoSum( new int[]{3, 3}, 6 ) ) );
  }


  public static int[] twoSum(int[] nums, int target) {


    // Map elements to indices
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    for(int i=0;i<nums.length; i++)
      map.put(nums[i], i);


    // Look at each number - try to find the complement
    // If it's 1) in the list and 2) not the same as this one
    // Bam! We found it!
    for(int i=0; i<nums.length; i++)
      if( map.containsKey( target - nums[i] ) && map.get(target - nums[i]) != i )
        return new int[]{i, map.get(target - nums[i])}; 


    // Didn't find it:(
    return null;
		
  }
  
  
}
