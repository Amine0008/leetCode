package tree.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import tree.leetcode.BinaryTreeInorderTraversalN94.TreeNode;

public class FlipEquivalentBinaryTreesN951 {

	
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null) {
            return root1 == root2;
        }
    	//treeMap maps each node with its level and parent
    	Map<Integer,Integer[]> tree1Map = new HashMap<>();
    	Map<Integer,Integer[]> tree2Map = new HashMap<>();
    	
    	tree1Map.put(root1.val, new Integer[] {0,null});
    	tree2Map.put(root2.val, new Integer[] {0,null});
    	
    	dfs(root1, root1.left, 1, tree1Map);
    	dfs(root1, root1.right, 1, tree1Map);
    	
    	dfs(root2, root2.left, 1, tree2Map);
    	dfs(root2, root2.right, 1, tree2Map);
    	
        return checkTreeMaps(tree1Map, tree2Map);
    }
    
    public void dfs(TreeNode parent, TreeNode node, int level, Map<Integer,Integer[]> treeMap) {
    	if(node == null)
    		return;
    	treeMap.put(node.val, new Integer[] {level,parent.val});
    	dfs(node, node.left, level+1, treeMap);
    	dfs(node, node.right, level+1, treeMap);
    }
    
    public boolean checkTreeMaps(Map<Integer,Integer[]> tree2Map, Map<Integer,Integer[]> tree1Map) {
    	if(tree1Map.size() != tree2Map.size())
    		return false;
    	
    	for(Integer x: tree2Map.keySet()) {
    		if(!tree1Map.containsKey(x))
    			return false;
    		if(tree1Map.get(x)[0] != tree2Map.get(x)[0])
    			return false;
    		if(tree1Map.get(x)[1] != tree2Map.get(x)[1])
    			return false;
    	}
    	return true;
    }
    
    
    
    
    
    
    
}

