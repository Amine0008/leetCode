package tree.leetcode;

import tree.leetcode.BinaryTreeInorderTraversalN94.TreeNode;

public class MinimumDistanceBetweenBSTNodesN783 {
    public int minDiffInBST(TreeNode root) {
        int[] currentMin = new int[1];
        currentMin[0] = Integer.MAX_VALUE;
        findMinDifferenceWithinSubTrees(root, -1, currentMin);
        return currentMin[0];
        	
        
    }
    
    public void findMinDifferenceWithinSubTrees(TreeNode node, int parentVal, int[] currentMin) {
    	if(node == null)
    		return;
    	findMinDifferenceWithinSubTrees(node.left, node.val, currentMin);
    	if(parentVal != -1 && Math.abs(parentVal-node.val)<currentMin[0])
    		currentMin[0] = Math.abs(parentVal-node.val);
    	findMinDifferenceWithinSubTrees(node.right, node.val, currentMin);
    	if(parentVal != -1 && Math.abs(parentVal-node.val)<currentMin[0])
    		currentMin[0] = Math.abs(parentVal-node.val);
    	if(node.left != null) {
        	int biggestOnTheLeft = 	getBiggestValue(node.left);
        	if(currentMin[0] > node.val - biggestOnTheLeft)
        		currentMin[0] = node.val - biggestOnTheLeft;
        }
        if(node.right != null) {
        	int smallestOnTheRight = getSmallestValue(node.right);
        	if(currentMin[0] > smallestOnTheRight - node.val)
        		currentMin[0] = smallestOnTheRight- node.val;
        }
    
    }
    public int getBiggestValue(TreeNode node) {
    	if(node.right == null)
    		return node.val;
    	return getBiggestValue(node.right);
    }
    public int getSmallestValue(TreeNode node) {
    	if(node.left == null)
    		return node.val;
    	return getSmallestValue(node.left);
    }
}
