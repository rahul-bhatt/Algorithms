package searching;

/**
 * @author rahulbhatt
 * 
 * Problem: SEARCH FOR A PAIR IN AN ABS-SORTED ARRAY
 * *************************************************
 * 
 * An abs-sorted array is an array of numbers in which |A[i]| <= |A[j]| whenever i < j.
 * For example: [-49, 75, 103, -147, 164, -197, -238, 314, 348, -422]
 * 
 * Design an algorithm that takes an abs-sorted array A and a number k, and returns a pair of 
 * indices of elements in A that sum up to k. Output(-1, -1) if there is no such pair.
 * 
 * Solution 1: If the array would have been sorted in the traditional sense, we can start with the pair consisting of the first element and the
 * last element. Let's say S = A[0] + A[n - 1].
 * If S = k, we are done.
 * If S < k, we would increase the pointer to A[1], and would never consider A[0].
 * If S > k, we would decrease the pointer to A[n - 2], and would never consider A[n - 1].
 * 
 * This algorithm would take O(n) time and O(1) space.
 * 
 * In case of an absolute sorted array, we will need to consider 3 scenarios:
 * 
 * 1. Both the numbers in the pair are positive.
 * 2. Both the numbers in the pair are negative.
 * 3. One number is positive and the other is negative.
 * 
 * For #1 and #2, we can run the above algorithm separately by limiting ourselves to either positive or negative numbers.
 * For #3 we can use the same approach where we have one index for positive numbers and one index for negative numbers and they
 * both start from the highest possible index and then go down.
 * 
 * Solution 2: A simpler solution is based on a hash table to store all the numbers and then for each
 * number x in the array, look up k - x in the hash table. This approach would take O(n) time, however it would take
 * O(n) additional space.
 */
public class SearchProblem4 {

	public static void main(String[] args) {
		int[] arr = {-49, 75, 103, -147, 164, -197, -238, 314, 348, -422};
		int k = 167;
		int n = arr.length;

		// Code for Solution 1

		// Both numbers in the pair are positive
		for(int i = 0, j = n - 1; i < j; ) {
			if(arr[i] < 0) {
				i++;
				continue;
			}

			if(arr[j] < 0) {
				j--;
				continue;
			}

			int s = arr[i] + arr[j];

			if(s == k) {
				System.out.println(i + ", " + j);
				return;
			}

			if(s < k) {
				i++;
			} else {
				j--;
			}

		}

		// Both numbers in the pair are negative
		for(int i = 0, j = n - 1; i < j; ) {
			if(arr[i] >= 0) {
				i++;
				continue;
			}

			if(arr[j] >= 0) {
				j--;
				continue;
			}

			int s = arr[i] + arr[j];

			if(s == k) {
				System.out.println(i + ", " + j);
				return;
			}

			if(s < k) {
				i++;
			} else {
				j--;
			}

		}

		// One number is positive and the other is negative
		int i, j;
		for(i = n - 1; arr[i] < 0; i--);
		for(j = n - 1; arr[j] >= 0; j--);

		while(true) {
			int s = arr[i] + arr[j];
			if(s == k) {
				System.out.println(i + ", " + j);
				return;
			}

			if(s < k) {
				do { j--; } while(arr[j] >= 0 && j >= 0);
			} else {
				do { i--; } while(arr[i] < 0 && i >= 0);
			}

			if(i < 0 || j < 0) {
				break;
			}
		}

		System.out.println("-1, -1");
	}

}
