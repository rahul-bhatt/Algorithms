package strings;

/**
 * 
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word 
 * or phrase, typically using all the original letters exactly once.
 * 
 * @author rahulbhatt
 *
 */
public class ValidAnagram {
	
	public static void main(String[] args) {
		System.out.println(isAnagram("anagram", "nagaram"));
		System.out.println(isAnagram("aba", "ba"));
	}
	
	
	//Time: O(n) | Space: O(c)
	// n is the length of the either string, s is the length of the character class
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        
        int[] alphabet = new int[26];
        for(int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
            alphabet[t.charAt(i) - 'a']--;
        }
        
        for(int i = 0; i < 26; i++) {
            if(alphabet[i] != 0) return false;
        }
        
        return true;
    }

}
