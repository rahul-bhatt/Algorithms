package binarytrees;

import binarytrees.SerializeTree.TreeNode;

/**
 * @author rahulbhatt
 * Finding an element in a BST.
 * Time complexity: O(n), worst case if BST is skewed
 * Space complexity: O(1)
 */

public class FindBST {
    BSTNode root;
    
    public BSTNode find(int data) {
        if(root == null) return null;
        
        while(root != null) {
            if(data < root.getData()) {
                root = root.getLeft();
            } else if(data > root.getData()) {
                root = root.getRight();
            } else {
                return root;
            }
        }
        
        return null;
    }
    
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
    	FindBST tree = new FindBST();
    	
    	tree.createTree();
        
        BSTNode node = tree.find(20);
        if(node == null) {
            System.out.println("20 not found in tree");    
        } else {
            System.out.println("20 found in tree");
        }
        
        node = tree.find(9);
           if(node == null) {
            System.out.println("9 not found in tree");    
        } else {
            System.out.println("9 found in tree");
        }
        
        node = tree.find(13);
        if(node == null) {
            System.out.println("13 not found in tree");    
        } else {
            System.out.println("13 found in tree");
        }
    }
    
    class BSTNode {
        private int data;
        private BSTNode left;
        private BSTNode right;
        
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

