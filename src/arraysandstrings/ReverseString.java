/**
 * 
 */
package arraysandstrings;

/**
 * Implement an algorithm to reverse a String without using any extra space.
 * 
 * Algorithm: We can start with swapping the element at the start and the end and continue the comparison and swap operation
 * till we reach the middle of the string.
 * 
 * For swap operation we can use XOR operator.
 * 
 * x = x ^ y;
 * y = x ^ y;
 * x = x ^ y;
 * 
 * @author Rahul
 *
 */
public class ReverseString {

	public static void main(String[] args) {
		ReverseString str = new ReverseString();
		System.out.println("Reverse of String aba is: " + str.reverseString(new StringBuilder("aba")).toString());
	}
	
	public StringBuilder reverseString(StringBuilder str) {
		int i = 0;
		int j = str.length() - 1;
		
		while (i != j) {

			str.setCharAt(i, (char) (str.charAt(i) ^ str.charAt(j)));
			str.setCharAt(j, (char) (str.charAt(i) ^ str.charAt(j)));
			str.setCharAt(i, (char) (str.charAt(i) ^ str.charAt(j)));
			
			i++;
			j--;
		}
		
		return str;
	}

}
