package math;

/**
 * 
 * Given an interger x, return true if it is palindrome.
 * 
 * @author rahulbhatt
 *
 */
public class PalindromeNumber {

	public static void main(String[] args) {
		//System.out.println("is 121 palindrome: " + isPalindrome(121));
		System.out.println("is 1410110141 palindrome: " + isPalindrome(1410110141));
	}

	//Time: O(n), Space: O(1)
	public static boolean isPalindrome(int x) {
		if(x < 0) return false;
		
		long div = 1;
		while(x >= 10 * div) {
			div = div * 10;
		}

		while(x != 0) {
			int right = x % 10;
			int left = (int) (x / div);

			if(left != right) return false;

			x = (int) ((x % div) / 10);
			div = div / 100;
		}

		return true;
	}
}
