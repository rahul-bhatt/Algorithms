
package math;

import java.util.HashMap;
import java.util.Map;

/**
 * Roman numerals are usually written largest to smallest from left to right. 
 * However, the numeral for four is not IIII. Instead, the number four is written as IV. 
 * Because the one is before the five we subtract it making four. 
 * The same principle applies to the number nine, which is written as IX. 
 * There are six instances where subtraction is used:
		I can be placed before V (5) and X (10) to make 4 and 9. 
		X can be placed before L (50) and C (100) to make 40 and 90. 
		C can be placed before D (500) and M (1000) to make 400 and 900.
		
 * Given a roman numeral, convert it to an integer.
 * 
 * @author rahulbhatt
 *
 */
public class RomanToInteger {

	static Map<Character, Integer> romanMap = new HashMap<Character, Integer>();
	
	public static void main(String[] args) {
		System.out.println("MCMXCIV: " + romanToInt("MCMXCIV"));
	}
	
	//Time: O(n), Space: O(1)
    public static int romanToInt(String s) {
        createRomanMap();
        int number = 0;
        
        for(int i = 0; i < s.length(); i++) {
            
            if(s.length() > i + 1 && romanMap.get(s.charAt(i)) < romanMap.get(s.charAt(i + 1))) {
                number += romanMap.get(s.charAt(i + 1)) - romanMap.get(s.charAt(i));
                i++;
            } else {
                number += romanMap.get(s.charAt(i));
            }
        }
        
        return number;
    }
    
    public static void createRomanMap() {
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
    }

}
