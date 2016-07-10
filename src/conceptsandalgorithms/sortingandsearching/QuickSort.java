package conceptsandalgorithms.sortingandsearching;

/**
 * Quicksort is a divide and conquer algorithm which relies on a partition operation: \
 * to partition an array an element called a pivot is selected.
 * All elements smaller than the pivot are moved before it and all greater elements are moved after it. \
 * This can be done efficiently in linear time and in-place. 
 * The lesser and greater sublists are then recursively sorted. 
 * This yields average time complexity of O(n log n), with low overhead, and thus 
 * this is a popular algorithm. Efficient implementations of quicksort (with in-place partitioning) 
 * are typically unstable sorts and somewhat complex, but are among the fastest sorting algorithms 
 * in practice. Together with its modest O(log n) space usage, 
 * quicksort is one of the most popular sorting algorithms and is available in many standard 
 * programming libraries.

 * The important caveat about quicksort is that its worst-case performance is O(n2); 
 * while this is rare, in naive implementations (choosing the first or last element as pivot) 
 * this occurs for sorted data, which is a common case. 
 * The most complex issue in quicksort is thus choosing a good pivot element, as consistently poor 
 * choices of pivots can result in drastically slower O(n2) performance, 
 * but good choice of pivots yields O(n log n) performance, which is asymptotically optimal. 
 * For example, if at each step the median is chosen as the pivot then the algorithm works in O(n log n). 
 * Finding the median, such as by the median of medians selection algorithm is however an O(n) 
 * operation on unsorted lists and therefore exacts significant overhead with sorting. 
 * 
 * In practice choosing a random pivot almost certainly yields O(n log n) performance.
 * 
 * Time Complexity
 * ---------------
 * Best: O(n log n)
 * Average: O(n log n)
 * Worst: O(n2)
 * 
 * Space Complexity
 * ----------------
 * Worst: O(log n)
 * 
 * @author Rahul
 */
public class QuickSort {
	public static void main(String args[]) {
		int arr[] = {1, 3, 6, 9, 8, 7};
		quickSort(arr, 0, arr.length - 1);
		printArray(arr);
	}
	
	static void quickSort(int arr[], int left, int right) {
		if(left < right) {
			int pivot = partition(arr, left, right);
			quickSort(arr, left, pivot - 1);
			quickSort(arr, pivot + 1, right);
		}
	}
	
	/*
	 * partition is the critical step of the quick sort algorithm.
	 * We first pick the right most element as pivot element.
	 * We need to create a "wall" (partition) within the array such that the elements on the
	 * left side of the wall is smaller than the pivot element and the elements on the right
	 * side of the wall is greater than the pivot element.
	 * We finally move the pivot element at the "wall" location which would be the final place
	 * of the pivot element in the sorted array.
	 */
	static int partition(int arr[], int left, int right) {
		int pivot = arr[right];
		int wall = left;
		for(int i = left; i < right; i++) {
			if(arr[i] <= pivot) {
				swap(arr, wall, i);
				wall++;
			}
		}
		
		swap(arr, wall, right);
		
		return wall;
	}
	
	static void swap(int arr[], int first, int second) {
		int temp;
		temp = arr[first];
		arr[first] = arr[second];
		arr[second] = temp;
	}
	
	static void printArray(int arr[]) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
