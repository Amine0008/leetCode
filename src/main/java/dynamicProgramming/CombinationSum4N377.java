package dynamicProgramming;

public class CombinationSum4N377 {
	
    public int combinationSum4(int[] nums, int target) {
    	int[] dp = new int[target+1];
    	dp[0] = 1;
    	for(int i = 0; i <= target-1; i++) {
    		for(int j = 0; j < nums.length; j++) {
    			if(nums[j]+i <= target )
    				dp[nums[j]+i] += dp[i];
    		}
    	}
    	return dp[target];
    }

}
