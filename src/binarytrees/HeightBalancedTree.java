package binarytrees;

/**
 * Write a program to determine if a given tree is height balanced.
 * A tree is said to be hight balanced if the difference between the height of
 * the left subtree and riht subtree is at most 1.
 * 
 * Solution: A tree at a given node is height balanced if the left subtree and right tree
 * are height balanced.
 * A node with no chid is always height balanced.
 * 
 * We can traverse the tree in depth first search way and while traversing
 * in a recursive way determine if the tree at a node is height balanced or not
 * starting from leaf nodes.
 * 
 * Time complexity: O(n)
 * Space complexity: O(h), height of the tree
 * 
 * In the worst case wherein the tree is skewed the space complexity would be O(n). However, average case would
 * be O(h).
 * 
 * @author rahulbhatt
 *
 */
public class HeightBalancedTree {
	public Node tree;
	
	static class Node {
		public Node left = null;
		public Node right = null;
		public int value;
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	// utility function to create tree for testing
	public void createTree() {
		tree = new Node(1);
		tree.left = new Node(2);
		tree.right = new Node(3);
		tree.left.left = new Node(4);
		tree.left.right = new Node(5);
		tree.left.right.left = new Node(7);
		tree.left.right.right = new Node(8);
		tree.right.right = new Node(6);
		tree.right.right.left = new Node(9);
		tree.right.right.right = new Node(10);
	}
	
	public static void main(String[] args) {
		HeightBalancedTree tree = new HeightBalancedTree();
		tree.createTree();
		
		System.out.println(tree.isHeightBalanced(tree.tree));
	}
	
	public boolean isHeightBalanced(Node tree) {
		return getTreeInfo(tree).balanced;
	}
	
	public TreeInfo getTreeInfo(Node tree) {	
		if(tree == null || (tree.left == null && tree.right == null)) {
			return new TreeInfo(0, true);
		}
		
		TreeInfo leftTreeInfo = getTreeInfo(tree.left);
		TreeInfo rightTreeInfo = getTreeInfo(tree.right);
		
		int leftTreeHeight = (tree.left == null) ? leftTreeInfo.height : leftTreeInfo.height + 1;
		int rightTreeHeight = (tree.right == null) ? rightTreeInfo.height : rightTreeInfo.height + 1;
		
		boolean balanced = false;
		if(Math.abs(leftTreeHeight - rightTreeHeight) < 2 && leftTreeInfo.balanced && rightTreeInfo.balanced) {
			balanced = true;
		}
		
		int height = Math.max(leftTreeHeight, rightTreeHeight);
		
		return new TreeInfo(height, balanced);
	}
	
	static class TreeInfo {
		boolean balanced;
		int height;
		
		public TreeInfo(int height, boolean balanced) {
			this.height = height;
			this.balanced = balanced;
		}
	}
}
