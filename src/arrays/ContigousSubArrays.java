package arrays;

import java.util.Stack;

/**
 * 
 * You are given an array a of N integers. For each index i, you are required to determine the number of contiguous
	subarrays that fulfills the following conditions:
	The value at index i must be the maximum element in the contiguous subarrays, and
	These contiguous subarrays must either start from or end on index i.

	Signature
	int[] countSubarrays(int[] arr)

	Input
	Array a is a non-empty list of unique integers that range between 1 to 1,000,000,000

	Size N is between 1 and 1,000,000

	Output
	An array where each index i contains an integer denoting the maximum number of contiguous subarrays of a[i]

	Example:
	a = [3, 4, 1, 6, 2]
	output = [1, 3, 1, 5, 1]

	Explanation:
	For index 0 - [3] is the only contiguous subarray that starts (or ends) with 3, and the maximum value in this subarray is 3.
	For index 1 - [4], [3, 4], [4, 1]
	For index 2 - [1]
	For index 3 - [6], [6, 2], [1, 6], [4, 1, 6], [3, 4, 1, 6]
	For index 4 - [2]
	So, the answer for the above input is [1, 3, 1, 5, 1]
	
 * @author rahulbhatt
 *
 */

public class ContigousSubArrays {

	public static void main(String[] args) {
		int[] result = countSubarrays(new int[]{3, 4, 1, 6, 2});
		printResult(result);
	}

	// Time - O(n) | Space - O(1)
	public static int[] countSubarrays(int[] arr) {	
		Stack<Integer> stack = new Stack<Integer>();
		int[] ways = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++) {
			while(!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
				int idx = stack.pop();
				ways[idx] = i - idx;
			}
			
			stack.push(i);
		}
		
		while (!stack.isEmpty()) {
			int idx = stack.pop();
		    ways[idx] = arr.length - idx;
		}
		 
		for(int i = arr.length - 1; i >= 0; i--) {
			ways[i]--;
			while(!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
				int idx = stack.pop();
				ways[idx] += idx - i;
			}
			
			stack.push(i);
		}
		
		while (!stack.isEmpty()) {
			int idx = stack.pop();
		    ways[idx] += idx + 1;
		}
		
		return ways;
	}
	
	public static void printResult(int[] arr) {
		System.out.print("[");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.print("]");
	}
}
