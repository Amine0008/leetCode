package dynamicProgramming;


public class PartitionEqualSubsetSumN416 {
	
	public static void main(String[] args) {
		PartitionEqualSubsetSumN416 x = new PartitionEqualSubsetSumN416();
		x.canPartition(new int[] {1,5,11,5});
	}
	
    public boolean canPartition(int[] nums) {
        int sum = 0; 
        for(int i = 0; i < nums.length; i++) {
        	sum+=nums[i];
        }
        if(sum%2 != 0)
        	return false;

        int target = sum/2;

        boolean[][] dp = new boolean[target+1][nums.length];
        dp[0][0] = true;
        if(nums[0] <= target)
        	dp[nums[0]][0] = true;
        
        for(int j = 1; j < nums.length; j++) {
        	for(int i = 0; i <= target; i++ ) {
        		if(dp[i][j-1]) {
        			dp[i][j] = true;
        			if(i+nums[j] <= target)
        				dp[i+nums[j]][j] = true;
        		}
        	}	
        }
        return dp[target][nums.length-1];
        
    	}
    

    }


