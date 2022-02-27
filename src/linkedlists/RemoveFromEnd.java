package linkedlists;

/**
 * 
 * Remove nth node from the end of a linked list.
 * 1 <= n <= length of the list
 * 
 * @author rahulbhatt
 *
 */
public class RemoveFromEnd {

	public static void main(String[] args) {

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		removeNthFromEnd(head, 2);
		
		ListNode node = head;
		while(node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}
	
	//Time: O(n), Sapce: O(1)
	//where n is the size of the linked list
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //Use a dummy node to deal with corner cases
    	ListNode start = new ListNode(0);
        
        start.next = head;
        ListNode slow = start;
        ListNode fast = start;
        
        for(int i = n; i >= 0; i--) {
            if(fast != null) fast = fast.next;
        }
        
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return start.next;
    }
    
    static class ListNode {
    	int val;
    	ListNode next;
    	ListNode(){};
    	
    	ListNode(int val) {
    		this.val = val;    	}
    }

}
