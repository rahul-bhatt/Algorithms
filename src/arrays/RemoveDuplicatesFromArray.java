package arrays;

/**
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place 
 * such that each unique element appears only once. The relative order of the elements should be kept the same.
 * 
 * Return k after placing the final result in the first k slots of nums.
 * Do not allocate extra space for another array. You must do this by 
 * modifying the input array in-place with O(1) extra memory.
 * 
 * @author rahulbhatt
 *
 */
public class RemoveDuplicatesFromArray {

	public static void main(String[] args) {
		int[] nums = new int[] {0,1};
		System.out.println(removeDuplicates(nums));
	}

	//Time: O(n), Space: O(1)
	public static int removeDuplicates(int[] nums) {
		int i = 0;
	    for (int n : nums)
	        if (i == 0 || n > nums[i-1])
	            nums[i++] = n;
	    return i;
	}
}
