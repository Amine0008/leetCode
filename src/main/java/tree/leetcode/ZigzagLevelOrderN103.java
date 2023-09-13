package tree.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import tree.leetcode.BinaryTreeInorderTraversalN94.TreeNode;

public class ZigzagLevelOrderN103 {
    
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	List<LinkedList<Integer>> levels = new ArrayList<>();
    	zigzagLevelOrdertraversing(root,levels, 0);
    	return levels.stream().map(ll->ll.stream().collect(Collectors.toList())).collect(Collectors.toList());
    }
	public void zigzagLevelOrdertraversing(TreeNode node, List<LinkedList<Integer>> levels, int level) {
		if(node == null)
			return;
		if(levels.size() == level)
			levels.add(new LinkedList<>());
		if(level%2 == 0)
			levels.get(level).addFirst(node.val);
		else
			levels.get(level).add(node.val);
		zigzagLevelOrdertraversing(node.right,levels, level+1);
		zigzagLevelOrdertraversing(node.left,levels, level+1);
	}
    
    
}
