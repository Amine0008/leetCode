package tree.leetcode;


import tree.leetcode.BinaryTreeInorderTraversalN94.TreeNode;

public class KthSmallestElementInBSTN230 {

	
    public int kthSmallest(TreeNode root, int k) {

     int[] counterAndResult = new int[] {0,0};
     dfs(root,k,counterAndResult);
     return counterAndResult[1];
    }
    
    public void dfs(TreeNode node, int k, int[] counterAndResult) {
    	if(node == null)
    		return  ;
    	dfs(node.left,k,counterAndResult);
    	counterAndResult[0]++;
    	if(counterAndResult[0] == k)
    		counterAndResult[1] = node.val;
    	dfs(node.right, k, counterAndResult);
    	
    }
    
   
}
