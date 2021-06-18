package dynamicprogramming;

/*
 * Alice and Bob take turns playing a game, with Alice starting first.

	Initially, there is a number n on the chalkboard. On each player's turn, 
	that player makes a move consisting of:

	Choosing any x with 0 < x < n and n % x == 0.
	Replacing the number n on the chalkboard with n - x.
	Also, if a player cannot make a move, they lose the game.

	Return true if and only if Alice wins the game, assuming both players play optimally.

 

	Example 1:
	Input: n = 2
	Output: true
	Explanation: Alice chooses 1, and Bob has no more moves.

	Example 2:
	Input: n = 3
	Output: false
	Explanation: Alice chooses 1, Bob chooses 1, and Alice has no more moves.
 */

/*
 	We need to create a tree of all possible moves a player can take.
 	What we will notice is that Alice would win if Bob gets a "1" after which
 	there are no moves to play.
 	
 	 So our base case is if n == 1, return false.
 	 
 	 For the recurrence relationship, we can define a function:
 	 
 	 canWin(n) = !canWin(n - x), 0 < x < n and n % x == 0
 	 
 	 The time complexity of this solution would be O(2 ^ n) which is polynomial.
 	 The reason being we are solving sub-problems over and over again.
 	 
 	 In order to reduce the time complexity we can use another dynamic programming
 	 technique called Memoization, which means caching the result of sub problems so
 	 that we don't need to calculate it again.
 	 
 	 Using Memoization, time complexity would reduce to O(n ^ 2), which is exponential
 	 and better than a polynomial function.
 	 
 	 Time complexity: N * N/2 = O(N ^ 2).
 	 Space complexity: O(N).
 */

/*
 	There is an alternative solution as well. If the number is even return true 
 	else return false. There is a mathematical proof for that.
 */

public class DivisorGame {

		public static void main(String[] args) {
			DivisorGame game = new DivisorGame();
			int n = 2;
			Boolean[] cache = new Boolean[n + 1];
			
			System.out.println(game.canWin(n, cache));
		}
		
		public boolean canWin(int n, Boolean[] cache) {
			//base case
			if(n <= 1) {
				return false;
			}
			
			// Memoization
			if(cache[n] != null) {
				return cache[n];
			}
			
			// Backtracking, Recursion
			for(int x = 1; x <= n/2; x++) { // if x is a factor of n, it can not be greater than n/2
				if(n % x == 0) {
					if(!canWin(n - x, cache)) {
						cache[n] = true;
						return true;
					}
				}
			}
			
			cache[n] = false;
			return false;
		}
}
