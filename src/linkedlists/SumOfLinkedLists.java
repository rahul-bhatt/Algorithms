package linkedlists;

/**
 * You are given two Linked Lists of potentially unequal lengths.
 * Each Linked List represents a non-negative integer, where each node in
 * the Linked List is a digit of that integer, and the first node in
 * each Linked List always represents the least significant digit of the
 * integer. Write a function that returns the head of a new Linked List
 * that represents the sum of the integers represented by the two
 * input Linked Lists.
 * 
 * Each LinkedList node has an integer value as well as a next node pointing 
 * to the next node in the list or to null, if it's the tail of the list. 
 * The value of each LinkedList node is always in the range of 0 - 9.
 * 
 * Time complexity - O(max(m, n)), m and n is the length of the first and second imput linked list respectivley.
 * Space complexity - O(max(m, n))
 *
 * @author rahulbhatt
 *
 */
public class SumOfLinkedLists {
	public static class LinkedList {
		public int value;
		public LinkedList next;

		public LinkedList(int value) {
			this.value = value;
			this.next = null;
		}
	}

	public LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
		LinkedList newLinkedList = null;
		LinkedList head = null;

		int carry = 0;
		while (linkedListOne != null || linkedListTwo != null || carry > 0) {
			int firstDigit = (linkedListOne != null) ? linkedListOne.value : 0;
			int secondDigit = (linkedListTwo != null) ? linkedListTwo.value : 0;

			int sum = firstDigit + secondDigit + carry;
			int newDigit = (sum > 9) ? sum % 10 : sum;
			carry = (sum > 9) ? 1 : 0;

			if (head == null) {
				head = new LinkedList(newDigit);
				newLinkedList = head;
			} else {
				newLinkedList.next = new LinkedList(newDigit);
				newLinkedList = newLinkedList.next;
			}

			if (linkedListOne != null)
				linkedListOne = linkedListOne.next;
			if (linkedListTwo != null)
				linkedListTwo = linkedListTwo.next;
		}

		return head;
	}
}
