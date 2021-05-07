package binarytrees;

import java.util.Stack;

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

	PreOrder(BinaryTreeNode rootNode) {
		root = rootNode;
	}

	public static void main (String[] args) {
		BinaryTreeNode rootNode = new BinaryTreeNode(1);
		PreOrder tree = new  PreOrder(rootNode);

		rootNode.setLeftChild(new BinaryTreeNode(2));
		rootNode.setRightChild(new BinaryTreeNode(3));

		BinaryTreeNode leftNode = rootNode.getLeftChild();
		BinaryTreeNode rightNode = rootNode.getRightChild();

		leftNode.setLeftChild(new BinaryTreeNode(4));
		leftNode.setRightChild(new BinaryTreeNode(5));

		rightNode.setLeftChild(new BinaryTreeNode(6));
		rightNode.setRightChild(new BinaryTreeNode(7));

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
}

class BinaryTreeNode2 {
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
