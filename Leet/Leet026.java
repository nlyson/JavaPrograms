/*

  Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns the new length.

  Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

  Clarification:

  Confused why the returned value is an integer but your answer is an array?

  Note that the input array is passed in by reference, which means a modification to the input array will be known to the caller as well.

  Internally you can think of this:

  // nums is passed in by reference. (i.e., without making a copy)
  int len = removeDuplicates(nums);

  // any modification to nums in your function would be known by the caller.
  // using the length returned by your function, it prints the first len elements.
  for (int i = 0; i < len; i++) {
      print(nums[i]);
  }


  Example 1:

  Input: nums = [1,1,2]
  Output: 2, nums = [1,2]
  Explanation: Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the returned length.
  Example 2:

  Input: nums = [0,0,1,1,1,2,2,3,3,4]
  Output: 5, nums = [0,1,2,3,4]
  Explanation: Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively. It doesn't matter what values are set beyond the returned length.


  Constraints:

  0 <= nums.length <= 3 * 104
  -104 <= nums[i] <= 104
  nums is sorted in ascending order.

*/

import java.util.Arrays;


public class Leet026 {
  
  	public static void main(String[] args)
    {
     	  // Test cases
     	  int[] nums1 = {1, 2, 2, 2, 3, 3, 4, 4, 5, 5, 5};
      	int[] nums2 = {1,2, 3, 4, 5, 6, 7};
      	
      
      	System.out.println( removeDuplicates(nums1) );
      	System.out.println( removeDuplicates(nums2) );
      
      	System.out.println( Arrays.toString(nums1) );
      	System.out.println( Arrays.toString(nums2) );
      
    }
  
  	public static int removeDuplicates(int[] nums)
    {
     
        // Keep track of where the next non-duplicate should go
        int next = 1;

        for(int i=1; i<nums.length; i++)
        {
          // Skip past duplicates and keep track of number skipped in offset
          while(i < nums.length && nums[i] == nums[i-1])
          {
            i++;
          }

          // Exiting my while loop means I am either:
          // a) at the end of the list
          // b) at the start of a new number that I haven't seen 
          if(i < nums.length )
            nums[next++] = nums[i];

        }

        return next;
    }
  
}
