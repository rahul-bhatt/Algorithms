package sortingandsearching;

/**
 * Merge sort is an efficient, general-purpose, comparison-based sorting algorithm. 
 * Most implementations produce a stable sort, which means that the implementation preserves the input order 
 * of equal elements in the sorted output. Merge sort is a divide and conquer algorithm.
 * 
 * Time Complexity
 * ---------------
 * Best: O(n log n)
 * Average: O(n log n)
 * Worst: O(n log n)
 * 
 * Space Complexity
 * ----------------
 * Worst: O(n)
 * 
 * Stable Sorting?
 * ---------------- 
 * YES
 * 
 * @author Rahul
 */
public class MergeSort {
	public static void main(String args[]) {
		int arr[] = {9, 8, 4, 5, 1, 2, 7};
		mergeSort(arr, 0, arr.length - 1);
		printArray(arr);
	}
	
	static void mergeSort(int arr[], int left, int right) {
		if(left < right) {
			int middle = (left + right) / 2;
			
			mergeSort(arr, left, middle);
			mergeSort(arr, middle + 1, right);
			merge(arr, left, middle, right);
		}
	}
	
	static void merge(int arr[], int left, int middle, int right) {
		// Find sizes of two sub-arrays to be merged
		int sizeOfLeftSubArray = middle - left + 1;
		int sizeOfRightSubArray = right - middle;
		
		// Create temp arrays
		int tempLeftSubArray[] = new int[sizeOfLeftSubArray];
		int tempRightSubArray[] = new int[sizeOfRightSubArray];
		
		// Copy data to temp arrays
		for(int i = 0; i < sizeOfLeftSubArray; i++) {
			tempLeftSubArray[i] = arr[left + i];
		}
		
		for(int j = 0; j < sizeOfRightSubArray; j++) {
			tempRightSubArray[j] = arr[middle + 1 + j];
		}
		
		//**** Merge the temp arrays ****//
		
		// Initial indexes of first and second sub-arrays
        int i = 0, j = 0;
 
        // Initial index of merged sub-arry array
        int k = left;
        while (i < sizeOfLeftSubArray && j < sizeOfRightSubArray) {
            if (tempLeftSubArray[i] <= tempRightSubArray[j]) {
                arr[k] = tempLeftSubArray[i];
                i++;
            } else {
                arr[k] = tempRightSubArray[j];
                j++;
            }
            
            k++;
        }
 
        // Copy remaining elements of left sub-array if any
        while (i < sizeOfLeftSubArray) {
            arr[k] = tempLeftSubArray[i];
            i++;
            k++;
        }
 
        // Copy remaining elements of right sub-array if any
        while (j < sizeOfRightSubArray) {
            arr[k] = tempRightSubArray[j];
            j++;
            k++;
        }
	}
	
	static void printArray(int arr[]) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
