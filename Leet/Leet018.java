/*
	Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

	0 <= a, b, c, d < n
	a, b, c, and d are distinct.
	nums[a] + nums[b] + nums[c] + nums[d] == target
	You may return the answer in any order.



	Example 1:

	Input: nums = [1,0,-1,0,-2,2], target = 0
	Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
	Example 2:

	Input: nums = [2,2,2,2,2], target = 8
	Output: [[2,2,2,2]]


	Constraints:

	1 <= nums.length <= 200
	-109 <= nums[i] <= 109
	-109 <= target <= 109
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Leet018 {

	public static void main(String[] args)
	{
		int[] nums1 = {1,0,-1,0,-2,2};
		int[] nums2 = {2,2,2,2,2};

		// Test cases
		System.out.println( fourSum(nums1, 0) );
		System.out.println( fourSum(nums2, 8) );

	}

	// ***Similar to problem 15.  I just added a nested for loop for the left pivot.

	public static List<List<Integer>> fourSum(int[] nums, int target) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		Arrays.sort(nums);

		// Return empty list if nums length is less than 4
		if(nums.length < 4)
			return result;

		// I am using 4 pivots: left, midLeft, midRight, and right
		// I move left pivots with a nested for loop
		// Use a while loop for right pivots.
		// Compare sum to target to figure out which pivot to move.
		for(int left=0; left<nums.length-3; left++)
		{
			for(int midLeft=left+1; midLeft<nums.length-2; midLeft++)
			{
				int midRight = midLeft + 1;
				int right = nums.length - 1;

				while(midRight < right)
				{
					int sum = nums[left] + nums[midLeft] + nums[midRight] + nums[right];
					if( sum == target )
					{
						List<Integer> temp = new ArrayList<Integer>();
						temp.add(nums[left]);
						temp.add(nums[midLeft]);
						temp.add(nums[midRight]);
						temp.add(nums[right]);
						if(!result.contains(temp))
							result.add(temp);
						right--;
					}

					else if(sum < target)
						midRight++;
					else
						right--;
				}        
			}      	
		}

		return result;

	}



}
