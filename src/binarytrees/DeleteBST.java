package binarytrees;

/**
 * @author rahulbhatt
 * Deleting an element in a BST

   Three scenarios:
   1. Node to be deleted is the leaft node: Make the parent pointer pointing to null.
   2. Node to be deleted has one child: Modify the pointer of the parent and child node
   of the current node, remove the current node.
   3. Node to be deleted has two child: Replace the current node with the Max in the left subtree or min in the right subtree and deleting that min/max node.
 */

public class DeleteBST {
	private BSTNode root;

	public DeleteBST(BSTNode root) {
		this.root = root;
	}

	public static void main(String[] args) {
		BSTNode root = new BSTNode(30);
		root.setRight(new BSTNode(35));
		root.setLeft(new BSTNode(15));
		
		BSTNode left = root.getLeft();
		BSTNode right = root.getRight();
		
		left.setLeft(new BSTNode(10));
		
		right.setRight(new BSTNode(40));
		right.getRight().setRight(new BSTNode(42));
		right.getRight().setLeft(new BSTNode(38));
		right.getRight().getLeft().setRight(new BSTNode(39));
		right.getRight().getLeft().setLeft(new BSTNode(37));

		DeleteBST tree = new DeleteBST(root);

		System.out.println("Tree before deletion: ");
		tree.printTree(root);
		System.out.println();

		root = tree.delete(root, 38);

		System.out.println("Tree after deletion: ");
		tree.printTree(root);
	}

	public void printTree(BSTNode root) {
		System.out.print(root.getData() + ", ");
		if(root.getLeft() != null) printTree(root.getLeft());
		if(root.getRight() != null) printTree(root.getRight());		
	}

	public BSTNode delete(BSTNode root, int data) {
		BSTNode temp = null;

		if(root == null) return null;

		if(data < root.getData()) {
			root.setLeft(delete(root.getLeft(), data));
		} else if(data > root.getData()) {
			root.setRight(delete(root.getRight(), data));
		} else {
			if(root.getLeft() != null && root.getRight() != null) {
				//Replace with largest in left subtree
				temp = findMax(root.getLeft());
				root.setData(temp.getData());
				root.setLeft(delete(root.getLeft(), root.getData()));
			} else {
				//One child
				temp = root;
				if(root.getLeft() == null) {
					root = root.getRight();
				} else if(root.getRight() == null) {
					root = root.getLeft();
				}
				
				temp = null;
			}
		}

		return root;
	}

	private BSTNode findMax(BSTNode root) {
		while(root != null) {
			if(root.getRight() != null) {
				root = root.getRight();
			} else {
				break;
			}
		}

		return root;
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
