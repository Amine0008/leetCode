package tree.leetcode;

import tree.leetcode.BinaryTreeInorderTraversalN94.TreeNode;

public class SubtreeOfAnotherTreeN572 {

	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
		int sum = findSumOfLeftAndRight(subRoot, subRoot);
		if(findDepth(sum, root, subRoot) < 0)
			return true;
		return false;
					
		
	}
	public int findDepth(int sum, TreeNode node, TreeNode subRoot) {
		if(node == null)
			return 0;
		int dlt = findDepth(sum, node.left, subRoot);
		if(dlt == -1)
			return -1;
		int drt = findDepth(sum, node.right, subRoot);
		if(drt == -1)
			return -1;
		if(dlt+drt == sum && isSameTree(node, subRoot))
			return -1;
		return Math.max(dlt, drt) + 1;
			
	}
	public int findSumOfLeftAndRight(TreeNode root, TreeNode node) {
		if(node == null)
			return 0;
		int dlt = findSumOfLeftAndRight(root, node.left);
		int drt = findSumOfLeftAndRight(root, node.right);
		if(node == root)
			return dlt + drt;
		return Math.max(dlt, drt) + 1;
	}
	
	public boolean isSameTree(TreeNode nodeA, TreeNode nodeB) {
		if(nodeA == null && nodeB == null)
			return true;
		if(nodeA == null || nodeB == null)
			return false;
		if(nodeA.val != nodeB.val)
			return false;
		return isSameTree(nodeA.left, nodeB.left) && isSameTree(nodeA.right, nodeB.right);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
