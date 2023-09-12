package tree.leetcode;

import tree.leetcode.BinaryTreeInorderTraversalN94.TreeNode;

public class InsertIntoABinarySearchTreeN701 {
    
	public TreeNode insertIntoBST(TreeNode root, int val) {
		if(root == null)
			return new TreeNode(val);
		if(val>root.val)
			root.right = insertIntoBST(root.right,val);
		else
			root.left = insertIntoBST(root.left,val);
		return root;
	}
	
}
