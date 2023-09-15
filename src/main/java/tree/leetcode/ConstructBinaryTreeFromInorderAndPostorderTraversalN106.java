package tree.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import tree.leetcode.BinaryTreeInorderTraversalN94.TreeNode;

public class ConstructBinaryTreeFromInorderAndPostorderTraversalN106 {
	
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	if(inorder.length == 0)
    		return null;
    	if(inorder.length == 1)
    		return new TreeNode(inorder[0]);
    	TreeNode root = new TreeNode(postorder[postorder.length-1]);
    	int rootPostPosition = postorder.length-1;
    	int rootIotPosition = 0;
    	for(int i = 0; i<inorder.length; i++) {
    		if(inorder[i] == root.val) {
    			rootIotPosition = i;
    			break;
    		}
    	}
    	root.left = buildTree(
    			Arrays.copyOfRange(inorder, 0, rootIotPosition),
    			Arrays.copyOfRange(postorder, 0, rootIotPosition));
    	
    	root.right = buildTree(
    			Arrays.copyOfRange(inorder, rootIotPosition+1, inorder.length),
    			Arrays.copyOfRange(postorder, rootIotPosition, rootPostPosition));
    	return root;
    }
    
    
    
    
    
    
    
    
}
