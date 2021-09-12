package binarytrees;

import java.util.Stack;

import binarytrees.PostOrder.BinaryTreeNode;

/**
 * @author rahulbhatt
 *
 */
//Binary tree - pre order traversal (D, L, R)

/*
      1
    /   \
   2     3
  / \   /  \
 4   5 6    7

Pre order -> 1, 2, 4, 5, 3, 6, 7

 */

public class PreOrder {
	BinaryTreeNode root;

	public BinaryTreeNode getRoot() {
		return root;
	}

	public void createTree() {
		root = new BinaryTreeNode(1);
		root.setLeftChild(new BinaryTreeNode(2));
		root.setRightChild(new BinaryTreeNode(3));

		root.getRightChild().setLeftChild(new BinaryTreeNode(4));
		root.getRightChild().setRightChild(new BinaryTreeNode(5));

		root.getLeftChild().setLeftChild(new BinaryTreeNode(6));
		root.getLeftChild().setRightChild(new BinaryTreeNode(7));
	}

	public static void main (String[] args) {
		PreOrder tree = new  PreOrder();
		tree.createTree();
		
		BinaryTreeNode rootNode = tree.getRoot();

		System.out.println("Traversing in-order would result in this sequence:");
		tree.preOrderUsingRecursion(rootNode);
		tree.preOrderUsingStack(rootNode);
	}

	// Method 1 - Using Recursion

	void preOrderUsingRecursion(BinaryTreeNode root) {
		if(root != null) {
			System.out.println(root.getData());
			preOrderUsingRecursion(root.getLeftChild());
			preOrderUsingRecursion(root.getRightChild());
		}
	}

	// Method 2 - Using Stack

	void preOrderUsingStack(BinaryTreeNode root) {
		if(root == null) return;

		Stack<BinaryTreeNode> s = new Stack<>();

		s.push(root.getRightChild());
		s.push(root.getLeftChild());

		System.out.println(root.getData());

		while(!s.isEmpty()) {
			root = s.pop();
			System.out.println(root.getData());
			if(root.getRightChild() != null) s.push(root.getRightChild());
			if(root.getLeftChild() != null) s.push(root.getLeftChild());
		}
	}
	
	class BinaryTreeNode {
		private int data;
		BinaryTreeNode left;
		BinaryTreeNode right;

		public BinaryTreeNode(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public BinaryTreeNode getLeftChild() {
			return left;
		}

		public void setLeftChild(BinaryTreeNode node) {
			this.left = node;
		}

		public BinaryTreeNode getRightChild() {
			return right;
		}

		public void setRightChild(BinaryTreeNode node) {
			this.right = node;
		}
	}
}

