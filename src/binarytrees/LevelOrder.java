package binarytrees;

import java.util.LinkedList;
import java.util.Queue;

import binarytrees.InsertBST.BSTNode;

/**
 * 
 * Time complexity - O(v + e), number of vertices and edges
 * Space complexity - O(v)
 * @author rahulbhatt
 *
 */
public class LevelOrder {
    BinaryTreeNode root;

    
	public BinaryTreeNode getRoot() {
		return root;
	}

	public void createTree() {
		root = new BinaryTreeNode(1);
		root.setLeftChild(new BinaryTreeNode(2));
		root.setRightChild(new BinaryTreeNode(3));
		
		root.getRightChild().setLeftChild(new BinaryTreeNode(4));
		root.getRightChild().setRightChild(new BinaryTreeNode(5));
		
		root.getLeftChild().setLeftChild(new BinaryTreeNode(6));
		root.getLeftChild().setRightChild(new BinaryTreeNode(7));
	}
	
    public static void main(String[] args) {

      LevelOrder tree = new LevelOrder();
      tree.createTree();

      BinaryTreeNode rootNode = tree.getRoot();
      tree.levelOrderUsingQueue(rootNode);
    }

    public void levelOrderUsingQueue(BinaryTreeNode root) {
      if(root == null) return;
      Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
      System.out.println(root.getData());

      while(true) {
          if(root.getLeftChild() != null) q.add(root.getLeftChild());
          if(root.getRightChild() != null) q.add(root.getRightChild());

          BinaryTreeNode head = q.poll();
          if(head == null) {
            return;
          } else {
            System.out.println(head.getData());
            root = head;
          }
      }
    }
    
    class BinaryTreeNode {
    	  int data;
    	  BinaryTreeNode left;
    	  BinaryTreeNode right;

    	  public BinaryTreeNode(int data) {
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
}

