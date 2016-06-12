/**
 * 
 */
package datastructures.arraysandstrings;

/**
 * Implement an algorithm to replace all spaces in a string with "%20".
 * You may assume that the String has sufficient space at the end of the String to hold the additional
 * characters and that you are given the true length of the String.
 * In Java use a character array to perform the operation in place.
 * 
 * Input: "Mr John Smith      ", 13
 * Output: "Mr%20John%20Smith"
 * 
 * @author Rahul
 *
 */
public class ReplacingSpaces {

	public static void main(String[] args) {
		String str = new String("John Smith      ");
		char[] charArray = str.toCharArray();
		
		replaceSpaces(charArray, 10);
		
		for(int i = 0; charArray[i] != '\0'; i++) {
			System.out.print(charArray[i]);
		}
	}
	
	/* The algorithm works through a two scan approach.
	 * In the first scan, we count how many spaces are there in the string.
	 * This is used to compute how long the final string should be.
	 * In the second pass we actually edit the string.
	 */
	public static void replaceSpaces(char[] charArray, int length) {
		
		int noOfSpaces = 0, newLength = 0;
		
		//First count the number of spaces to calculate final length of the string.
		for(int i = 0; i < length; i++) {
			if(charArray[i] == ' ') noOfSpaces++;
		}
		
		newLength = length + noOfSpaces * 2;
		charArray[newLength] = '\0';
		
		//Move backwards and edit the string so that we don't need to worry about
		//overwriting characters.
		while(length >= 0 && length != newLength) {
			if(charArray[--length] != ' ') {
				charArray[--newLength] = charArray[length];
			} else {
				charArray[--newLength] = '0';
				charArray[--newLength] = '2';
				charArray[--newLength] = '%';
			}
		}
	}
}
