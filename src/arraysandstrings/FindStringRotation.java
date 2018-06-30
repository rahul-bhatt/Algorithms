/**
 * 
 */
package datastructures.arraysandstrings;

/**
 * Assume you have a method isSubstring which checks if one word is a substring of another.
 * Given two strings, s1 and s2, write code to check if  s2 is a rotation of s1 using only 
 * one call to isSubstring.
 * 
 * @author Rahul
 *
 */
public class FindStringRotation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}
	
	/**
	 * Find if s1 is a rotation of s2.
	 * 
	 * Rotation of a string is based on the point of rotation. For example:
	 * Given string "waterbottle" and rotation point is first "t", then
	 * 
	 * s2 = xy = waterbottle
	 * x = wat, y = bottle
	 * s1 = bottlewat (String after rotation)
	 * 
	 * Given this, if a string is rotated irrespective of the point of rotation
	 * s1 would always be a substring of s2s2 i.e. xyxy
	 * 
	 * So the solution is simply to find if s1 is a substring of s2s2.
	 */
	public boolean isRotation(String s1, String s2) {
		return isSubString(s1, s2 + s2);
	}
	
	public boolean isSubString(String s1, String s2) {
		// Given function.
		// return statement for the sake of compilation.
		return true;
	}

}
