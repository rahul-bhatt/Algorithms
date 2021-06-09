package binarytrees;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/*
	Solution: To serialize traverse the tree in pre-order fashion and 
	construct the encode sequence, 
	use '#' to denote NULL nodes and ','
	as separator to denote node values.
	
	For de-serialize, use the similar approach and construct the tree.
	We can do it recursively or using Stack.
	 
*/

public class SerializeTree {
	TreeNode root;
	StringBuffer code = new StringBuffer();
	
	public static void main(String[] args) {
		SerializeTree tree = new SerializeTree();
		tree.createTree();
		
		String code = tree.serialize(tree.root);
		
		System.out.println(code);
		
		TreeNode node = tree.deserialize(code);
		
		tree.printTree(node);
	}
	
	void printTree(TreeNode node) {
		System.out.print(node.val + ", ");
		if(node.left != null) printTree(node.left);
		if(node.right != null) printTree(node.right);
	}
	
	public void createTree() {
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(-15);
	}
	
	public String serialize(TreeNode root) {
		if(root == null) {
			code.append("#,");
		} else {
			code.append(root.val + ",");
			serialize(root.left);
			serialize(root.right);
		}
		
		return code.toString();
	}
	
	public TreeNode deserialize(String code) {			
		String[] arr = code.split(",");
		List<String> list = Arrays.asList(arr);
		Iterator<String> it = list.iterator();
		return deserializeRecursive(it);
	}
	
	public TreeNode deserializeRecursive(Iterator it) {
		TreeNode root = null;
		if(!it.hasNext()) {
			return null;
		} else {
			String s = (String) it.next();
			
			if(s.equals("#")) {
				return null;
			} else {
				root = new TreeNode(Integer.parseInt(s));
				root.left = deserializeRecursive(it);
				root.right = deserializeRecursive(it);
			}
		}
		
		return root;
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
