package binarytrees;

/**
 * @author rahulbhatt
 * Finding an element in a BST.
 * Time complexity: O(n), worst case if BST is skewed
 * Space complexity: O(1)
 */

public class FindBST {
    BSTNode root;
    
    public FindBST(BSTNode root) {
        this.root = root;
    }
    
    public BSTNode find(BSTNode root, int data) {
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
        
        FindBST tree = new FindBST(root);
        
        BSTNode node = tree.find(root, 20);
        if(node == null) {
            System.out.println("20 not found in tree");    
        } else {
            System.out.println("20 found in tree");
        }
        
        node = tree.find(root, 9);
           if(node == null) {
            System.out.println("9 not found in tree");    
        } else {
            System.out.println("9 found in tree");
        }
        
        node = tree.find(root, 13);
        if(node == null) {
            System.out.println("13 not found in tree");    
        } else {
            System.out.println("13 found in tree");
        }
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
