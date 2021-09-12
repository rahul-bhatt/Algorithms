package binarytrees;

import binarytrees.FindBST.BSTNode;

/*
    Insert an element in to a BST.
    Search for the element to be inserted and insert at its right location.

    Time complexity: O(n)
    Space complexity: O(1)
 */


public class InsertBST {
	private BSTNode root;

	public void createTree() {
		root = new BSTNode(10);
		root.left = new BSTNode(8);
		root.right = new BSTNode(15);
		root.right.left = new BSTNode(12);
		root.right.right = new BSTNode(20);
		root.left.left = new BSTNode(6);
		root.left.right = new BSTNode(9);
	}
	
	public static void main(String[] args) {

		InsertBST tree = new InsertBST();
		tree.createTree();
		
		System.out.println("BST before insertion");
		tree.printTree(tree.getRoot());
		
		System.out.println("\nAfter inserting 11");
		tree.insert(11);
		tree.printTree(tree.getRoot());
	}

	public BSTNode insert(int data) {
		if(root == null) {
			BSTNode node = new BSTNode(data);
			return node;
		}

		while(root != null && root.getData() != data) {
			if(data < root.getData()) {
				if(root.getLeft() == null) {
					BSTNode node = new BSTNode(data);
					root.setLeft(node);
					return node;
				} else {
					root = root.getLeft();
				}
			} else if(data > root.getData()) {
				if(root.getRight() == null) {
					BSTNode node = new BSTNode(data);
					root.setRight(node);
					return node;
				} else {
					root = root.getRight();
				}
			}
		}
		
		return root;
	}

	public void printTree(BSTNode root) {
		System.out.print(root.getData() + ", ");
		if(root.getLeft() != null) printTree(root.getLeft());
		if(root.getRight() != null) printTree(root.getRight());		
	}
	
	
	
	public BSTNode getRoot() {
		return root;
	}

	class BSTNode {
		int data;
		BSTNode left;
		BSTNode right;

		public BSTNode(int data) {
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

		public BSTNode getLeft() {
			return left;
		}

		public void setLeft(BSTNode left) {
			this.left = left;
		}

		public BSTNode getRight() {
			return right;
		}

		public void setRight(BSTNode right) {
			this.right = right;
		}
	}
}
