package arrays;

/**
 * Given two sorted arrays of size m and n, find the median of the merged sorted array.
 * 
 * @author rahulbhatt
 *
 */

public class FindMedian {

	public static void main(String[] args) {
		int[] array1 = new int[] {1};
		int[] array2 = new int[] {2};
		
		System.out.println(findMedian(array1, array2));
	}

	//Time: O(log(min(m, n)))
	//Space: O(1)
	public static double findMedian(int[] array1, int[] array2) {
		if(array2.length > array1.length) {
			return findMedian(array2, array1);
		}

		int x = array1.length;
		int y = array2.length;

		int low = 0;
		int high = x;

		while(low <= high) {
			int partitionX = (low + high)/2;
			int partitionY = (x + y + 1)/2 - partitionX;

			int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : array1[partitionX - 1];
			int minRightX = (partitionX == x) ? Integer.MAX_VALUE : array1[partitionX];

			int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : array2[partitionY - 1];
			int minRightY = (partitionY == y) ? Integer.MAX_VALUE : array2[partitionY];

			if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
				if ((x + y) % 2 == 0) {
					return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
				} else {
					return (double)Math.max(maxLeftX, maxLeftY);
				}    
			} else if (maxLeftX > minRightY) {
				high = partitionX - 1;
			} else { 
				low = partitionX + 1;
			}
		}
		
		//Should not reach here
		return -1;
	}
}
