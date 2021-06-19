package dynamicprogramming;

/*
You are given an integer array cost where cost[i] is the cost of ith step on a staircase. 
Once you pay the cost, you can either climb one or two steps.

You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor. 

Example 1:

Input: cost = [10,15,20]
Output: 15
Explanation: Cheapest is: start on cost[1], pay that cost, and go to the top. 

Example 2:

Input: cost = [1,100,1,1,1,100,1,1,100,1]
Output: 6
Explanation: Cheapest is: start on cost[0], and only step on 1s, skipping cost[3].
 */

//Time complexity (Recursive solution) - O(n)
//Space complexity (Recursive solution) - O(n)

//Time complexity (Bottom up iterative solution) - O(n)
//Space complexity (Bottom up iterative solution) - O(1)

public class MinCostClimbingStairs {

	public static void main(String[] args) {
		MinCostClimbingStairs stairs = new MinCostClimbingStairs();
		System.out.println(stairs.minCostClimbingStairs(new int[] {1,100,1,1,1,100,1,1,100,1}));
	}
	
    public int minCostClimbingStairs(int[] cost) {
        int[] minCost = new int[cost.length]; // Memoization
        int length = cost.length;
        int minCostFromLastStair = cost[length - 1] + minCost(length - 1, cost, minCost);
        int minCostFromSecondLastStair = cost[length - 2] + minCost(length - 2, cost, minCost);
        
        return Math.min(minCostFromLastStair, minCostFromSecondLastStair);
    }
    
    // Recursive top down approach
    public int minCost(int index, int[] cost, int[] minCost) {
        //base case
        if(index == 0 || index == 1) {
            return 0;
        }
        
        if(index == 2) {
            return Math.min(cost[0], cost[1]);
        }
        
        if(minCost[index] != 0) {
            return minCost[index];
        }
        
        int min = 0;
        
        for(int i = index; i > 2; i--) {
            min = Math.min(cost[index - 1] + minCost(index - 1, cost, minCost), cost[index - 2] + minCost(index - 2, cost, minCost));
        }
        
        minCost[index] = min;
        return min;
    }
    
    //Iterative bottom up approach, Space complexity O(1)
    public int minCostIterative(int[] cost) {
    		int n = cost.length;
    		int first = cost[0];
    		int second = cost[1];
    		
    		for (int i = 2; i < n; i++) {
    			int curr = cost[i] + Math.min(first, second);
    			first = second;
    			second = curr;
    		}
    		
    		return Math.min(first, second);
    }
}
