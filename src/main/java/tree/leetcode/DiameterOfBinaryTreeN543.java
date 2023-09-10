package tree.leetcode;

import java.util.concurrent.atomic.AtomicInteger;

import tree.leetcode.BinaryTreeInorderTraversalN94.TreeNode;

public class DiameterOfBinaryTreeN543 {
	
    public int diameterOfBinaryTree(TreeNode root) {
    	AtomicInteger diameter = new AtomicInteger(0);
    	findTreeDepth(diameter, root);
    	return diameter.intValue();
    }
    public int findTreeDepth(AtomicInteger currentMaxSum , TreeNode node) {
    	if(node == null)
    		return 0;
    	int lstd = findTreeDepth(currentMaxSum, node.left);
    	int rstd = findTreeDepth(currentMaxSum, node.right);
    	if(lstd + rstd > currentMaxSum.intValue())
    		currentMaxSum .set(lstd + rstd);
    	return Math.max(lstd, rstd) + 1;
    }
}
