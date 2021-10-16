/**
 * 
 */
package stack;

import java.util.Stack;

/**
 * Check if a string containing opening and closing brackets (and other optional characters) 
 * are balanced or not.
 * 
 * Time Complexity
 * ---------------
 * O(n)
 * 
 * Space Complexity
 * ----------------
 * O(n)
 * 
 * @author Rahul
 */
public class BalancedBrackets {
	public static void main(String[] args) {
		BalancedBrackets balanced = new BalancedBrackets();
		System.out.println(balanced.isBalanced("([])(){}(())()()"));
	}
	
	public boolean isBalanced(String str) {
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(ch == '(' || ch == '[' || ch == '{') {
				stack.push(ch);
			} else if(ch == ')' || ch == ']' || ch == '}') {
				if(stack.empty()) return false;
				
				char top = stack.pop();
				if((ch == ')' && top != '(') || (ch == ']' && top != '[') || (ch == '}' && top != '{') ) {
					return false;
				}
			}
		}
		
		if(stack.empty()) {
			return true;
		} else {
			return false;
		}
	}
}
