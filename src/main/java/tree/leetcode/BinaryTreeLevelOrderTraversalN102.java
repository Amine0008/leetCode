package tree.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import tree.leetcode.BinaryTreeInorderTraversalN94.TreeNode;

public class BinaryTreeLevelOrderTraversalN102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
    	if(root == null)
    		return new ArrayList<>();
    	List<List<Integer>> result = new ArrayList<>();
    	result.add(new ArrayList<>());
    	result.get(0).add(root.val);
    	
    	Queue<TreeNode> q = new LinkedList<>();
    	int previousLevel = 1;
    	int maxNumberOfNodeInLevel = 0;
    	int currentNumberOfNodesInLevel = 0;
    	int nullNodesInNextLevel = 0;
    	if(root.left != null) {
    		q.add(root.left);
    		maxNumberOfNodeInLevel++;
    	}
    	if(root.right != null) {
    		q.add(root.right);
    		maxNumberOfNodeInLevel++;
    	}
    	
    	TreeNode holder = null;
    	while(!q.isEmpty()) {
    		holder = q.remove();
    		if(holder.left != null)
    			q.add(holder.left);
    		else
    			nullNodesInNextLevel++;
    		if(holder.right != null)
    			q.add(holder.right);
    		else 
    			nullNodesInNextLevel++;
    		currentNumberOfNodesInLevel++;	
    		if(holder != null) {
    			if(result.size() == previousLevel)
    				result.add(new ArrayList<>());
    			result.get(previousLevel).add(holder.val);
    		}
    		if(currentNumberOfNodesInLevel == maxNumberOfNodeInLevel) {
    			maxNumberOfNodeInLevel = 2 * maxNumberOfNodeInLevel - nullNodesInNextLevel;
    			previousLevel++;
    			currentNumberOfNodesInLevel = 0;
    			nullNodesInNextLevel = 0;
    		}
    	}
    	return result;
    	
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
    	List<List<Integer>> result = new ArrayList<>();
    	traversing(root, result, 0);
    	return result;
    }
    public void traversing(TreeNode node, List<List<Integer>> result, int level) {
    	if(node == null)
    		return;
    	if(result.size() == level)
    		result.add(new ArrayList<>());
    	result.get(level).add(node.val);
    	traversing(node.left, result, level+1);
    	traversing(node.right, result, level+1);
    	
    }
    
    
}










