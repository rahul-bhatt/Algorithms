package arraysandstrings;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Find the Kth largest element in an array.
 * 
 * @author rahulbhatt
 *
 */
public class KthLargest {

	public static void main(String[] args) {
		int[] array = new int[] {4,3,5,1,2};
		System.out.println(kthLargestUsingPriorityQueue(array, 2));
		System.out.println(kthLargestUsingKSelect(array, 2));
	}

	//Using quickSort/Kselect method
	public static int kthLargestUsingKSelect(int[] array, int k) {
		
		return quickSort(array, 0, array.length - 1, array.length - k)[array.length - k];
	}
	
	//Time: O(n), Space: O(1)
	public static int[] quickSort(int[] array, int startIdx, int endIdx, int index) {
		int pivot = startIdx;
		int leftIdx = pivot + 1;
		int rightIdx = endIdx;
		
		while(leftIdx <= rightIdx) {
			if(array[leftIdx] > array[pivot] && array[rightIdx] < array[pivot]) {
				swap(leftIdx, rightIdx, array);
			}
			
			if(array[leftIdx] < array[pivot]) leftIdx++;
			
			if(array[rightIdx] > array[pivot]) rightIdx--;
			
		}
		
		swap(pivot, rightIdx, array);
		
		if(rightIdx == index) return array;
		
		if(rightIdx > index) {
			return quickSort(array, startIdx, rightIdx - 1, index);
		} else {
			return quickSort(array, rightIdx, array.length - 1, index);
		}
	}
	
	//Time: O(n), Space: O(1)
	public static int kthLargestUsingPriorityQueue(int[] array, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		for(int element : array) {
			minHeap.add(element);
			
			if(minHeap.size() > k) {
				minHeap.poll();
			}
		}
		
		return minHeap.poll();
	}
	
	public static void swap(int i, int j, int[] array) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
