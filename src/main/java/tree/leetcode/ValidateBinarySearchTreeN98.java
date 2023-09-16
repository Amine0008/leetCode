package tree.leetcode;


import java.util.ArrayList;
import java.util.List;

import tree.leetcode.BinaryTreeInorderTraversalN94.TreeNode;

public class ValidateBinarySearchTreeN98 {
    public boolean isValidBST(TreeNode root) {
    	List<Integer> treeValues = new ArrayList<>();
    	dfs(root,treeValues);
    	for(int i = 0; i<treeValues.size()-1;i++) {
    		if(treeValues.get(i)>treeValues.get(i+1))
    			return false;
    	}
    	return true;
    }
    
    public void dfs(TreeNode node,List<Integer>vals) {
    	if(node == null)
    		return;
    	dfs(node.left,vals);
    	vals.add(node.val);
    	dfs(node.right,vals);
    }
/////////////////////////////
    public boolean isValidBST2(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        } else if (root.left == null || root.right == null) {
            return root.left == null ? rightSubtreeLeftMost(root.right) > root.val && isValidBST(root.right) : leftSubtreeRightMost(root.left) < root.val && isValidBST(root.left);
        } else {
            if (leftSubtreeRightMost(root.left) >= root.val || rightSubtreeLeftMost(root.right) <= root.val) {
                return false;
            } else {
                return isValidBST(root.left) && isValidBST(root.right);
            }
        }
    }

    private int leftSubtreeRightMost(TreeNode root) {
        while(root.right != null) {
            root = root.right;
        }
        return root.val;
    }

    private int rightSubtreeLeftMost(TreeNode root) {
        while(root.left != null) {
            root = root.left;
        }
        return root.val;
    }
}
