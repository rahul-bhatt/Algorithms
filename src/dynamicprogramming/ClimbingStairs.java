package dynamicprogramming;

/*
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. 

In how many distinct ways can you climb to the top?
 
 */

// Time complexity: O(n)

public class ClimbingStairs {

	public static void main(String[] args) {
		ClimbingStairs stairs = new ClimbingStairs();		
		System.out.println("No. of ways to climb: " + stairs.climbStairs(3));
	}
	
    public int climbStairs(int n) {        
        /*
         Ways[1] = 1
         Ways[2] = 2
         Ways[3] = Ways[2] + Ways[1]
         Ways[4] = Ways[3] + Ways[2]
         
         Can be solved recursively or iteratively
        */
        
        //base case
        if(n == 1) return 1;
        if(n == 2) return 2;
        
        int waysPrev = 1; //Ways[1]
        int waysCurrent = 2; //Ways[2]
        int ways = 0;
        
        for(int i = 3; i <= n; i++) {
            ways = waysPrev + waysCurrent;
            waysPrev = waysCurrent;
            waysCurrent = ways;
        }
        
        return ways;
    }
}
