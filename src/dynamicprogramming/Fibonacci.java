package dynamicprogramming;

import java.util.HashMap;

/*
 * Fibonacci number at position n.
 * Using memoization.
 * 
 *  Time complexity - O(n)
 *  Space complexity - O(n)
 *  
 *  Time complexity without memoization - O(2 ^ n)
 */

public class Fibonacci {

	HashMap<Integer, Integer> memo = new HashMap<>();
	
	public int fib(int n) {
		if(n == 2) return 1;
		if(n < 2) return 0;
		
		if(memo.containsKey(n)) return memo.get(n);
		
		memo.put(n, fib(n - 1) + fib(n - 2));
		return memo.get(n);
	}
	
	public static void main(String[] args) {
		Fibonacci fibo = new Fibonacci();
		
		System.out.println(fibo.fib(4));
	}
}
