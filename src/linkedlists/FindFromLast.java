/**
 * 
 */
package linkedlists;

/**
 * Implement an algorithm to find the kth to the last element
 * of a singly linked list.
 * 
 * @author Rahul
 */
public class FindFromLast {

	public static void main(String[] args) {
		Node n = new Node(1);
		Node head = n;
		n.appendTotail(2);
		n.appendTotail(1);
		n.appendTotail(3);
		n.appendTotail(9);
		
		findFromLast(2).getData();
	}
	
	private static Node findFromLast(int k) {
		
		for(int i = 0; i < k; i++) {
			
		}
		
		return null;
	}
}
