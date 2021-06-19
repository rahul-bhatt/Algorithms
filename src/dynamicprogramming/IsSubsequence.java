package dynamicprogramming;

/*
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by 
deleting some (can be none) of the characters without disturbing the relative positions 
of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 */

// Time complexity - O(n)

public class IsSubsequence {
	public static void main(String[] args) {
		IsSubsequence subsequence = new IsSubsequence();
		System.out.println(subsequence.isSubsequence("ace", "abcde"));
		System.out.println(subsequence.isSubsequence("aec", "abcde"));
	}
	
    public boolean isSubsequence(String s, String t) {
        
        // if s is empty, return true
        if(s.isEmpty()) {
            return true;
        }
        
        int index = 0;
        for(int i = 0; i < t.length(); i++) {
            if(t.charAt(i) == s.charAt(index)) {
                index++;
            }
            
            if(index >= s.length()) {
                return true;
            }
        }
        
        return false;
    }
}
