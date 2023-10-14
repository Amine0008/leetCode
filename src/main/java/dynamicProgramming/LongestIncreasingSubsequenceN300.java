package dynamicProgramming;

public class LongestIncreasingSubsequenceN300 {
	
    public int lengthOfLIS(int[] nums) {
    	int[] dp = new int[nums.length];
    	dp[0] = 1;
    	int maxDp; 
    	int result = dp[0];
    	for(int i = 1; i < nums.length; i++) {
    		maxDp = 0;
    		
    		for(int j = i-1; j>=0; j--) {
    			if(nums[j]<nums[i] && dp[j]>maxDp)
    				maxDp = dp[j];
    		}
    		dp[i] = maxDp+1;
    		if(dp[i]>result)
    			result = dp[i];
    	}
    	return result;
    	
    }

}
