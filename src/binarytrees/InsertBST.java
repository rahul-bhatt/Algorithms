package binarytrees;

/*
    Insert an element in to a BST.
    Search for the element to be inserted and insert at its right location.

    Time complexity: O(n)
    Space complexity: O(1)
 */


public class InsertBST {
	private BSTNode root;

	public InsertBST(BSTNode root) {
		this.root = root;
	}

	public static void main(String[] args) {
		BSTNode root = new BSTNode(10);
		root.setRight(new BSTNode(15));
		root.setLeft(new BSTNode(8));

		BSTNode left = root.getLeft();
		BSTNode right = root.getRight();

		left.setRight(new BSTNode(9));
		left.setLeft(new BSTNode(6));

		right.setRight(new BSTNode(20));
		right.setLeft(new BSTNode(12));

		InsertBST tree = new InsertBST(root);
		System.out.println("BST before insertion");
		tree.printTree(root);
		System.out.println("\nAfter inserting 11");
		tree.insert(root, 11);
		tree.printTree(root);
	}

	public BSTNode insert(BSTNode root, int data) {
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