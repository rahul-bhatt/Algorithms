package binarytrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Traverse a binary tree in vertical order and print the elements from left to right and from top to bottom.
 * 
 * 		1
 * 	  /   \
 *   2     3
 *  / \   / \
 * 4  5  6   7
 * 
 * 4,
 * 2,
 * 1, 5, 6,
 * 3,
 * 7,
 * 
 * @author rahulbhatt
 *
 */
public class VerticalTraversal {

	public static Node tree;
	public static int minColValue = Integer.MAX_VALUE;
	public static int maxColValue = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		createTree();
		printVertical(tree);
	}

	//Time: O(n) | Space: O(n)
	public static void printVertical(Node head) {
		if(head == null) return;
		
		Map<Integer, List<Node>> map = new HashMap<Integer, List<Node>>();
		verticalTraverse(head, 0, map);
		
		for(int i = minColValue; i <= maxColValue; i++) {
			for(Node node : map.get(i)) {
				System.out.print(node.value);
			}
			System.out.println();
		}

	}
	
	public static void verticalTraverse(Node node, int colValue, Map<Integer, List<Node>> map) {
		if(node == null) return;
		
		if(colValue < minColValue) minColValue = colValue;
		if(colValue > maxColValue) maxColValue = colValue;
		
		map.putIfAbsent(colValue, new ArrayList<Node>());
		map.get(colValue).add(node);
		
		verticalTraverse(node.left, colValue - 1, map);
		verticalTraverse(node.right, colValue + 1, map);
	}

	static class Node {
		public int value;
		public Node left;
		public Node right;
		
		Node(int value) {
			this.value = value;
		}
	}
	
	public static void createTree() {
		tree = new Node(1);
		tree.left = new Node(2);
		tree.right = new Node(3);
		tree.left.left = new Node(4);
		tree.left.right = new Node(5);
		tree.right.left = new Node(6);
		tree.right.right = new Node(7);
	}
}

