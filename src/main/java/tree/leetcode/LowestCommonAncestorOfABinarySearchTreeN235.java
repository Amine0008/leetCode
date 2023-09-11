package tree.leetcode;

import java.util.LinkedList;
import java.util.Queue;

import tree.leetcode.BinaryTreeInorderTraversalN94.TreeNode;

public class LowestCommonAncestorOfABinarySearchTreeN235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	int l = Math.min(p.val, q.val);
    	int r = Math.max(p.val, q.val);

		Queue<TreeNode> nodesQueue = new LinkedList<>();
		nodesQueue.add(root);
		TreeNode current = null;
		while(!nodesQueue.isEmpty()) {
			current = nodesQueue.remove();
			if(current != null) {
				if(current.val>=l && current.val<=r)
					return current;
				nodesQueue.add(current.left);
				nodesQueue.add(current.right);
			}
		}
    	return null;
    }
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
        	return null;
        if(root.val > p.val && root.val > q.val)
        	return lowestCommonAncestor2(root.left,p,q);
        else if(root.val < p.val && root.val < q.val)
        	return lowestCommonAncestor2(root.right,p,q);
        else
        	return root;
    }
    
    
}
