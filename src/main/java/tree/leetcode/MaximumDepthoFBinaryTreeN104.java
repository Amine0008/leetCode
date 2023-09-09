package tree.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

import tree.leetcode.BinaryTreeInorderTraversalN94.TreeNode;

public class MaximumDepthoFBinaryTreeN104 {
    public int maxDepth2(TreeNode root) {
    	if(root == null)
    		return 0;
     PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
     traversing(pq, 0, root);
     return pq.poll();
    }
    public void traversing(PriorityQueue<Integer> pq, int counter, TreeNode node) {
    	if(node == null) {
    		pq.add(counter);
    		return;
    	}
    	if(node != null)
    		counter++;
    	traversing(pq, counter, node.left);
    	traversing(pq, counter, node.right);
    	
    }

    public int maxDepth(TreeNode root) {
        if(root == null)
        	return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
}
