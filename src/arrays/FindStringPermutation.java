/**
 * 
 */
package arrays;

/**
 * Given two Strings, implement an algorithm to determine if
 * one is a permutation of other.
 * 
 * @author Rahul
 *
 */
public class FindStringPermutation {
	
	public static void main(String[] args) {
		System.out.println(isPermutation("abcd", "dcba"));
		System.out.println(isPermutationUsingCharacterCounts("abcd", "dcba"));
		
		System.out.println(isPermutation("abcd", "dcca"));
		System.out.println(isPermutationUsingCharacterCounts("abcd", "dcca"));
	}
	
	/*
	 * First algorithm: Sort the string and compare the results.
	 */
	public static boolean isPermutation(String s, String t) {
		//First optimization: If Strings are of different length then return false.
		if(s.length() != t.length()) return false;
		
		//compare the sorted Strings.
		return sort(s).equals(sort(t));
	}
	
	private static String sort(String s) {
		char[] charSet = s.toCharArray();
		java.util.Arrays.sort(charSet);
		return new String(charSet);
	}
	
	/*
	 * Second algorithm: Compare the character counts.
	 */
	public static boolean isPermutationUsingCharacterCounts(String s, String t) {
		//First optimization: If Strings are of different length then return false.
		if(s.length() != t.length()) return false;
		
		//Assumption: ASCII char set.
		int[] charCount = new int[256];
		for(int i = 0; i < s.length(); i++) {
			charCount[s.charAt(i)]++;
		}
		
		for(int i = 0; i < t.length(); i++) {
			if(--charCount[t.charAt(i)] < 0) return false;
		}
		
		return true;
	}

}
