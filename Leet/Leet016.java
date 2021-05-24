/*
  Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. 
  Return the sum of the three integers. You may assume that each input would have exactly one solution.



  Example 1:

  Input: nums = [-1,2,1,-4], target = 1
  Output: 2
  Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).


  Constraints:

  3 <= nums.length <= 10^3
  -10^3 <= nums[i] <= 10^3
  -10^4 <= target <= 10^4


*/


import java.util.Arrays;

class TestRunner {
  
  	public static void main(String[] args)
    {
      int[] nums1 = {-1,2,1,-4};
      int[] nums2 = {1, 2};
      int[] nums3 = {8, 0, 2, 1, 11, 113, 2};
      
      System.out.println(threeSumClosest(nums1, 1));
      System.out.println(threeSumClosest(nums1, 8));
      System.out.println(threeSumClosest(nums2, 1));
      System.out.println(threeSumClosest(nums2, 8));
      System.out.println(threeSumClosest(nums3, 1));
      System.out.println(threeSumClosest(nums3, 8));
            

      
    }
  
    public static int threeSumClosest(int[] nums, int target) {
      
     if(nums.length < 3)
         return 0;
        
     Arrays.sort(nums);
      
     int closest = nums[0] + nums[1] + nums[2];
     

      // Problem becomes MUCH easier after array is sorted.
      // Start off left and right oppisite ends.
      // Move left, right, and id depending on the sum.
    
     for(int left=0; left<nums.length-2; left++)
     {

        int mid =left+1;
        int right = nums.length-1;
       
        
        while(mid<right){
           int sum = nums[left]+nums[mid]+nums[right];
           
           int dist = Math.abs(sum - target);
           
           if(dist < Math.abs(closest - target))
             closest = sum;
          
           if(sum==target)
           {
             return sum;
           }
           else if(sum > target)
             right--;
           else if(sum < target)
             mid++;
     
         }

     }
     
 
    
     return closest; 
    }
}
