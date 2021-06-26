package dynamicprogramming;

/*
Given a string s, return the longest palindromic substring in s.

Example 1:
Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Example 2:
Input: s = "cbbd"
Output: "bb"

Example 3:
Input: s = "a"
Output: "a"
 */

/*
We pick a char from the string as a middle element
and then compares all adjacent chars to find if they are equal.

There can be a case wherein the middle is not an element, in that
case we will use the same mechanism with a slight modification.

Time complexity: O(n * 2)
Space complexity: O(1)

We can solve this problem using DP as well, constructing a DP matrix, time
complexity would remain same however it would take O(n * 2) space complexity.
*/ 


public class LongestPalindromicSubstring {
	public static void main(String[] args) {
		LongestPalindromicSubstring s = new LongestPalindromicSubstring();
		System.out.println(s.longestPalindrome("babad"));
	}
	
    public String longestPalindrome(String s) {
        
        int longestLength = 1;
        String longestSubstring = s.substring(0, 1);
        int n = s.length();
        
        // If the middle of the substring is an element, odd number of chars
        for(int mid = 0; mid < n; mid++) {
            for(int l = 1; mid - l >= 0 && mid + l < n; l++) {
                if(s.charAt(mid - l) != s.charAt(mid + l)) {
                    break;
                }
                
                int length = 2 * l + 1;
                
                if(length > longestLength) {
                    longestLength = length;
                    longestSubstring = s.substring(mid - l, mid + l + 1);
                }
            }
        }
        
        // If the middle of the string is not an element, even number of chars
        for(int mid = 0; mid < n; mid++) {
            for(int l = 1; mid - l + 1 >= 0 && mid + l < n; l++) {
                if(s.charAt(mid - l + 1) != s.charAt(mid + l)) {
                    break;
                }
                
                int length = 2 * l;
                
                if(length > longestLength) {
                    longestLength = length;
                    longestSubstring = s.substring(mid - l + 1, mid + l + 1);
                }
            }
        }
        
        return longestSubstring;
    }
}
