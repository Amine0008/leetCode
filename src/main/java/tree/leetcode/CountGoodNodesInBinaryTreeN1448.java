package tree.leetcode;

import tree.leetcode.BinaryTreeInorderTraversalN94.TreeNode;

public class CountGoodNodesInBinaryTreeN1448 {
    
	public int goodNodes(TreeNode root) {
        return isGoodNode(root,Integer.MIN_VALUE);
    }
	
	public int isGoodNode(TreeNode node, int currentMax) {
		if(node == null )
			return 0;
		int x = node.val >= currentMax ? 1 : 0;
		return x + 
				isGoodNode(node.left,Math.max(currentMax, node.val))+
				isGoodNode(node.right,Math.max(currentMax, node.val));
	}
}
