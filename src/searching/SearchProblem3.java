/**
 * 
 */
package searching;

/**
 * @author rahulbhatt
 *
 * Problem: SEARCH A SORTED ARRAY FOR A[i] = i
 * ********************************************
 * 
 * Design an efficient algorithm that takes a sorted array A of distinct integers and returns an index i such that A[i] = i or
 * indicate that no such index exists by returning -1.
 * 
 * Solution: Use binary search.
 * 
 * Time Complexity: O(log n)
 */
public class SearchProblem3 {

	public static void main(String[] args) {
		int[] a = {-1, 0, 1, 3, 9, 10};
		System.out.println("Required Index: " + findFirstOccurence(a));
		
		int[] b = {-1, 0, 1, 2, 3, 5};
		System.out.println("Required Index: " + findFirstOccurence(b));
		
		int[] c = {-1, 0, 1, 2, 3, 4};
		System.out.println("Required Index: " + findFirstOccurence(c));
	}
	
	static int findFirstOccurence(int[] a) {
		int result = -1;
		int left = 0;
		int right = a.length - 1;
		
		// Binary search without using recursion
		while(left <= right) {
			int mid = left + (right - left) / 2;
			
			if(a[mid] > mid) {
				right = mid - 1;
			} else if(a[mid] == mid) {
				result = mid;
				break;
			} else if(a[mid] < mid) {
				left = mid + 1;
			}
		}
		
		return result;
	}

}
