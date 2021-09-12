package dynamicprogramming;

import java.util.HashMap;

/**
Write a function canSum(targetSum, numbers[]) that tales in a targetSum and an array
of numbers as arguments. The function should return a boolean indicating whether or not
it is possible to generate the targetSum using numbers from the array.

You may use an element of the array as many times as needed.

You may assume that all input numbers are non negative.

Solution: Synamic programming problem, overlapping subproblems
Time complexity with memoization = O(n * m)
Time complexity without memoization = O(n ^ m)
Space complexity = O (m)

m - targetSum
n - number of elements in the array

 * @author rahulbhatt
 *
 */
public class CanSum {

	HashMap<Integer, Boolean> memo = new HashMap<>();
	public static void main(String[] args) {
		CanSum obj = new CanSum();
		System.out.println(obj.canSum(8, new int[] {2, 3, 5}));
		System.out.println(obj.canSum(300, new int[] {2, 3, 5}));
	}
	
	public boolean canSum(int targetSum, int[] numbers) {
		//base case
		if(targetSum < 0) return false;
		if(targetSum == 0) return true;
		
		if(memo.containsKey(targetSum)) return memo.get(targetSum);
		
		for(int i : numbers) {
			if(canSum(targetSum - i, numbers)) {
				memo.put(targetSum, true);
				return true;
			}
		}
		
		memo.put(targetSum, false);
		return false;
	}
}
