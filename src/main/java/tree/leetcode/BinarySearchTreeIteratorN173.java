package tree.leetcode;

import java.util.ArrayList;
import java.util.List;

import tree.leetcode.BinaryTreeInorderTraversalN94.TreeNode;

public class BinarySearchTreeIteratorN173 {

	
	class BSTIterator {
		List<Integer> vals = new ArrayList<>();
		int current = 0;
		
	    public BSTIterator(TreeNode root) {
	        dfs(root, vals);
	    }
	    public void dfs(TreeNode node, List<Integer> vals) {
	    	if(node == null)
	    		return;
	    	dfs(node.left,vals);
	    	vals.add(node.val);
	    	dfs(node.right,vals);
	    }
	    
	    public int next() {
	        return vals.get(++current);
	    }
	    
	    public boolean hasNext() {
	        if(current == vals.size())
	        	return false;
	        return true;
	    }
	}

}
