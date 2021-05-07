package binarytrees;

import java.util.Stack;

public class InOrder {
  BinaryTreeNode root;

  public InOrder(BinaryTreeNode root) {
    this.root = root;
  }

  public static void main(String[] args) {
    BinaryTreeNode rootNode = new BinaryTreeNode(1);
    InOrder tree = new  InOrder(rootNode);

    rootNode.setLeftChild(new BinaryTreeNode(2));
    rootNode.setRightChild(new BinaryTreeNode(3));

    BinaryTreeNode leftNode = rootNode.getLeftChild();
    BinaryTreeNode rightNode = rootNode.getRightChild();

    leftNode.setLeftChild(new BinaryTreeNode(4));
    leftNode.setRightChild(new BinaryTreeNode(5));

    rightNode.setLeftChild(new BinaryTreeNode(6));
    rightNode.setRightChild(new BinaryTreeNode(7));

    System.out.println("Traversing in-order would result in this sequence:");
    tree.inOrderUsingRecursion(rootNode);
    tree.inOrderUsingStack(rootNode);
  }

  // Methos 1: Using Recursion
  void inOrderUsingRecursion(BinaryTreeNode root) {
    if(root != null) {
      inOrderUsingRecursion(root.getLeftChild());
      System.out.println(root.getData());
      inOrderUsingRecursion(root.getRightChild());
    }
  }

  // Method 2: Using Stack
  void inOrderUsingStack(BinaryTreeNode root) {
    if(root == null) return;

    Stack<BinaryTreeNode> s = new Stack<>();

    while(true) {
      while(root != null) {
        s.push(root);
        root = root.getLeftChild();
      }

      if(s.isEmpty()) break;

      root = s.pop();
      System.out.println(root.getData());
      root = root.getRightChild();
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
