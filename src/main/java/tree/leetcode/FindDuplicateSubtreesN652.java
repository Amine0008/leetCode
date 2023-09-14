package tree.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tree.leetcode.BinaryTreeInorderTraversalN94.TreeNode;

public class FindDuplicateSubtreesN652 {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    	return serializingTree(root);
    }
    
    public List<TreeNode> serializingTree(TreeNode root) {
    	Map<String, Integer> map = new HashMap<>();
    	List<TreeNode> result = new ArrayList<>();
    	serialize(root, map, result);
    	return result;
    }
    
    public String serialize(TreeNode node, Map<String, Integer> map, List<TreeNode> result){
    	if(node == null)
    		return "n,";
    	
    	String leftSubTreeSerial = serialize(node.left,map,result);
    	
    	if(leftSubTreeSerial != "n,") {
    		map.merge(leftSubTreeSerial, 1, Integer::sum);
        	if(map.get(leftSubTreeSerial)==2)
        		result.add(node.left);	
    	}

    	String rightSubTreeSerial = serialize(node.right,map,result);
    	
    	if(rightSubTreeSerial != "n,") {
    		map.merge(rightSubTreeSerial, 1, Integer::sum);
        	if(map.get(rightSubTreeSerial)==2)
        		result.add(node.right);
    	}
    	return leftSubTreeSerial+rightSubTreeSerial+node.val+",";
    	
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
