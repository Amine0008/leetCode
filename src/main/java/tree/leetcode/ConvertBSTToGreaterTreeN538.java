package tree.leetcode;

import tree.leetcode.BinaryTreeInorderTraversalN94.TreeNode;

public class ConvertBSTToGreaterTreeN538 {

    public TreeNode convertBST(TreeNode root) {
    	dfs(root,0,1);
    	return root;
    }
    
    //direction: 
    //   0 -> left
    //   1 -> right

    public int dfs(TreeNode node, int parentSum, int direction) {
    	if(node == null)
    		return parentSum;
    	if( (direction == 1 || direction == 0) && node.right == null)
    		node.val = node.val + parentSum;

    	else if( (direction == 1 || direction == 0) && node.right != null)
    		node.val = node.val + dfs(node.right,parentSum, 1);

    	return dfs(node.left, node.val,0);
    	
    }
}	
