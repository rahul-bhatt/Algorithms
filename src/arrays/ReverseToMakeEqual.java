package arrays;

/**
 * 
	Given two arrays A and B of length N, determine if there is a way to make A equal to B by 
	reversing any subarrays from array B any number of times.

	Signature
	bool areTheyEqual(int[] arr_a, int[] arr_b)
	
	Input
	All integers in array are in the range [0, 1,000,000,000].

	Output
	Return true if B can be made equal to A, return false otherwise.

	Example
	A = [1, 2, 3, 4]
	B = [1, 4, 3, 2]

	output = true

	After reversing the subarray of B from indices 1 to 3, array B will equal array A.
 * 
 * 
 * @author rahulbhatt
 *
 */

public class ReverseToMakeEqual {
	
	public static void main(String[] args) {
		System.out.println(areTheyEqual(new int[] {1,2,3,4}, new int[] {1,4,3,2}));
	}
	
	// Time - O(n) | Space - O(1)
	public static boolean areTheyEqual(int[] array_a, int[] array_b) {
		int j = 0;
		for(int i = 0; i < array_a.length; i++) {
			if(array_a[i] != array_b[i]) {
				break;
			}
			j++;
		}

		if(j == array_a.length - 1) {
			return true;
		}

		int i = array_a.length - 1;
		while (j < array_a.length) {
			if(array_a[j++] != array_b[i--]) {
				return false;
			}
		}

		return true;
	}
}
