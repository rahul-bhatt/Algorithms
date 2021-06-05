package binarytrees;

/*
Create a BST from a given sorted array.

Solution:
1. Get the middle element and make it root node.
2. Recursively do following:
    a. Get the middle element of the left half and make it left child of the root.
    b. Get the middle element of the right half and make it right child of the root.

Time complexity: O(n)
 */

public class BSTFromArray {
	BSTNode root;

	public BSTFromArray() {}

	public BSTFromArray(BSTNode root) {
		this.root = root;
	}

	public void setRoot(BSTNode root) {
		this.root = root;
	}

	public static void main(String[] args) {
		int arr[] = {4,5,7,8,9,10,20};
		BSTFromArray tree = new BSTFromArray();
		BSTNode root = tree.createBST(arr, 0, arr.length - 1);
		tree.setRoot(root);
		tree.printTree(root);
	}

	void printTree(BSTNode root) {
		// InOrder traversal to print the tree in sorted order
		if(root.getLeft() != null) printTree(root.getLeft());
		System.out.print(root.getData() + ", ");
		if(root.getRight() != null) printTree(root.getRight());
	}

	public BSTNode createBST(int[] arr, int beg, int end) {
		int size = end - beg + 1;

		BSTNode root = null;

		if(size == 1) {
			root = new BSTNode(arr[beg]);
		} else {
			int middle = beg + size/2;
			root = new BSTNode(arr[middle]);
			root.setLeft(createBST(arr, beg, middle - 1));
			root.setRight(createBST(arr, middle + 1, end));
		}

		return root;
	}

	class BSTNode {
		int data;
		BSTNode left;
		BSTNode right;

		public BSTNode(int data) {
			this.data = data;
		}

		public int getData() {
			return this.data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public BSTNode getLeft() {
			return this.left;
		}

		public void setLeft(BSTNode left) {
			this.left = left;
		}

		public BSTNode getRight() {
			return this.right;
		}

		public  void setRight(BSTNode right) {
			this.right = right;
		}
	}
}