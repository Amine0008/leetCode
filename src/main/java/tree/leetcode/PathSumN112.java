package tree.leetcode;

import tree.leetcode.BinaryTreeInorderTraversalN94.TreeNode;

public class PathSumN112 {
	
	public static void main(String [] args) {
		TreeNode n2 = new TreeNode(-2);
		n2.left = new TreeNode(-3);
		System.out.print(hasPathSum(n2,-5));
	}
    
	public static boolean hasPathSum(TreeNode root, int targetSum) {
		return hasPathSum2(root, targetSum, 0);
	}
	
	public static boolean hasPathSum2(TreeNode node, int targetSum, int currentVal) {
		if(node == null)
			return false;
		if(node.val + currentVal == targetSum && node.left == null && node.right == null)
			return true;
		return  hasPathSum2(node.left, targetSum, node.val+currentVal) || hasPathSum2(node.right, targetSum, node.val + currentVal);
		
	}

}
