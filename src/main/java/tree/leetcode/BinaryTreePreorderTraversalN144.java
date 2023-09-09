package tree.leetcode;

import java.util.ArrayList;
import java.util.List;

import tree.leetcode.BinaryTreeInorderTraversalN94.TreeNode;

public class BinaryTreePreorderTraversalN144 {

    public List<Integer> preorderTraversal(TreeNode root) {
    	List<Integer> result = new ArrayList<>();
    	preOrderTraversing(result, root);
    	return result;
    }
    
    private void preOrderTraversing(List<Integer> result, TreeNode root) {
    	if(root == null)
    		return;
    	result.add(root.val);
    	preOrderTraversing(result, root.left);
    	preOrderTraversing(result, root.right);
    }
}
