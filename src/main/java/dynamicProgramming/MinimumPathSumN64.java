package dynamicProgramming;

import java.util.Arrays;

public class MinimumPathSumN64 {

   public int minPathSum(int[][] grid) {
	   
	   int[][] dp = new int[grid.length][grid[0].length];
	   for(int[] x: dp) {
		   Arrays.fill(x,Integer.MAX_VALUE);
	   }
	   dp[0][0] = grid[0][0];
	   
	   for(int i = 0; i < grid.length; i++) {
		   for(int j = 0; j < grid[0].length; j++) {
			   if(j+1 < grid[0].length && dp[i][j+1] > grid[i][j+1]+dp[i][j]) 
				   dp[i][j+1] = grid[i][j+1]+dp[i][j];
			   
			   if(i+1 < grid.length && dp[i+1][j] > grid[i+1][j]+dp[i][j])
				   dp[i+1][j] = grid[i+1][j]+dp[i][j];
		   }
	   }
	   return dp[grid.length-1][grid[0].length-1];
   
   }
}
