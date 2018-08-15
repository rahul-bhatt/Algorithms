package searching;

/**
 * @author rahulbhatt
 *
 * Problem: SEARCH A SORTED ARRAY FOR FIRST OCCURENCE OF K
 * ********************************************************
 * 
 * Write a method that takes a sorted array A and a key k and returns the index of the first occurrence of k in A.
 * Return -1 if k does not appear in A.
 * 
 * Solution: Apply binary search algorithm. the only difference would be once an element is found we have to traverse
 * the array backwards to find the first occurrence of element k. The time complexity would remain O(log n), since we are dividing
 * the array into half in each iteration.
 * 
 * Time Complexity: O(log n)
 * 
 */
public class SearchProblem1 {

	public static void main(String[] args) {
		int[] a = {1,2,3,5,6,6,6,7,10,11,20};

		System.out.println("First occurrence of 6 is at location: " + findFirstOccurence(a, 6, 0, a.length));

		System.out.println("First occurrence of 20 is at location: " + findFirstOccurence(a, 20, 0, a.length));

		System.out.println("First occurrence of 1 is at location: " + findFirstOccurence(a, 1, 0, a.length));

		System.out.println("First occurrence of 99 is at location: " + findFirstOccurence(a, 99, 0, a.length));
		
		System.out.println("First occurrence of -99 is at location: " + findFirstOccurence(a, 99, 0, a.length));
		
	}

	static int findFirstOccurence(int[] a, int k, int left, int right) {
		int result = -1;
		int mid = left + (right - left) / 2;

		if(mid >= 0 && mid < a.length) { //sanity check to make sure search is done within array bounds
			if(a[mid] < k) {
				//continue search in right sub-array
				return findFirstOccurence(a, k, mid + 1, right);
			} else if(a[mid] > k) {
				//continue search in left sub-array
				return findFirstOccurence(a, k, left, mid - 1);
			} else {
				//continue backward search in left sub-array to find the first occurrence of k
				while(mid >= 0 && a[mid] == k) {
					mid--;
				}

				result = mid + 1;
			}
		}

		return result;
	}
}
