/**
 * 
 */
package arrays;

import java.util.HashSet;

/**
 * @author rahulbhatt
 *
 * Write a program to remove duplicate characters from a String.
 * With and Without using additional space.
 */
public class RemoveDuplicates {

	public static void main(String[] args) {
		RemoveDuplicates rd = new RemoveDuplicates();
		System.out.println("Removing dupes using extra space: " + rd.removeDuplicate(new StringBuilder("ababac")));
		System.out.println("Removing dupes in place: " + rd.removeDuplicate(new StringBuilder("ababac")));
	}
	
	/*
	 * Remove duplicate using extra space (HashSet)
	 * Time Complexity: O(n)
	 * Space Complexity: O(n) 
	 * 
	 */
	public StringBuilder removeDuplicate(StringBuilder str) {
		HashSet<Character> uniqueChars = new HashSet<>();
		
		for(int i = 0; i < str.length(); i++) {
			if(uniqueChars.contains(str.charAt(i))) {
				str.deleteCharAt(i);
				i--;
			} else {
				uniqueChars.add(str.charAt(i));
			}
		}
		
		return str;
	}
	
	/* 
	 * Remove duplicate in place
	 * Time Complexity: O(n^2)
	 * Space complexity: O(1)
	 * 
	 * */
	public StringBuilder removeDuplicateInPlace(StringBuilder str) {
		for(int i = 0; i < str.length(); i++) {
			for(int j = i + 1; j < str.length(); j++) {
				if(str.charAt(i) == str.charAt(j)) {
					for(int k = j + 1; k < str.length(); k++) {
						str.setCharAt(k - 1, str.charAt(k));
					}
					
					j--;
				}
			}
		}
		
		return str;
	}
}
