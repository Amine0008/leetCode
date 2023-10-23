package dynamicProgramming;

public class UniquePaths2N63 {
   
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if(obstacleGrid[0][0] == 1)
			return 0;
		int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
		dp[0][0] = 1;
		
		for(int i = 0; i < dp.length; i++) {
			for(int j = 0; j < dp[0].length; j++) {
				if(j+1 < dp[0].length && obstacleGrid[i][j+1] != 1)
					dp[i][j+1]+=dp[i][j];
				if(i+1 < dp.length && obstacleGrid[i+1][j] != 1)
					dp[i+1][j]+=dp[i][j];
			}
		}
		return dp[obstacleGrid.length-1][dp[0].length-1];
    }
}
