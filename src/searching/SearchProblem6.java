package searching;

/**
 * @author rahulbhatt
 * 
 * Problem: SEARCH A SORTED ARRAY OF UNKNOWN LENGTH
 * ************************************************
 * 
 * Let A be a sorted array. The length of A is not known in advance; accessing A[i] for i beyond the end of the array throws an exception.
 * Design an algorithm that takes A and a key k and returns an index i such that A[i] = k; return -1 if k does not appear in A.
 * 
 * Solution: The key idea here is to do simultaneous binary search to find the bounds of the array as well as to find the element.
 * The run time of the two binary search operations would still be log n + log n, which is O(log n).
 * 
 * Time Complexity: O(log n)
 * 
 */
public class SearchProblem6 {

	public static void main(String[] args) {
		int[] a = {1, 5, 100, 121, 306, 405, 406, 407, 901, 999};
		System.out.println(findIndex(a, 407));
		System.out.println(findIndex(a, -1));
		System.out.println(findIndex(a, 999));
	}

	public static int findIndex(int[] a, int num) {

		// First find the bounds of the array where the element is likely to be found in log n time
		int position = 0;

		while(true) {
			try {
				int val = a[1 << position];
				if(val == num) {
					return (1 << position);
				} else if(val > num) {
					break;
				}

			} catch(Exception e) {
				break;
			}

			position++;
		}

		// Do binary search to find the element
		// We have to handle the case of accessing out of bound index since the length of the array is unknown
		// and the right position might exists outside the array index
		int left = 0;
		int right = 1 << position;

		while(left <= right) {
			int mid = left + (right - left) / 2;
			try {
				if(num == a[mid]) {
					return mid;
				} else if(num > a[mid]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			} catch(Exception e) {
				right = mid - 1;
			}
		}

		return -1;
	}

}
