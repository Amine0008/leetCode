package tree.leetcode;

import tree.leetcode.BinaryTreeInorderTraversalN94.TreeNode;

public class DeleteNodeInBSTN450 {
	
    public TreeNode deleteNode(TreeNode root, int key) {
    	if(root == null || (root.val == key && root.left == null && root.right == null))
    		return null;
		if(key > root.val)
	    	root.right =  deleteNode(root.right, key);
		
		else if(key < root.val)
			root.left = deleteNode(root.left, key);
		
		else {
			int[] newVal = new int[1];
			if(root.left == null && root.right == null)
				return null;
			else if(root.left != null)
				root.left = deleteBiggestNode(root.left, newVal);
			else if(root.right != null)
				root.right = deleteSmallestNode(root.right, newVal);
			
			root.val = newVal[0];
			}
		System.gc();
		return root;
    }
    
	
	public TreeNode deleteBiggestNode(TreeNode node, int[] newVal) {
		if(node.right == null) {
			newVal[0] = node.val;
			return node.left;
		}
		node.right = deleteBiggestNode(node.right, newVal);
		return node;
	}
	
	public TreeNode deleteSmallestNode(TreeNode node, int[] newVal) {
		if(node.left == null) {
			newVal[0] = node.val;
			return node.right;
		}
		node.left = deleteSmallestNode(node.left, newVal);
		return node;
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
