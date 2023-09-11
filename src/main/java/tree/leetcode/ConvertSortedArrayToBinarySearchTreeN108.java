package tree.leetcode;

import tree.leetcode.BinaryTreeInorderTraversalN94.TreeNode;

public class ConvertSortedArrayToBinarySearchTreeN108 {

	
    public TreeNode sortedArrayToBST(int[] nums) {
        return  createSubTreeRoot(nums, 0, nums.length-1);
    }
    public TreeNode createSubTreeRoot(int[] nums, int l, int r) {
    	if(l>r)
    		return null;
    	int mid = (r-l)/2+l;
    	TreeNode node = new TreeNode(nums[mid]);
    	node.left = createSubTreeRoot(nums,l,mid-1);
    	node.right = createSubTreeRoot(nums,mid+1, r);
    	return node;
    }
}
