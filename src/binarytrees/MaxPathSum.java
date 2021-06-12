package binarytrees;


/*
 To solve this problem, we need to understand that at a particular node, the max path can be
 one of these 4 options:
 	1. Node only
 	2. Node + max path sum in left subtree
 	3. Node + max path sum in right subtree
 	4. Node + max path sum in left subtree + max path sum in right subtree
 	
 For a leaf node with no children, the value of the node itself is the max path.
 
 From above this problem fits well for a recursive approach wherein at each node
 we calculate the max path sum of node only, left subtree, right subtree and 
 then calculate the max path sum at that node.
 
 One important thing we need to take care of in this recursive approach is that while
 calculating max path sum at each node level we need to return the path with at most one
 sub tree (left or right). This is important because while calculating max path sum at the
 parent level we only need max path sum that includes only one children because both the
 path can not be reached from the parent node of the node.
 */

public class MaxPathSum {
	TreeNode root;
	int maxSum = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		MaxPathSum tree = new MaxPathSum();
		tree.createTree();
		tree.maxPathSum(tree.root);
		
		System.out.println("Max path sum: " + tree.maxSum);
	}
	
	public int maxPathSum(TreeNode root) {
		if(root == null) {
			return 0;
		} else {
			int maxLeft = maxPathSum(root.left);
			int maxRight = maxPathSum(root.right);
			
			// Important part of this algorithm: See comments above
			// For max path sum of the parent node only one of the child can be
			// present in the max path
			int maxNode = Math.max(Math.max(maxLeft, maxRight) + root.val, root.val);
			
			// This is max path sum at this node only wherein the current node
			// is at the root level
			int maxPath = Math.max(maxNode, maxLeft + maxRight + root.val);
			
			if(maxPath > maxSum) {
				maxSum = maxPath;
			}
			
			return maxNode;
		}
	}
	
	public void createTree() {
		root = new TreeNode(-10);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
	}
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
			left = null;
			right = null;
		}
	}
}
