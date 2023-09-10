package tree.leetcode;


import tree.leetcode.BinaryTreeInorderTraversalN94.TreeNode;



public class BalancedBinaryTreeN110 {
	
	public static class BooleanWrapper {
		boolean b;
		public BooleanWrapper(boolean b) {
			this.b = b;
		}
	}
    public boolean isBalanced(TreeNode root) {
    	BooleanWrapper  isBalanced = new BooleanWrapper (true);
    	findDepth(isBalanced, root);
    	return isBalanced.b;
    }
    
    public int findDepth(BooleanWrapper isBalanced, TreeNode node) {
    	if(isBalanced.b == false)
    		return -1;
    	if(node == null)
    		return 0;
    	int dlst = findDepth(isBalanced, node.left);
    	int drst = findDepth(isBalanced, node.right);
    	if(dlst-drst>=2 || dlst-drst<= -2)
    		isBalanced.b = false;
    	return Math.max(dlst, drst)+1;
    
    }
}
