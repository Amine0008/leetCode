package tree.leetcode;

import java.util.HashMap;
import java.util.Map;

import tree.leetcode.BinaryTreeInorderTraversalN94.TreeNode;

public class FindBottomLeftTreeValueN513 {
	
    public int findBottomLeftValue(TreeNode root) {
    	int[] lastLevel = new int[] {-1};
    	Map<Integer,Integer> firstNodeValueForLastLevelLevel = new HashMap<>();
    	dfs(root, 0, firstNodeValueForLastLevelLevel, lastLevel);
    	return firstNodeValueForLastLevelLevel.get(lastLevel[0]);
    }
    
    public void dfs(TreeNode node, int level, Map<Integer,Integer>  firstNodeValueForLastLevelLevel, int[] lastLevel) {
    	if(node == null)
    		return;
    	if(lastLevel[0] < level) {
    		firstNodeValueForLastLevelLevel.clear();
    		firstNodeValueForLastLevelLevel.put(level, node.val);
    		lastLevel[0] = level;
    	}
    	dfs(node.left, level+1,firstNodeValueForLastLevelLevel, lastLevel);
    	dfs(node.right, level+1,firstNodeValueForLastLevelLevel, lastLevel);
    }
    
}
