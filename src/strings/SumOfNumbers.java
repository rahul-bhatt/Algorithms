package strings;

/**
 * @author rahulbhatt
 *
 */
public class SumOfNumbers {

	public static void main(String[] args) {
		System.out.println(sumOfNumbers("123abc1a10"));
	}

	// Time - O(n) | Space - O(n)
	public static int sumOfNumbers(String str) {
		int sum = 0;
		String num = "0";
		
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			
			if(Character.isDigit(ch)) {
				num = num + ch;
			} else {
				sum += Integer.parseInt(num);
				num = "0";
			}
		}
		
		return sum + Integer.parseInt(num);
	}
}
