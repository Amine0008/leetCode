package tree.leetcode;

import java.util.HashMap;
import java.util.Map;

import tree.leetcode.BinaryTreeInorderTraversalN94.TreeNode;

public class BinaryTreeMaximumPathSumN124 {

	
    public int maxPathSum(TreeNode root) {
    	Map<TreeNode, Integer> nodesMPSSMap = new HashMap<>();
    	int[] result = new int[1];
    	result[0] = Integer.MIN_VALUE;
    	mpsStarting(root,nodesMPSSMap);
    	dfs(null,root,result,nodesMPSSMap);
    	return result[0];
    }
    
    public int mpsStarting(TreeNode node, Map<TreeNode, Integer> nodesMPSSMap) {
    	if(node == null)
    		return 0;
    	int nodeMPSS = 
    			Math.max(
	    			Math.max(
		    			mpsStarting(node.left,nodesMPSSMap), 
		    			mpsStarting(node.right,nodesMPSSMap)
		    			) 
		    			+ node.val,
	    			node.val);
    			
    	nodesMPSSMap.put(node,nodeMPSS);
    	return nodeMPSS;
    }
    
    public void dfs(TreeNode parent, TreeNode node, int[] maxMPSC, Map<TreeNode, Integer> nodesMPSSMap) {
    	if(node == null)
    		return;
    	dfs(node, node.left, maxMPSC,nodesMPSSMap);
    	int mpscCurrent;
    	if(parent != null) {
    		TreeNode otherChild = parent.left == node ? parent.right : parent.left;
    		if(otherChild == null)
    			mpscCurrent = Math.max(nodesMPSSMap.get(node)+parent.val, nodesMPSSMap.get(node));
    		else
    			mpscCurrent = 
    			Math.max(
	    			Math.max(
	    					nodesMPSSMap.get(node) + parent.val+nodesMPSSMap.get(otherChild),
	    					nodesMPSSMap.get(node)+parent.val
	    					),
					nodesMPSSMap.get(node));
    				
    	}
    	else
    		mpscCurrent = nodesMPSSMap.get(node);
    	if(mpscCurrent > maxMPSC[0])
    		maxMPSC[0] = mpscCurrent;
    	dfs(node,node.right, maxMPSC,nodesMPSSMap);
    		
    }

    int sum=Integer.MIN_VALUE;
    public int maxPathSum2(TreeNode root) {
        int[] result = new int[] {Integer.MIN_VALUE};
        
    	maxPathDown(root, result);
        return result[0];
    }
    
    private int maxPathDown(TreeNode node, int[] mps) {
    	if( node == null)
    		return 0;
    	
    	int left = Math.max(0, maxPathDown(node.left, mps));
    	
    	int right = Math.max(0, maxPathDown(node.right, mps));
    	
    	if(mps[0] < left + right + node.val)
    		mps[0] = left + right + node.val;
    	
    	return node.val + Math.max(left, right);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
