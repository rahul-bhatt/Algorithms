package dynamicprogramming;

import java.util.HashMap;

/*
 * You are a traveler on a 2D grid. 
 * You begin in the top-left corner and your goal is to travel to the bottom-right corner. 
 * You may move down or right.
 * 
 * In how many ways can you travel to the goal on a grid with dimension m * n?
 *  
 * Time complexity with memoization - O(m * n)
 * Space complexity - O(m + n)
 * 
 * Time complexity without memoization - O(2 ^ (m + n))
 */

public class GridTraveler {
	
	HashMap<String, Integer> memo = new HashMap<>();
	
	public int gridTraveler(int m, int n) {
		
		//base case
		if(m == 1 && n == 1) return 1;
		if(m == 0 || n == 0) return 0;
		
		String key = m + "," + n;
		if(memo.containsKey(key)) return memo.get(key);
		
		String reverseKey = n + "," + m;
		if(memo.containsKey(reverseKey)) return memo.get(reverseKey);
		
		memo.put(key, gridTraveler(m - 1, n) + gridTraveler(m, n - 1));
		return memo.get(key);
	}
	
	public static void main(String[] args) {
		GridTraveler traveler = new GridTraveler();
		System.out.println(traveler.gridTraveler(2,  3));
		System.out.println(traveler.gridTraveler(3,  3));
	}
}
