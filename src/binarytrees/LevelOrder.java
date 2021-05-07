package binarytrees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author rahulbhatt
 *
 */
public class LevelOrder {
    BinaryTreeNode root;

    public LevelOrder(BinaryTreeNode root) {
      this.root = root;
    }

    public static void main(String[] args) {
      BinaryTreeNode rootNode = new BinaryTreeNode(1);

      rootNode.setLeftChild(new BinaryTreeNode(2));
      rootNode.setRightChild(new BinaryTreeNode(3));

      BinaryTreeNode leftNode = rootNode.getLeftChild();
      BinaryTreeNode rightNode = rootNode.getRightChild();

      leftNode.setLeftChild(new BinaryTreeNode(4));
      leftNode.setRightChild(new BinaryTreeNode(5));

      rightNode.setLeftChild(new BinaryTreeNode(6));
      rightNode.setRightChild(new BinaryTreeNode(7));

      LevelOrder tree = new LevelOrder(rootNode);

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
