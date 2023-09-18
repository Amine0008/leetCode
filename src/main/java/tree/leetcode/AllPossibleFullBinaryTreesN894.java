package tree.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tree.leetcode.BinaryTreeInorderTraversalN94.TreeNode;

public class AllPossibleFullBinaryTreesN894 {
	
	public static void main(String[] args) {
		AllPossibleFullBinaryTreesN894 x = new AllPossibleFullBinaryTreesN894();
		x.allPossibleFBT(3);
		
	}

	
    public List<TreeNode> allPossibleFBT(int n) {
    	if((n-1)%2!=0)
    		return new ArrayList<>();
        return allPossibleFBT(n, new HashMap<>());
    }
	
    public List<TreeNode> allPossibleFBT(int n, Map<Integer,List<TreeNode>> nodesNumberTreesMap) {
    	if((n-1)%2!=0)
    		return new ArrayList<>();
    	if(nodesNumberTreesMap.containsKey(n))
    		return nodesNumberTreesMap.get(n);
    	if(n == 1) {
    		nodesNumberTreesMap.put(n,new ArrayList<>());
    		nodesNumberTreesMap.get(n).add(new TreeNode(0));
    		return nodesNumberTreesMap.get(n);
    	}
    	/*if(n == 3) {
    		TreeNode node=  new TreeNode(0);
    		node.left = new TreeNode(0);
    		node.right = new TreeNode(0);
    		nodesNumberTreesMap.put(n,new ArrayList<>());
    		nodesNumberTreesMap.get(n).add(node);
    		return  nodesNumberTreesMap.get(n);
    	}*/
    	List<Integer> possibleSubTreesNodeCount = new ArrayList<>();
    	
    	for(int i = 1;i<n-1;i++) {
    		if((n-1)%2==0)
    			possibleSubTreesNodeCount.add(i);
    	}
    	for(Integer x:possibleSubTreesNodeCount) {
    		nodesNumberTreesMap.put(x,allPossibleFBT(x,nodesNumberTreesMap));
    	}
    	
    	
    	List<TreeNode> allPossibleFBTForN = new ArrayList<>();
    	int targetNodesForBothSubTrees = n-1;
    	
    	for(Integer x:possibleSubTreesNodeCount) {
    		List<TreeNode> possibleTreesForX = nodesNumberTreesMap.get(x);
    		for(Integer y:possibleSubTreesNodeCount) {
    			if(x + y != targetNodesForBothSubTrees)
    				continue;
        		List<TreeNode> possibleTreesForY = nodesNumberTreesMap.get(y);
        		
        		for(TreeNode xTree: possibleTreesForX) {
        			for(TreeNode yTree: possibleTreesForY) {
            			//allPossibleFBTForN
                		TreeNode root = new TreeNode(0);
                		root.left = xTree;
                		root.right = yTree;
                		allPossibleFBTForN.add(root);
	            		
        			}
        			
        		}
        		
        		
    		}	
    	}
    	nodesNumberTreesMap.put(n,allPossibleFBTForN);
    	return allPossibleFBTForN;
    	
    	
    	
    }


}
