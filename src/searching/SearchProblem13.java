/**
 * 
 */
package searching;

/**
 * @author rahulbhatt
 * 
 * Problem: THE k-th LARGEST ELEMENT 
 * *********************************
 * 
 * Design an algorithm for computing the k-th largest element in an array A that runs in O(n) expected time.
 * 
 * Solution: QuickSelect approach (A optimized version of Quick Sort algorithm). In QuickSort, we pick a pivot element, 
 * then move the pivot element to its correct position and partition the array around it. The idea is, not to do complete quicksort, 
 * but stop at the point where pivot element itself is k’th largest/smallest element. 
 * Also, not to process for both left and right sides of pivot, but process only one of them according to the position of pivot. 
 * 
 * Time Complexity:
 * Worst Case: O(n^2)
 * Average Case: O(n); The assumption in the analysis is, random number generator is equally likely to generate any number in the input range.
 */
public class SearchProblem13 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SearchProblem13 prob = new SearchProblem13();
		int[] a = { 1, 2, 3, 4, 5 };
		System.out.println(prob.findKthLargest(a, 2));
	}

	public int findKthLargest(int[] a, int k) {
		
		int l = 0;
		int r = a.length - 1;
		
		// If k is smaller than number of elements in array
		if (k > 0 && k <= r - l + 1) {
			
			while(l <= r) {
				int pos = partition(a, l, r);

				// If position is same as k
				if (pos - l == k - 1)
					return a[pos];

				// else reposition left and right index based on partition index (pos)
				if (pos - l > k - 1) {
					r = pos - 1;
				} else {
					l = pos + 1;
				}
			}
		}

		// else return Max integer value
		return Integer.MAX_VALUE;
	}

	public int partition(int[] a, int left, int right) {
		int x = a[right], i = left;

		for (int j = left; j <= right - 1; j++) {
			if (a[j] <= x) {
				// Swapping a[i] and a[j]
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;

				i++;
			}
		}

		// Swapping a[i] and a[r]
		int temp = a[i];
		a[i] = a[right];
		a[right] = temp;

		return i;
	}

}