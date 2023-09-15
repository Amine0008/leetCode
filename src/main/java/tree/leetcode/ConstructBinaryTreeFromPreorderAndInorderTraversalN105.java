package tree.leetcode;

import java.util.HashMap;

import tree.leetcode.BinaryTreeInorderTraversalN94.TreeNode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversalN105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	HashMap<Integer,Integer> inorderPositions = new HashMap<>();
    	for(int i = 0; i<inorder.length; i++) {
    		inorderPositions.put(inorder[i], i);
    	}
    	
    	return reconstructingTree(preorder,
    			inorder,
    			0,
    			preorder.length-1,
    			0,
    			inorder.length-1,
    			inorderPositions);
    	
    }
    TreeNode reconstructingTree(int[] preorder,
    		int[] inorder,
    		int plOld,
    		int prOld,
    		int ilOld,
    		int irOld,
    		HashMap<Integer,Integer> inorderPositions) {
    	
    	if(plOld>prOld)
    		return null;
    	if(plOld==prOld)
    		return new TreeNode(preorder[plOld]);
    	TreeNode root = new TreeNode(preorder[plOld]);
    	int il = ilOld;
    	int ir = inorderPositions.get(root.val)-1;
    	
    	int pl = plOld+1;
    	int pr = plOld + (ir-il)+ 1;
    	root.left = reconstructingTree(preorder,
    			inorder,
    			pl,
    			pr,
    			il,
    			ir,
    			inorderPositions);
    	
    	root.right = reconstructingTree(preorder,
    			inorder,
    			pr+1,
    			prOld,
    			inorderPositions.get(root.val)+1,
    			irOld,
    			inorderPositions);
    	return root;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
