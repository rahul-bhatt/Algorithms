package strings;

/**
 * 
 * Given a string, find the first non-repeating character in it. 
 * For example, if the input string is “GeeksforGeeks”, then the output should be ‘f’ and if the input 
 * string is “GeeksQuiz”, then the output should be ‘G’. 
 * 
 * @author rahulbhatt
 *
 */

public class NonRepeating {

	public static void main(String[] args) {

	}

	// Time - O(n) | Space - O(c), where c is the length of the character count
	public static int firstNonRepeating(String str) {
		int[] fi = new int [256]; // array to store First Index

		// initializing all elements to -1
		for(int i = 0; i<256; i++) {
			fi[i] = -1;
		}

		// sets all repeating characters to -2 and non-repeating characters
		// contain the index where they occur
		for(int i = 0; i < str.length(); i++) {
			if(fi[str.charAt(i)] == -1) {
				fi[str.charAt(i)] = i;
			} else {
				fi[str.charAt(i)] = -2;
			}
		}

		int res =  Integer.MAX_VALUE;

		for(int i = 0; i<256; i++) {

			// If this character is not -1 or -2 then it
			// means that this character occurred only once
			// so find the min index of all characters that
			// occur only once, that's our first index
			if(fi[i] >= 0)
				res = Math.min(res, fi[i]);
		}

		// if res remains  Integer.MAX_VALUE, it means there are no
		// characters that repeat only once or the string is empty
		if(res ==  Integer.MAX_VALUE) {
			return -1;
		} else {
			return res;
		}
	}


	// Time - O(n^2) | space : O(1)
	public static int firstNonRepeatingWithoutAuxSpace(String str) {
		boolean flag = false;

		int index = -1;

		for (int i = 0; i < str.length(); i++) {

			// replace a character with "" and
			// then finding the length after replacing and
			// then subtracting  length of that replaced
			// string from the total length of the original string
			int count_occurence = str.length() - str.replace(Character.toString(str.charAt(i)), "").length();

			if (count_occurence == 1) {
				flag = true;
				index = i;
				break;
			}
		}

		if (flag) {
			return str.charAt(index);
		} else {
			return -1;
		}
	}

}

