/**
 * 
 */
package binarytrees;

/*
Find pre-order successor of a node in a binary tree (not BST, not threaded binary tree)

Sol 1: Travel the tree in a pre-order fashion and find the successor. O(n) time and space complexity.

Sol 2: In the binary tree node representation also store link ot the parent node.
* If there is a left child of the node then left child is the pre-order successor.
* Else will travel to the parent nodes and find the first right child of any ancesstor.
* If we could not find any right child of ancesstor node then there is no pre-order successor of this node.
*/

public class PreOrderSuccessor {
BinaryTreeNode root;

public PreOrderSuccessor(BinaryTreeNode root) {
    this.root = root;
}

public BinaryTreeNode getPreOrderSuccessor(BinaryTreeNode root, BinaryTreeNode node) {
    if(root == null || node == null) return null;
    
    if(node.getLeft() != null) return node.getLeft();
    
    if(node.getParent() == null) return null;
    
    BinaryTreeNode p = node.getParent();
    
    while(p != null) {
        if(p.getRight() != null) {
        		return p.getRight();    
        } else {
        		p = p.getParent();
        }
    }
    
    return null;
}

public static void main(String[] args) {
    BinaryTreeNode root = new BinaryTreeNode(1);
    root.setLeft(new BinaryTreeNode(2));
    root.setRight(new BinaryTreeNode(3));
    
    BinaryTreeNode left = root.getLeft();
    left.setLeft(new BinaryTreeNode(4));
    left.setParent(root);
    left.getLeft().setParent(left);
    
    BinaryTreeNode right = root.getRight();
    right.setParent(root);
    right.setLeft(new BinaryTreeNode(5));
    right.getLeft().setParent(right);
    
    right.setRight(new BinaryTreeNode(6));
    right.getRight().setParent(right);
    
    PreOrderSuccessor tree = new PreOrderSuccessor(root);
    BinaryTreeNode successor = tree.getPreOrderSuccessor(root, left.getLeft());
    
    if(successor == null) {
        System.out.println("No pre-order successor");
    } else {
        System.out.println(successor.getData());
    }
}
}

class BinaryTreeNode {
BinaryTreeNode parent;
BinaryTreeNode left;
BinaryTreeNode right;
int data;

public BinaryTreeNode(int data) {
    this.data = data;
    left = null;
    right = null;
    parent = null;
}

//getters & setters

public int getData() {
    return data;    
}

public void setData(int data) {
    this.data = data;
}

public BinaryTreeNode getParent() {
    return parent;
}

public void setParent(BinaryTreeNode parent) {
    this.parent = parent;
}

public BinaryTreeNode getLeft() {
    return left;
}

public void setLeft(BinaryTreeNode left) {
    this.left = left;
}

public BinaryTreeNode getRight() {
    return right;
}

public void setRight(BinaryTreeNode right) {
    this.right = right;
}
}
