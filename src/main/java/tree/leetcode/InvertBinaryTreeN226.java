package tree.leetcode;

import tree.leetcode.BinaryTreeInorderTraversalN94.TreeNode;

public class InvertBinaryTreeN226 {

    public TreeNode invertTree(TreeNode root) {
        invertingTree(null, root);
        return root;
    }
    public void invertingTree(TreeNode temp, TreeNode node) {
    	if(node == null)
    		return;
    	temp = node.left;
    	node.left = node.right;
    	node.right = temp;
    	invertingTree(temp, node.left);
    	invertingTree(temp, node.right);
    }
}
