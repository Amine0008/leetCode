package tree.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversalN94 {

  public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
     }
 }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inOrderTraversal(result, root);
        return result;
    	
    }
    private void inOrderTraversal(List<Integer> list, TreeNode node) {
    	if(node == null)
    		return;
    	inOrderTraversal(list, node.left);
    	list.add(node.val);
    	inOrderTraversal(list, node.right);
    }
}
