package tree.leetcode;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import tree.leetcode.BinaryTreeInorderTraversalN94.TreeNode;

public class MaximumWidthOfBinaryTreeN662 {

   public class LevelInfo {
	   BigInteger left = BigInteger.ZERO;
	   BigInteger right = BigInteger.ZERO;
	LevelInfo(BigInteger left, BigInteger right){
			this.left = left;
			this.right = right;
		}
	public String toString() {
		return "left: "+left+",right: "+right;
	}
	}

   public int widthOfBinaryTree(TreeNode root) {
	   Map<Long,LevelInfo> levelInfoMap = new HashMap<>();
	   dfs(root,0L,BigInteger.ZERO,levelInfoMap);
	   int result = 1;
	   LevelInfo y = null;
	   for(LevelInfo x :levelInfoMap.values()) {
		   if(x.right.equals(BigInteger.ZERO))
			   continue;
		   if((x.right.subtract(x.left).add(BigInteger.valueOf(1))).compareTo(BigInteger.valueOf(result))>0) {
			   result = x.right.subtract(x.left).add(BigInteger.ONE).intValue();
			   y=x;}
	   }
	   System.out.print(y);
	   return result;
   }
   
   public void dfs(TreeNode node, Long currentLevel, BigInteger currentPosition, Map<Long,LevelInfo> levelInfoMap) {
	   if(node == null)
		   return;
	   if(!levelInfoMap.containsKey(currentLevel))
		   levelInfoMap.put(currentLevel, new LevelInfo(currentPosition,BigInteger.ZERO));
	   else {
		   LevelInfo info = levelInfoMap.get(currentLevel);
		   info.right = currentPosition;
	   }
	   dfs(node.left,currentLevel+1,currentPosition.multiply(BigInteger.valueOf(2)),levelInfoMap);
	   dfs(node.right,currentLevel+1,currentPosition.multiply(BigInteger.valueOf(2)).add(BigInteger.ONE),levelInfoMap);
	   
   }
	
   
}


