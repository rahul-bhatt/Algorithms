package strings;

/**
 * @author rahulbhatt
 *
 * Boyer-Moore string search algorithm: This approach is similar to Brute-Force approach
 * of string search however it uses two heuristics in order to improve upon it:
 * 
 * 1. We begin comparison from the last character and move backwards.
 * 
 * 2. If pattern character 'a' mismatches with text character 'b' and if 'b' doesn't appear anywhere
 * in the pattern then shift the pattern completely past 'b'. Otherwise, shift the pattern to align
 * 'b' with the last occurrence of 'b' in the pattern.
 * 
 * Time complexity:
 * O(n + m): When pattern does not appear in the text.
 * O(n * m): When pattern does appear in the text.
 */
public class BoyerMoore {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BoyerMoore bm = new BoyerMoore();
		
		int index = bm.findPattern("acdabcf", "abc");
		if(index > -1) {
			System.out.println("Found pattern at index " + index);
		} else {
			System.out.println("Pattern not found!");
		}
	}
	
	public int findPattern(String text, String pattern) {
		
		int m = pattern.length();
		int n = text.length();
		
		// Step 1: First create a bad suffix array to be referenced later in the algorithm.
		// Bad suffix array would contain the index of last occurrence of each character in the pattern.
		// Assumption: Character set is assumed to be ASCII (256 chars).
		int[] badSuffix = new int[256];
		
		for(int i = 0; i < 256; i++) {
			badSuffix[i] = -1;
		}
		
		for(int i = 0; i < m; i++) {
			badSuffix[pattern.charAt(i)] = i;
		}
		
		// Step 2:
		int s = 0; // initial alignment position at text.
		
		while(s <= n - m) {
			// start the comparison from the end of the pattern moving backwards.
			int j = m - 1;
			
			// Shift the index of comparison till a non match is found.
			while(j >= 0 && pattern.charAt(j) == text.charAt(s + j)) {
				j--;
			}
			
			// if the value of j is -1 it means the match is found.
			if(j < 0) {
				return s;
			} else {
				// else we need to align the position of s to the last occurrence of non matching
				// character in the pattern.
				s += Math.max(1, j - badSuffix[text.charAt(s + j)]);
			}
			
		}
		
		return -1;
	}
}
