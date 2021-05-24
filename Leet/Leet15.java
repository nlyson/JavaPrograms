/*
Problem description:
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.
*/

class Leet15 {
  public static void main(String[] args) {
    
    int[] nums = {-1,0,1,2,-1,-4,-2,-3,3,0,4};
    
    System.out.println(threeSum(nums));
    
  }
  
  public static List<List<Integer>> threeSum(int[] nums) {
   
     List<List<Integer>> results = new ArrayList<List<Integer>>();
    
     Arrays.sort(nums);
     
     // Sort the numbers then keep 3 tracking variables: left, mid, right
     // If they add up to 0, great!  Add that triplet to our results.
     // Otherwise, move tracking variables based on whether their sum is > 0 or < 0.
     
       
     for(int left=0; left<nums.length-2; left++)
     {
       
        int mid =left+1;
        int right = nums.length-1;
        while(mid<right){
           int sum = nums[left]+nums[mid]+nums[right];
           if(sum==0)
           {
             List<Integer> temp = new ArrayList<Integer>();
             temp.add(nums[left]);
             temp.add(nums[mid]);
             temp.add(nums[right]);
             
             if(!results.contains(temp))
               results.add(temp);
            
             right--;
           }
           else if(sum > 0)
             right--;
           else if(sum < 0)
             mid++;
     
         }

     }
     
 
    
     return results; 
  }
}
