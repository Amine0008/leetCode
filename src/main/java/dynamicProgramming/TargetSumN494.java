package dynamicProgramming;

public class TargetSumN494 {
	
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int x : nums) {
        	sum+=x;
        }
        if(Math.abs(target) > sum)
        	return 0;
        int[][] dp = new int[sum+1][nums.length];
        
        for(int i = 0; i <= sum; i++) {
        	if(nums[0] == i || nums[0] == -i)
        		if(i == 0)
        			dp[i][0] = 2;
        		else
        			dp[i][0] = 1;
        }
        int x;
        int y;
        for(int j = 1; j < nums.length; j++) {
        	for(int i = 0; i <= sum ; i++) {
        		x = Math.abs(i-nums[j]);
        		y = Math.abs(i+nums[j]);
        		dp[i][j] = (x > sum ? 0 : dp[x][j-1] ) + (y > sum ? 0: dp[y][j-1]);
        	}
        }
        return dp[Math.abs(target)][nums.length-1];
        
    }

}
