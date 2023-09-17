package tree.leetcode;

import tree.leetcode.BinaryTreeInorderTraversalN94.TreeNode;

public class SumRootToLeafNumbersN129 {
    
	public int sumNumbers(TreeNode root) {
		int[] result = new int[] {0};
		dfs(root,0,result);
		return result[0];
    }
	
	public void dfs(TreeNode node, int pathValue, int[] pathsSum ) {
		
		if(node.left == null && node.right == null) {
			pathsSum[0] += pathValue*10+node.val;
			return;
		}
		if(node.left != null)
			dfs(node.left, pathValue*10+node.val,pathsSum);
		
		if(node.right != null)
			dfs(node.right, pathValue*10+node.val,pathsSum);
		
	}

}
