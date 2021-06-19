package dynamicprogramming;

/*
 Given an integer array nums, handle multiple queries of the following type:

Calculate the sum of the elements of nums between indices left and right inclusive 
where left <= right.
Implement the NumArray class:

NumArray(int[] nums) Initializes the object with the integer array nums.
int sumRange(int left, int right) Returns the sum of the elements of nums 
between indices left and right inclusive 
(i.e. nums[left] + nums[left + 1] + ... + nums[right]).
 */

public class RangeSumQuery {
    int[] nums;
    
    // O(n) time to build the array
    public RangeSumQuery(int[] nums) {
        for(int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        
        this.nums = nums.clone();
    }
    
    // O(1) for each lookup (calculating range sum)
    public int sumRange(int left, int right) {
        if(left == 0) return nums[right];
        
        return nums[right] - nums[left - 1];
    }
    
    public static void main(String[] args) {
    		RangeSumQuery rangeSumQuery = new RangeSumQuery(new int[] {1,2,3,4,6,5,7,8});
    		
    		System.out.println("sum in range[3-5]: " + rangeSumQuery.sumRange(3, 5));
    }
}
