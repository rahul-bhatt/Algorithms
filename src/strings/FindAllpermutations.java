package strings;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Print all possible permutations of a string.
 * 
 * @author rahulbhatt
 *
 */
public class FindAllpermutations {

	public static void main(String[] args) {
		List<String> perms = getPermutations("abc");
		
		for(String str : perms) {
			System.out.println(str);
		}
	}
	
	//Time - O(n * n!) | Space - O(n * n!)
	public static List<String> getPermutations(String str) {
		List<String> perms = new ArrayList<String>();
		getPermutationsRecursive(0, str.toCharArray(), perms);
		return perms;
	}
	
	public static void getPermutationsRecursive(int i, char[] array, List<String> perms) {
		if(i == array.length - 1) {
			perms.add(new String(array));
		} else {
			for(int j = i; j < array.length; j++) {
				swap(i, j, array);
				getPermutationsRecursive(i + 1, array, perms);
				swap(i, j, array);
			}
		}
	}

	public static void swap(int i, int j, char[] array) {
		char c = array[i];
		array[i] = array[j];
		array[j] = c;
	}
}
