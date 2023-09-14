package tree.leetcode;

import java.util.ArrayList;
import java.util.List;

import tree.leetcode.BinaryTreeInorderTraversalN94.TreeNode;

public class CheckCompletenessOfABinaryTreeN958 {

	
    public boolean isCompleteTree(TreeNode root) {
    	int treeDepth = getTreeDepth(root);
    	if(treeDepth == 1)
    		return true;
    	List<List<Integer>> levels = new ArrayList<>();
    	postOrderTraversal(root,levels,treeDepth-1,0);
    	for(int i = 0; i < levels.size() - 1; i++) {
    		if(levels.get(i).size() != Math.pow(2, i))
    			return false;
    	}
    	List<Integer> lastLevel = levels.get(levels.size()-1);
    	int lastValueIndex = 0;
    	int firstNullIndex = -1;
    	for(int i = 0; i<lastLevel.size(); i++) {
    		if(lastLevel.get(i) == -1 && firstNullIndex == -1)
    			firstNullIndex = i;
    		else if(lastLevel.get(i) >=1)
    			lastValueIndex = i;
    	}
    	
    	if(lastValueIndex > firstNullIndex)
    		return false;
    	return true;
    
    }
    
    public int getTreeDepth(TreeNode node) {
    	if(node == null)
    		return 0;
    	return Math.max(getTreeDepth(node.left), getTreeDepth(node.right)) + 1;
    }
    
    public void postOrderTraversal(TreeNode node, List<List<Integer>> levels, int treeDepth,int level) {
    	if(node == null) {
    		if(level != treeDepth)
    			return;
    		else {
    			if(levels.size() == level)
    				levels.add(new ArrayList<>());
    			levels.get(level).add(-1);
    			return;
    		}
    	}
    	if(levels.size() == level)
    		levels.add(new ArrayList<>());
    	levels.get(level).add(node.val);
    	postOrderTraversal(node.left, levels,treeDepth,level+1);
    	postOrderTraversal(node.right, levels,treeDepth,level+1);
    	
    }
    
    
    
    
    
    
    
}
