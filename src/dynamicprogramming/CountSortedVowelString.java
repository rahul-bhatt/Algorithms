package dynamicprogramming;

/*
Given an integer n, return the number of strings of length n that consist only of 
vowels (a, e, i, o, u) and are lexicographically sorted.

A string s is lexicographically sorted if for all valid i, 
s[i] is the same as or comes before s[i+1] in the alphabet.


Example 1:
----------
Input: n = 1
Output: 5
Explanation: The 5 sorted strings that consist of vowels only are ["a","e","i","o","u"].

Example 2:
----------
Input: n = 2
Output: 15
Explanation: The 15 sorted strings that consist of vowels only are
["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"].
Note that "ea" is not a valid string since 'e' comes after 'a' in the alphabet.
 
 */

/*
 Solution: This is kind of a pattern recognizing problem. First we see how many such 
 strings are possible when n is small and try to find out the relations of the counts
 with different values of n.
   
 n = 1, [1, 1, 1, 1, 1], count of strings possible when n = 1 starting with a,e,i,o,u respectively
 n = 2, [5, 4, 3, 2, 1]
 n = 3, [15, 10, 6, 3, 1]
 
 So the count of n = 2 can be constructed from count array when n = 1 and so on. The pattern is:
 count[i] = count[i] + count[i + 1]
 
 Also, whatever the value of n is, we will only have 1 count for strings starting with u, since
 the string has to be lexicographically sorted.
 */

// Time complexity: O(n), where n is the input parameter

public class CountSortedVowelString {
	
	public static void main(String[] args) {
		CountSortedVowelString count = new CountSortedVowelString();
		System.out.println("count when n is 1 = " + count.countVowelStrings(1));
		System.out.println("count when n is 3 = " + count.countVowelStrings(3));
		System.out.println("count when n is 33 = " + count.countVowelStrings(33));
	}
	
	public int countVowelStrings(int n) {
		
		if(n == 1) return 5;
		
		// base case
		// This array holds the count of string possible with vowels starting 
		// at vowel at that index {a,e,i,o,u}
		// initialized to the case when n = 1
		int[] countArray = {1,1,1,1,1};
		
		for(int i = 2; i <= n; i++) {
			for(int j = 3; j >= 0; j--) {
				countArray[j] += countArray[j + 1];
			}
		}
		
		int count = 0;
		for(int i = 0; i < 5; i++) {
			count += countArray[i];
		}
		
		return count;
	}
}
