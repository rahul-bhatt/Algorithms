package searching;

/**
 * @author rahulbhatt
 *
 * Problem: SEARCH A SORTED ARRAY FOR THE FIRST ELEMENT LARGER THAN K
 * *******************************************************************
 * 
 * Design an efficient algorithm that takes a sorted array A and a key k, and finds the index of the first occurrence of an element
 * larger than k. Return -1 if every element is less than or equal to k.
 * 
 * Solution: Apply binary search algorithm. The time complexity would remain O(log n), since we are dividing
 * the array into half in each iteration.
 * 
 * Time Complexity: O(log n)
 * 
 */
public class SearchProblem2 {

	public static void main(String[] args) {
		int[] a = {1,1,3,5,6,6,6,7,10,20,20};

		System.out.println("First occurrence of element larger than 6 is at location: " + findFirstOccurence(a, 6, 0, a.length - 1));

		System.out.println("First occurrence of element larger than 20 is at location: " + findFirstOccurence(a, 20, 0, a.length - 1));

		System.out.println("First occurrence of element larger than 1 is at location: " + findFirstOccurence(a, 1, 0, a.length - 1));

		System.out.println("First occurrence of element larger than 99 is at location: " + findFirstOccurence(a, 99, 0, a.length - 1));
		
		System.out.println("First occurrence of element larger than 12 is at location: " + findFirstOccurence(a, 12, 0, a.length - 1));
		
	}

	static int findFirstOccurence(int[] a, int k, int left, int right) {
		int result = -1;
		int mid = left + (right - left) / 2;
		
		if(mid >= 0 && mid < a.length) { //sanity check to make sure search is done within array bounds
			
			//optimization - return the leftmost element if it is greater than the searched element
			if(a[left] > k) {
				return left;
			}
			
			if(a[mid] < k) {
				//continue search in right sub-array
				return findFirstOccurence(a, k, mid + 1, right);
			} else if(a[mid] > k) {
				//continue search in left sub-array
				return findFirstOccurence(a, k, left, mid);
			} else {
				//continue forward search in right sub-array to find the first occurrence of element larger than k
				for(int i = mid; i <= right; i++) {
					if(a[i] > k) {
						result = i;
						break;
					}
				}
			}
		}

		return result;
	}

}
