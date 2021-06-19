package dynamicprogramming;

/*
Given an integer array nums, find the contiguous subarray (containing at least one number) 
which has the largest sum and return its sum.

Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

Example 2:
Input: nums = [1]
Output: 1

 */

public class MaxSubArray {
	
	public static void main(String[] args) {
		MaxSubArray array = new MaxSubArray();
		System.out.println(array.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
	}
	
    public int maxSubArray(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        
        int maxSum = nums[0];
        int maxContSum = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            int sum = maxContSum + nums [i];
            
            if(nums[i] > sum) {
                maxContSum = nums[i];
            } else {
                maxContSum = sum;
            }
            
            if(maxContSum > maxSum) {
                maxSum = maxContSum;
            }
        }
        
        return maxSum;
    }
}
