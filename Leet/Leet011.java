/*
Description: 

Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). 
n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). 

Find two lines, which, together with the x-axis forms a container, such that the container contains 
the most water.

Notice that you may not slant the container.
*/


import java.util.Map;
import java.util.HashMap;

import java.lang.Math;

class Leet011 {
  
    public static void main(String[] args)
    {
        // Test cases
        int[] nums1 = {1,8,6,2,5,4,8,3,7};
        int[] nums2 = {1,1};
        int[] nums3 = {4,3,2,1,4};
        int[] nums4 = {1,2,1};

        System.out.println(maxArea(nums1));
        System.out.println(maxArea(nums2));
        System.out.println(maxArea(nums3));
        System.out.println(maxArea(nums4));
    }
  
    public static int maxArea(int[] height) {
        
        // I used a "sliding window" approach.  
        // Start of left and right at opposite ends of the array.
        
        int len = height.length;
        int maxArea = Math.min(height[0], height[len-1]);
        int left = 0;
        int right = len-1;
        
        // Each go around, the area is the smaller side times the distance.  (distance between indices)
        // Increase left if right is the bigger side.
        // Increase right if left is the bigger side.
        // Stop when left and right become the same.
        
        while( left < right )
        {
            int area = Math.min(height[left], height[right])*(right-left);
            
            if(area > maxArea)
            {
                maxArea = area;
                
            }
            
            if(height[right] > height[left])
                left++;
            else
                right--;
            
            
        }
        
        return maxArea;
     
    }
}
