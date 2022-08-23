package arrays;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * You're given an array of points plotted on a 2D graph (the xy-plane)
 * Write a a function that returns the maximum number of points that a single line
 * (or potentially multiple lines) on the graph passes through.
 * 
 * The input array will contain points represented by an array of two integers [x, y].
 * The input array will never contain duplicate points and will always contain at least one point.
 * 
 * Sample input:
 * points = [
 * 	[1, 1],
 * 	[2, 2],
 * 	[3, 3],
 * 	[0, 4],
 * 	[-2, 6],
 * 	[4, 0],
 * 	[2, 1]
 * ]
 * 
 * Sample Output:
 * 4 // A line passes through points: [-2, 6], [0, 4], [2, 2], [4, 0].
 * 
 * @author rahulbhatt
 *
 */
public class LineThroughPoints {

	public static void main(String[] args) {
		int[][] points = {{-2, 6}, {0, 4}, {2, 2}, {4, 0}};
		System.out.println();
	}
	
	// Time: O(n ^ 2)
	// Space: O(n)
	public static int maxLineThroughPoints(int[][] points) {
		
		int maxNoOfPoints = 1;
		
		for(int i = 0; i < points.length; i++) {
			int[] p1 = points[i];
			
			Map<String, Integer> slopes = new HashMap<>();
			
			for(int j = i + 1; j < points.length; j++) {				
				int[] p2 = points[j];
				
				int[] slope = getSlope(p1, p2);
				String slopeKey = getSlopeKey(slope);
				
				if(!slopes.containsKey(slopeKey)) {
					slopes.put(slopeKey, 1);
				}
				
				slopes.put(slopeKey, slopes.get(slopeKey) + 1);
				
				maxNoOfPoints = Math.max(maxNoOfPoints, slopes.get(slopeKey));
			}
		}
		
		return maxNoOfPoints;
	}
	
	private static String getSlopeKey(int[] slope) {
		return String.valueOf(slope[0]) + ":" + String.valueOf(slope[1]);
	}
	
	private static int[] getSlope(int[] p1, int[] p2) {
		int x1 = p1[0];
		int y1 = p1[1];
		
		int x2 = p2[0];
		int y2 = p2[1];
		
		int[] slope = new int[] {1, 0}; // horizontal line
		
		//If not horizontal line
		if(y1 != y2) {
			int xDiff = x2 - x1;
			int yDiff = y2 - y1;
			
			int gcd = getGreatestCommonDivisor(Math.abs(xDiff), Math.abs(yDiff));
			
			xDiff = xDiff / gcd;
			yDiff = yDiff / gcd;
			
			if(yDiff < 0) {
				xDiff *= -1;
				yDiff *= -1;
			}
			
			slope = new int[] {xDiff, yDiff};
		}
		
		return slope;
	}
	
	private static int getGreatestCommonDivisor(int xDiff, int yDiff) {
		int x = xDiff;
		int y = yDiff;
		
		while(true) {
			if(x == 0) return y;
			if(y == 0) return x;
			
			int temp = x;
			x = y;
			y = temp % x;
		}
	}

}
