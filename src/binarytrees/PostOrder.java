package binarytrees;

import java.util.Stack;

import binarytrees.LevelOrder.BinaryTreeNode;

/**
 * @author rahulbhatt
 *
 */
public class PostOrder {
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

	public static void main(String[] args) {
		PostOrder tree = new  PostOrder();
		tree.createTree();

		BinaryTreeNode rootNode = tree.getRoot();
		
		System.out.println("Traversing post-order would result in this sequence:");
		tree.postOrderUsingRecursion(rootNode);
		tree.postOrderUsingStack(rootNode);
	}

	// Method 1 - Using Recursion

	void postOrderUsingRecursion(BinaryTreeNode root) {
		if(root != null) {
			System.out.println(root.getData());
			postOrderUsingRecursion(root.getLeftChild());
			postOrderUsingRecursion(root.getRightChild());
		}
	}

	// Method 2 - Using Stack

	void postOrderUsingStack(BinaryTreeNode root) {
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
		int data;
		BinaryTreeNode left;
		BinaryTreeNode right;

		public BinaryTreeNode(int data) {
			this.data = data;
			left = null;
			right = null;
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

