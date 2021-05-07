package binarytrees;

/**
Generic Tree (n-array tree)

Generic trees are also called "first child next sibling" because of the way 
they are stored/represented.

         1
       /   
      2 -> 3 -> 4 -> 5 -> 6
                    /    /
                   7    8

 * @author rahulbhatt
 *
 */
public class GenericTree {
    TreeNode root;
    
    public GenericTree(TreeNode root) {
        this.root = root;
    }
    
    public void traverseUsingRecursion(TreeNode root) {
        if(root == null) return;
        
        System.out.println(root.getData());
        if(root.getFirstChild() != null) traverseUsingRecursion(root.getFirstChild());
        if(root.getSibling() != null) traverseUsingRecursion(root.getSibling());
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode firstChild = new TreeNode(2);
        root.setFirstChild(firstChild);
        TreeNode sibling1 = new TreeNode(3);
        firstChild.setSibling(sibling1);
        TreeNode sibling2 = new TreeNode(4);
        sibling1.setSibling(sibling2);
        TreeNode sibling3 = new TreeNode(5);
        sibling2.setSibling(sibling3);
        sibling1.setFirstChild(new TreeNode(6));
        
        TreeNode firstChild1 = new TreeNode(7);
        sibling3.setFirstChild(firstChild1);
        firstChild1.setSibling(new TreeNode(8));
        
        GenericTree tree = new GenericTree(root);
        tree.traverseUsingRecursion(root);
    }
}

class TreeNode {
    int data;
    TreeNode firstChild;
    TreeNode nextSibling;
    
    public TreeNode(int data) {
        this.data = data;
        firstChild = null;
        nextSibling = null;
    }
    
    public int getData() {
        return data;
    }
    
    public void setData(int data) {
        this.data = data;
    }
    
    public TreeNode getFirstChild() {
        return firstChild;
    }
    
    public void setFirstChild(TreeNode firstChild) {
        this.firstChild = firstChild;
    }
        
    public TreeNode getSibling() {
        return nextSibling;
    }
    
    public void setSibling(TreeNode sibling) {
        this.nextSibling = sibling;
    }
}
