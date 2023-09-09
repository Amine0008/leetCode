package tree.leetcode;

import java.util.ArrayList;
import java.util.List;

import tree.leetcode.BinaryTreeInorderTraversalN94.TreeNode;

public class BinaryTreePostorderTraversalN145 {
    public List<Integer> postorderTraversal(TreeNode root) {
    	List<Integer> result = new ArrayList<>();
    	postOrderTraversing(result, root);
    	return result;
    }
    public void postOrderTraversing(List<Integer> result, TreeNode node) {
    	if(node == null)
    		return;
    	postOrderTraversing(result, node.left);
    	postOrderTraversing(result, node.right);
    	result.add(node.val);
    }
    
}
