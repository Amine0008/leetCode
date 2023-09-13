package tree.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import tree.leetcode.BinaryTreeInorderTraversalN94.TreeNode;

public class SymmetricTreeN101 {
    public boolean isSymmetric(TreeNode root) {
    	return treesAreSymmetric(root.left, root.right);
    }
    boolean treesAreSymmetric(TreeNode nodeA, TreeNode nodeB){
    	if(nodeA == null && nodeB == null)
    		return  true;
    	if(nodeB == null)
    		return false;
    	if(nodeA == null)
    		return false;
    	return nodeA.val == nodeB.val && treesAreSymmetric(nodeA.left, nodeB.right) && treesAreSymmetric(nodeA.right, nodeB.left);
    }
    
    //iteratively
    public boolean isSymmetric2(TreeNode root) {
    	if(root == null)
    		return true;
    	//root-left-right
    	List<Integer> leftSubTreeValues = new ArrayList<>();
    	
    	Stack<TreeNode> stack = new Stack<>();
    	if(root.left != null)
    		stack.add(root.left);
    	TreeNode holder = null;
    	while(!stack.empty()) {
    		holder = stack.pop();
    		if(holder == null)
    			leftSubTreeValues.add(-101);
    		else
    			leftSubTreeValues.add(holder.val);
    		
    		if(holder != null) {
    			stack.add(holder.left);
    			stack.add(holder.right);
    		}
    	}
    	
    	int counter = 0;
    	if(root.right != null)
    		stack.add(root.right);
    	if(leftSubTreeValues.size()>=1 && stack.isEmpty())
    		return false;
    	while(!stack.isEmpty()) {
    		holder = stack.pop();
    		if(counter >= leftSubTreeValues.size())
    			return false;
    		if(holder == null && leftSubTreeValues.get(counter) != -101)
    			return false;
    		else if(holder.val != leftSubTreeValues.get(counter))
    			return false;
    		if(holder != null) {
    			stack.add(holder.right);
    			stack.add(holder.left);
    		}
    		counter++;
    	}
    	return true;
    	
    	
    	
    	
    }
    
    
    
    
    
    
    

















}

