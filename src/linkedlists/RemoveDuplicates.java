package linkedlists;

import java.util.HashSet;

/**
 * Implement an algorithm to remove duplicates from an unsorted linked list
 * with and without using extra space.
 * 
 * @author Rahul
 */
public class RemoveDuplicates {
	public static void main(String[] args) {
		
		// Create a linked list with some duplicate elements.
		Node n = new Node(1);
		n.appendTotail(2);
		n.appendTotail(1);
		n.appendTotail(3);
		
		//Using Algo 1
		removeDuplicates(n);
		traverseAll(n);
		
		//Using Algo 2
		n.appendTotail(4);
		n.appendTotail(2);
		removeDupes(n);
		System.out.println();
		traverseAll(n);
	}
	
	/*
	 * Algorithm 1: Traverse the linked list and store all unique elements in a set and removing
	 * duplicates when encountered during traversal.
	 * Run Time: O(n)
	 * Space: O(n)
	 */
	private static void removeDuplicates(Node head) {
		if(head == null) return;
		
		Node n = head;
		Node prev = null;
		HashSet<Integer> uniqueSet = new HashSet<Integer>();
		
		while(n.getNextNode() != null) {
			if(uniqueSet.contains(n.getData())) {
				prev.setNextNode(n.getNextNode());
				n = n.getNextNode();
			} else {
				uniqueSet.add(n.getData());
				prev = n;
				n = n.getNextNode();
			}
		}
	}
	
	/*
	 * Algorithm 2: Without using any extra space (HashSet).
	 * For each non null node compare the node with all other node.
	 * Run Time: O(n*2)
	 * Space: O(1) 
	 */
	private static void removeDupes(Node head) {
		if(head == null) return;
		
		Node n = head;
		Node next = null;
		Node prev = null;
		while(n != null) {
			next = n.getNextNode();
			prev = n;
			while(next != null) {
				if(n.getData() == next.getData()) {
					prev.setNextNode(next.getNextNode());
				} else {
					prev = next;
				}
				
				next = next.getNextNode();
			}

			n = n.getNextNode();
		}
	}
	
	// Utility function to print all elements of the list.
	private static void traverseAll(Node head) {
		
		if(head == null) {
			System.out.println("Empty list");
			return;
		}
		
		Node n = head;
		
		do {
			System.out.print(n.getData() + "->");
			n = n.getNextNode();
		} while(n != null);
		
		System.out.print("null");
	}
}

/*
 * Simple linked list implementation.
 */
class Node {
	private Node next = null;
	private int data;
	
	public Node(int data) {
		this.data = data;
	}
	
	public Node getNextNode() {
		return this.next;
	}
	
	public int getData() {
		return this.data;
	}
	
	public void setNextNode(Node n) {
		this.next = n;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public void appendTotail(int d) {
		Node end = new Node(d);
		Node n = this;
		
		while(n.next != null) {
			n = n.next;
		}
		
		n.next = end;
	}
}
