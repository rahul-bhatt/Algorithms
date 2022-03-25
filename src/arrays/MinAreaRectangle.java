package arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * You are given an array of points on a 2D graph (the xy-plane).
 * Write a function that returns the minimum area of any rectangle 
 * that can be formed using any 4 of these points such that the 
 * rectangle's sides are paraallel to the x and y axes.
 * 
 * If no rectangle can be formed your function should return 0.
 * 
 * The input array will contain points represented by arrays of two
 * integers [x, y]. The input array will never contain duplicate points.
 * 
 * @author rahulbhatt
 *
 */

public class MinAreaRectangle {

	public static void main(String[] args) {
		int[][] points = new int[][] {{1, 5}, {5, 1}, {4, 2}, {2, 4}, {2, 2}, {1, 2}, {4, 5}, {2, 5}, {-1, -2}};
		System.err.println(minimumAreaRectangle(points));
	}

	//Time: O(n ^ 2) | Space: O(n)
	public static int minimumAreaRectangle(int[][] points) {				
		//1. Stringify the coords and put it in a hash set
		Set<String> coordsSet = getCoordsSet(points);

		//2. Go through each coords and for each coord go through 
		// other coords to see if it can be the digonal coord

		int minArea = Integer.MAX_VALUE;
		for(int i = 0; i < points.length; i++) {
			for(int j = 0; j < points.length; j++) {
				if(i == j) continue;

				if(!isDiagonalyOpposite(points[i], points[j])) {
					continue;
				}

				int[] topLeftCoord = getTopLeftCoord(points[i], points[j]);
				int[] bottomRightCoord = getBottomRightCoord(points[i], points[j]);

				String topLeftCoordString = getStringCoords(topLeftCoord[0], topLeftCoord[1]);
				String bottomRightCoordString = getStringCoords(bottomRightCoord[0], bottomRightCoord[1]);

				if(coordsSet.contains(topLeftCoordString) && coordsSet.contains(bottomRightCoordString)) {
					int area = getArea(points[i], points[j]);

					if(area < minArea) {
						minArea = area;
					}
				}
			}
		}

		return minArea == Integer.MAX_VALUE ? 0 : minArea;
	}

	public static int getArea(int[] p1, int[] p2) {
		int x1= p1[0];
		int y1 = p1[1];

		int x2 = p2[0];
		int y2 = p2[1];

		int length = Math.abs(x2 - x1);
		int height = Math.abs(y2 - y1);

		return length * height;
	}

	public static boolean isDiagonalyOpposite(int[] p1, int[] p2) {
		int x1 = p1[0];
		int y1 = p1[1];

		int x2 = p2[0];
		int y2 = p2[1];

		return y2 > y1 && x2 > x1;
	}

	public static Set<String> getCoordsSet(int[][] points) {
		Set<String> coordsSet = new HashSet<String>();
		for(int i = 0; i < points.length; i++) {
			String stringCoords = getStringCoords(points[i][0], points[i][1]);
			coordsSet.add(stringCoords);
		}

		return coordsSet;
	}

	public static String getStringCoords(int x, int y) {
		return String.valueOf(x) + "|" + String.valueOf(y);
	}

	public static int[] getTopLeftCoord(int[] point1, int[] point2) {
		int x1 = point1[0];
		int y1 = point1[1];

		int x2 = point2[0];
		int y2 = point2[1];

		return new int[]{x1, y2};
	}

	public static int[] getBottomRightCoord(int[] point1, int[] point2) {
		int x1 = point1[0];
		int y1 = point1[1];

		int x2 = point2[0];
		int y2 = point2[1];

		return new int[]{x2, y1};
	}
}
