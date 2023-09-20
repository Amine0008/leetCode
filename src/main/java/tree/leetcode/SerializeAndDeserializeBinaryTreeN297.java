package tree.leetcode;

import java.util.Stack;

import tree.leetcode.BinaryTreeInorderTraversalN94.TreeNode;

public class SerializeAndDeserializeBinaryTreeN297 {


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //preorder traversal: root->left->right
    	if(root == null)
    		return "N";
    	return root.val+","+serialize(root.left)+","+serialize(root.right);
    }
    

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	if(data.equals("N"))
    		return null;
    	//nodesWithNorightChildren
    	Stack<TreeNode> stack = new Stack<>();
    	String[] vals = data.split(",");
    	TreeNode previous = new TreeNode(Integer.valueOf(vals[0]));
    	TreeNode root = previous;
    	stack.add(previous);
    	TreeNode current;
    	for(int i = 1; i < vals.length; i++) {
    		current = vals[i].equals("N") ? null : new TreeNode(Integer.valueOf(vals[i]));
    		if(previous == null) {
    			stack.pop().right = current;
    		}
    		else
    			previous.left = current;
    			
    		if(current != null)
    			stack.add(current);
    		previous = current;
    		
    	}
    	return root;
    	
    	
    	
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
