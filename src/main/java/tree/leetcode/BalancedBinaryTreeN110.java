package tree.leetcode;


import tree.leetcode.BinaryTreeInorderTraversalN94.TreeNode;



public class BalancedBinaryTreeN110 {
	
    public boolean isBalanced(TreeNode root) {
    	boolean []  isBalanced = new boolean[1];
    	findDepth(isBalanced, root);
    	return isBalanced[0];
    }
    
    public int findDepth(boolean [] isBalanced, TreeNode node) {
    	if(isBalanced[0] == false)
    		return -1;
    	if(node == null)
    		return 0;
    	int dlst = findDepth(isBalanced, node.left);
    	int drst = findDepth(isBalanced, node.right);
    	if(dlst-drst>=2 || dlst-drst<= -2)
    		isBalanced[0] = false;
    	return Math.max(dlst, drst)+1;
    
    }

    public boolean isBalanced2(TreeNode root) {
    	if(findDepth(root) == -1)
    		return false;
    	return true;
    }
    
    public int findDepth(TreeNode node) {
    	if(node == null)
    		return 0;
    	int lst = findDepth(node.left);
    	if(lst == -1)
    		return -1;
    	int rst = findDepth(node.right);
    	if(rst == -1)
    		return -1;
    	if(lst - rst >= 2 || lst - rst <= -2)
    		return -1;
    	return Math.max(lst, rst) + 1;
    }
}
