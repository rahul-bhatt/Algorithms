package binarytrees;

/**
 * @author rahulbhatt
 *
 */
public class IsBST {
	
	BSTNode root;
	BSTNode prev;
	
	public static void main(String[] args) {
		IsBST tree = new IsBST();
		tree.createTree();
		
		System.out.println(tree.isBST(tree.root));
	}
	
	public boolean isBST(BSTNode root) {
		if(root == null) return true;
		
		if(!isBST(root.left)) {
			return false;
		}
		
		if(prev != null && root.data < prev.data) {
			return false;
		}
		
		prev = root;
		
		return isBST(root.right);
	}
	
	public void createTree() {
		root = new BSTNode(10);
		root.left = new BSTNode(5);
		root.left.left = new BSTNode(2);
		root.left.right = new BSTNode(5);
		root.left.left.left = new BSTNode(1);
		root.left.left.left.left = new BSTNode(-5);
		root.left.left.left.left.left = new BSTNode(-15);
		root.left.left.left.left.left.left = new BSTNode(-22);
		
		root.left.left.left.left.right = new BSTNode(-5);
		root.left.left.left.left.right.right = new BSTNode(-2);
		root.left.left.left.left.right.right.right = new BSTNode(-1);
		
		root.right = new BSTNode(15);
		root.right.right = new BSTNode(22);

	}
	
	class BSTNode {
        public int data;
        public BSTNode left;
        public BSTNode right;
        
        BSTNode(int data) {
        	this.data = data;
        }

    }
}
