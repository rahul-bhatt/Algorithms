package searching;

/**
 * @author rahulbhatt
 *
 * Problem: SEARCH A CYCLICALLY SORTED ARRAY
 * *****************************************
 * 
 * Design an O(log n) algorithm for finding the position of the smallest element in a cyclically sorted array. Assume all elements are distinct.
 * 
 * For example, for a cyclically sorted array - [4, 7, 8, 10, 12, 13, 15, 20, 1, 3], the output should return "8", which is the position of the
 * smallest element "1".
 * 
 * Solution: Use binary search approach.
 * 
 * Time Complexity: O(log n).
 * 
 */
public class SearchProblem5 {

	public static void main(String[] args) {
		int[] a = {4, 7, 8, 10, 12, 13, 15, 20, 1, 3};
		System.out.println(findSmallest(a));
		
		int[] b = {387, 478, 550, 631, 103, 203, 220, 234, 279, 368};
		System.out.println(findSmallest(b));
		
		int[] c = {0, 1, 2, 3, 4};
		System.out.println(findSmallest(c));	}
	
	public static int findSmallest(int[] a) {
		int left = 0;
		int right = a.length - 1;
		
		while(a[left] > a[right]) {
			int mid = left + (right - left) / 2;
			if(left == mid) {
				left = right;
			} else if(a[mid] > a[left]) {
				left = mid;
			} else {
				right = mid;
			}
		}
		
		return left;
	}

}
