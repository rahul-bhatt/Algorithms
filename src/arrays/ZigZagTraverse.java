package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Write a function that takes in an n * m two dimensional
 * array and returns a one-dimensional array of all the array's
 * elements in zigzag order.
 * 
 * Zigzag order starts at the top left corner of the two-dimensional array,
 * foes down by one element and proceeds in a zigzag pattern all
 * the way to the bottom right corner.
 * 
 * Input:
 * [
 * 	[1, 3, 4, 10],
 * 	[2, 5, 9, 11],
 * 	[6, 8, 12, 15],
 * 	[7, 13, 14, 16]
 * ]
 * 
 * Output:
 * [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]
 * 
 * @author rahulbhatt
 *
 */
public class ZigZagTraverse {

	public static void main(String[] args) {
		List<List<Integer>> array = new ArrayList<List<Integer>>();
		array.add(Arrays.asList(1,3,4,10));
		array.add(Arrays.asList(2,5,9,11));
		array.add(Arrays.asList(6,8,12,15));
		array.add(Arrays.asList(7,13,14,16));
		
		//array.add(Arrays.asList(1,2,3,4,5));

		List<Integer> traverse = zigzagTraverse(array);

		for(int num : traverse) {
			System.out.print(num + " ");
		}
	}

	// Time: O(n), Space: O(n)
	public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
		List<Integer> traverse = new ArrayList<Integer>();

		int rows = array.size();
		int cols = array.get(0).size();
		boolean up = true;
		boolean down = false;

		int counter = 1;
		int x = 0, y = 0;
		traverse.add(array.get(x).get(y));
		if(x + 1 < rows) {
			x++;
		} else if(y + 1 < cols) {
			y++;
		}

		while(counter < rows * cols) {
			if(up) {				
				while(x >= 0 && y < cols) {
					traverse.add(array.get(x).get(y));
					counter++;
					x--;
					y++;
			
				}
				
				if(x < 0 || y >= cols) {
					if(y >= cols) {
						x += 2;
						y--;
					} else {
						x++;
					}
				}
				up = false;
				down = true;
			} else {
				while(x < rows && y >= 0) {
					traverse.add(array.get(x).get(y));
					counter++;
					x++;
					y--;
				}

				if(y < 0 || x >= rows) {
					if(x >= rows) {
						x--;
						y += 2;
					} else {
						y++;
					}
				}
				down = false;
				up = true;
			}
		}

		return traverse;
	}
}
