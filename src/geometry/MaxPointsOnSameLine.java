package geometry;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rahulbhatt
 *
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * 
 * Input: [[1,1],[2,2],[3,3]]
 * Output: 3
 * Explanation:
 * ^
 * |
 * |        o
 * |     o
 * |  o  
 * +------------->
 * 0  1  2  3  4
 * 
 * 
 * Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * Output: 4
 * Explanation:
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 * 
 * Solution: For each point p, calculate its slope with other points and use a map to record of how many points have same slope, 
 * by which we can find out how many points are on same line with p as their one point. 
 * For each point keep doing the same thing and update the maximum number of point count found so far.
 * 
 * Some notes on implementation:
 * A line can be represented as y = m*x + c, where m is the slope and c is the y intercept. So for two points on the same line we will have
 * y1 = m * x1 + c and y2 = m * x2 + c; which will give us m = y2 - y1 / x2 - x1; which can be a double value and can cause precision problems. 
 * To get rid of the precision problems, we treat slope as pair ((y2 – y1), (x2 – x1)) instead of ratio and reduce pair by their gcd before 
 * inserting into map. Vertical and repeated points are treated separately.
 * 
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
*/
public class MaxPointsOnSameLine {

    static class Point {
        int x, y;
        
        Point() { 
        	x = 0; 
        	y = 0; 
        }
        
        Point(int a, int b) { 
        	x = a; 
        	y = b; 
        }
    }
    
    class Pair {
        int a, b;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (a != pair.a) return false;
            return b == pair.b;

        }

        @Override
        public int hashCode() {
            int result = a;
            result = 31 * result + b;
            return result;
        }
    }

	public static void main(String[] args) {
		//[[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
		Point[] points = new Point[6];
		points[0] = new Point(1, 1);
		points[1] = new Point(3, 2);
		points[2] = new Point(5, 3);
		points[3] = new Point(4, 1);
		points[4] = new Point(2, 3);
		points[5] = new Point(1, 4);
		
		MaxPointsOnSameLine maxPointsOnSameLine = new MaxPointsOnSameLine();
		System.out.println(maxPointsOnSameLine.maxPoints(points));
	}

    public int maxPoints(Point[] points) {
    	int length = points.length;
    	
    	if(length < 3) {
    		return length;
    	}
    	
        int maxPoint = 0;

    	for(int i = 0; i < length; i++) {    	
    		Map<Pair, Integer> slopeMap = new HashMap<>();
    		
            int curMax = 1; 
            int overlapPoints = 0; 
            int verticalPoints = 1;
            
    		for (int j = i + 1; j < length; j++) {
    			
    			if(points[i].y == points[j].y && points[i].x == points[j].x) {
    				overlapPoints++;
    			} else if(points[i].x == points[j].x) {
    				verticalPoints++;
    				curMax = Math.max(curMax, verticalPoints);
    			} else {
                    int yDiff = points[j].y - points[i].y;
                    int xDiff = points[j].x - points[i].x;
                    
                    int gcd = gcd(xDiff, yDiff);
                    
                    Pair p = new Pair();
                    p.a = (points[i].y - points[j].y) / gcd;
                    p.b = (points[i].x - points[j].x) / gcd;
                    
                    int count = 2;
                    if (slopeMap.containsKey(p)) {
                        count = slopeMap.get(p);
                        count++;
                        slopeMap.put(p, count);
                    } else {
                    	slopeMap.put(p, count);
                    }
                    
                    curMax = Math.max(curMax, count);
    			}    			
    		}
    		
    		maxPoint = Math.max(maxPoint, curMax + overlapPoints);
    	}

        return maxPoint;
    }
    
    public int gcd(int a, int b) {
    	if(b == 0) {
    		return a;
    	} else {
    		return gcd(b, a % b);
    	}
    }
}
