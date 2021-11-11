package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a stringified phone number of any non-zero length,
 * write a function that returns all mnemonics for this phone number, in any order.
 * 
 * Time complexity - O(4^n * n)
 * Space complexity - O(4^n * n)
 * 
 * @author rahulbhatt
 *
 */

public class PhoneNumberMnemonic {

	public static Map<Character, String[]> DIGIT_LETTERS = new HashMap<Character, String[]>();
	
	static {
		DIGIT_LETTERS.put('0', new String[] {"0"});
		DIGIT_LETTERS.put('1', new String[] {"1"});
		DIGIT_LETTERS.put('2', new String[] {"a","b","c"});
		DIGIT_LETTERS.put('3', new String[] {"d","e","f"});
		DIGIT_LETTERS.put('4', new String[] {"g","h","i"});
		DIGIT_LETTERS.put('5', new String[] {"j","k","l"});
		DIGIT_LETTERS.put('6', new String[] {"m","n","o"});
		DIGIT_LETTERS.put('7', new String[] {"p","q","r","s"});
		DIGIT_LETTERS.put('8', new String[] {"t","u","v"});
		DIGIT_LETTERS.put('9', new String[] {"w","x","y","z"});
	}
	
	public static ArrayList<String> phoneNumberMnemonics(String phoneNumber) {
		String[] currentMnemonic = new String[phoneNumber.length()];
		Arrays.fill(currentMnemonic, "0");
		
		ArrayList<String> mnemonicsFound = new ArrayList<String>();
		phoneNumberMnemonicsHelper(0, phoneNumber, currentMnemonic, mnemonicsFound);
		
		return mnemonicsFound;
	}
	
	private static void phoneNumberMnemonicsHelper(int idx, String phoneNumber, String[] currentMnemonic, ArrayList<String> mnemonicsFound) {
		if(idx == phoneNumber.length()) {
			String mnemonic = String.join("", currentMnemonic);
			mnemonicsFound.add(mnemonic);
		} else {
			char digit = phoneNumber.charAt(idx);
			String[] letters = DIGIT_LETTERS.get(digit);
			
			for(String letter : letters) {
				currentMnemonic[idx] = letter;
				phoneNumberMnemonicsHelper(idx + 1, phoneNumber, currentMnemonic, mnemonicsFound);
			}
		}
	}
	
	public static void main(String[] args) {
		ArrayList<String> mnemonics = PhoneNumberMnemonic.phoneNumberMnemonics("1905");
		
		for(String mnemonic : mnemonics) {
			System.out.println(mnemonic);
		}
	}
}
