package datastructures.arraysandstrings;

/**
 * Implement a method to perform basic string compression using the counts of repeated characters.
 * For example: aabcccccaaa -> a2b1c5a3
 * If the compressed string would not become smaller than the original string your method 
 * should return the original string.
 * 
 * @author Rahul
 *
 */
public class StringCompression {

	public static void main(String[] args) {
		System.out.println("Compressed string for aabcccccaaa: " + compressString("aabcccccaaa"));
		System.out.println("Compressed string for abc: " + compressString("abc"));
	}

	/*
	 * Algorithm: Scan through the keeping track of previous character and counts.
	 * Use StringBuffer for improved performance, otherwise String concatenation would an
	 * expensive operation (O(n*2)).
	 */
	private static String compressString(String str) {
		
		if(str.length() < countCompressedString(str)) {
			return str;
		}
		
		StringBuffer compressedString = new StringBuffer();
		
		char prevChar = str.charAt(0);
		int charCount = 1;
		compressedString.append(prevChar);
		
		for(int i = 1; i < str.length(); i++) {
			char chr = str.charAt(i);
			
			if(prevChar == chr) {
				charCount++;
			} else {
				compressedString.append(charCount);
				compressedString.append(chr);
				charCount = 1;
				prevChar = chr;
			}
		}
		
		compressedString.append(charCount);
		
		return compressedString.toString();
	}
	
	/*
	 * Count the size of the compressed string vs prgional string.
	 */
	private static int countCompressedString(String str) {
		if(str == null || str.isEmpty()) return 0;
		
		char prevChar = str.charAt(0);
		int size = 0;
		int count = 1;
		
		for(int i = 1; i < str.length(); i++) {
			if(str.charAt(i) == prevChar) {
				count++;
			} else {
				prevChar = str.charAt(i);
				size += 1 + String.valueOf(count).length();
				count = 1;
			}
		}
		
		size += 1 + String.valueOf(count).length();
		return size;
	}

}
