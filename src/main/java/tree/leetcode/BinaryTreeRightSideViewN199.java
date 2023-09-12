package tree.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import tree.leetcode.BinaryTreeInorderTraversalN94.TreeNode;

public class BinaryTreeRightSideViewN199 {
    
	public List<Integer> rightSideView(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		levelOrderTraversing(root, result, 0);
		return result.stream().map((x)->x.get(0)).collect(Collectors.toList());
    }
	public void levelOrderTraversing(TreeNode node, List<List<Integer>> result, int level) {
		if(node == null)
			return;
		if(result.size() == level) {
			result.add(new ArrayList<>());
			result.get(level).add(node.val);
		}
		levelOrderTraversing(node.right, result, level+1);
		levelOrderTraversing(node.left, result, level+1);
			
	}
	
	public List<Integer> rightSideView2(TreeNode root) {
		List<Integer> rightMostNodes = new ArrayList<>();
		levelOrderRightLevelTraversing(root,rightMostNodes, 0);
		return rightMostNodes;
	}
	
	public void levelOrderRightLevelTraversing(TreeNode node, List<Integer> result, int level) {
		if(node == null)
			return;
		
		if(result.size() == level)
			result.add(node.val);
		levelOrderRightLevelTraversing(node.right,result,level+1);
		levelOrderRightLevelTraversing(node.left,result,level+1);
		
	}
	
	
}
