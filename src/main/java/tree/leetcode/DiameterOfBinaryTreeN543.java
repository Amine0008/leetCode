package tree.leetcode;


import tree.leetcode.BinaryTreeInorderTraversalN94.TreeNode;

public class DiameterOfBinaryTreeN543 {
    public int diameterOfBinaryTree(TreeNode root) {
    	int[] diameter = new int[1];
    	findTreeDepth(diameter, root);
    	return diameter[0];
    }
    public int findTreeDepth(int[] currentMaxSum , TreeNode node) {
    	if(node == null)
    		return 0;
    	int lstd = findTreeDepth(currentMaxSum, node.left);
    	int rstd = findTreeDepth(currentMaxSum, node.right);
    	if(lstd + rstd > currentMaxSum[0])
    		currentMaxSum[0] = lstd + rstd;
    	return Math.max(lstd, rstd) + 1;
    }
    
}
