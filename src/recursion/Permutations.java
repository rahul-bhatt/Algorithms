package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Write a function that takes in an array of unique integers and returns 
 * an array of all permutations of those integers in no particular order.
 * 
 * If the input array is empty, the function should return an empty array.
 * 
 * Time complexity - O(n * n!)
 * Space complexity - O(n * n!)
 * 
 * @author rahulbhatt
 *
 */

public class Permutations {

	public static List<List<Integer>> getPermutations(List<Integer> array) {
		List<List<Integer>> permutations = new ArrayList<List<Integer>>();
		getPermutations(0, array, permutations);
		return permutations;
	}
	
	public static void getPermutations(int i, List<Integer> array, List<List<Integer>> permutations) {
		if(i == array.size() - 1) {
			permutations.add(new ArrayList<Integer>(array));
		} else {
			for(int j = i; j < array.size(); j++) {
				swap(array, i, j);
				getPermutations(i + 1, array, permutations);
				swap(array, i, j);
			}
		}
	}
	
	public static void swap(List<Integer> array, int i, int j) {
		Integer temp = array.get(i);
		array.set(i, array.get(j));
		array.set(j, temp);
	}
	
	public static void main(String[] args) {
		List<List<Integer>> permutations = Permutations.getPermutations(Arrays.asList(1, 2, 3));
		
		for(List<Integer> permutation : permutations) {
			System.out.println(permutation);
		}
	}
}
