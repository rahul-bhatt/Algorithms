
package dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * You are given twp positive integers representing the height of a staircase and the maximum number of steos that you
 * can advance up the staircase at a time. Write a function that returns the number of ways in which you can climb 
 * the staircase.
 * 
 * @author rahulbhatt
 *
 */

public class StaircaseTraversal {
	public static void main(String[] args) {
		System.out.println(staircaseTraversal(4, 4));
		System.out.println(staircaseTraversalSlidingWindow(4, 4));
	}
	
	// Dynamic programming solution using memoization
	// Time complexity - O(n * k), n = height, k = maxSteps
	// Space complexity - O(n)
	public static int staircaseTraversal(int height, int maxSteps) {
		if(height == 0) return 0;
		if(maxSteps == 1) return 1;
		
		HashMap<Integer, Integer> memo = new HashMap<>();
		return staircaseTraversalRecursive(height, maxSteps, memo);
	}
	
	public static int staircaseTraversalRecursive(int height, int maxSteps, HashMap<Integer, Integer> memo) {
		if(height == 0) return 1;
		if(height == 1) return 1;
		if(height == 2) return 2;
		
		if(memo.containsKey(height)) {
			return memo.get(height);
		}
		
		int numOfWays = 0;
		for(int i = 1; i <= maxSteps && i <= height; i++) {
			numOfWays += staircaseTraversalRecursive(height - i, maxSteps, memo); 
		}
		
		memo.put(height, numOfWays);
		return numOfWays;
	}
	
	// SLiding window technique
	// Time complexity - O(n)
	// Space complexity - O(n)
	public static int staircaseTraversalSlidingWindow(int height, int maxSteps) {
		int currentNumOfWays = 0;
		
		
		if (height == 1) return 1;
		
		ArrayList<Integer> waysToTop = new ArrayList<>();
		waysToTop.add(1);
		
		for(int currentHeight = 1; currentHeight <= height; currentHeight++) {
			int startWindow = currentHeight - maxSteps - 1;
			int endWindow = currentHeight - 1;
			
			if(startWindow >= 0) {
				currentNumOfWays -= waysToTop.get(startWindow);
			}
			
			currentNumOfWays += waysToTop.get(endWindow);
			waysToTop.add(currentNumOfWays);
		}
		
		return waysToTop.get(height);
	}
}
