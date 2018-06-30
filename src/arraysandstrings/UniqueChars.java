package arraysandstrings;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 * 
 * @author Rahul
 *
 */
public class UniqueChars {

	public static void main(String[] args) {
		String input = "azAZcdefg//";
		System.out.println(isUniqueChars(input));
	}
	
	/*
	 * Algorithm:
	 * This algorithm uses a boolean table (array) to store the occurrence of a character.
	 * Traverse the string and if the corresponding index is set to true return false otherwise set 
	 * the value of that index to true.
	 * 
	 * Assumption: 
	 * Assumption is that character set is stored in ASCII format (256 chars). 
	 * If stored in Unicode format would require more extra space.
	 * 
	 * Run Time Complexity: O(n).
	 * Space complexity: O(1).
	 */
	private static boolean isUniqueChars(String input) {
		if(input.length() > 128) {
			return false;
		}
		
		boolean[] charSet = new boolean[256];
		for(int i = 0; i < input.length(); i++) {
			int value = input.charAt(i);
			if(charSet[value]) return false;
			
			charSet[value] = true;
		}
		
		return true;
	}
}
