package tree.leetcode;

import tree.leetcode.BinaryTreeInorderTraversalN94.TreeNode;

public class HouseRobber3N337 {

    public int rob(TreeNode root) {
    	int[] rootVals = dfs(root);
    	return Math.max(rootVals[0], rootVals[1]);
    }
    
    public int[] dfs(TreeNode node) {
    	if(node == null)
    		return new int[] {0,0};
    	int[] left = dfs(node.left);
    	int[] right = dfs(node.right);
    	
    	return new int[] {node.val+left[1]+right[1],
    			Math.max(
    					Math.max(left[0],left[1]), 
    					Math.max(right[0],right[1])
    					)};
    }
    

}
