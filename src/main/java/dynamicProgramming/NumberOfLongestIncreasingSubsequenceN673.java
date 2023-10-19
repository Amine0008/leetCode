package dynamicProgramming;


public class NumberOfLongestIncreasingSubsequenceN673 {
	
	public static void main(String[] args) {
		NumberOfLongestIncreasingSubsequenceN673 x = new NumberOfLongestIncreasingSubsequenceN673();
		x.findNumberOfLIS(new int[] {1,2,4,3,5,4,7,2});
	}
    public int findNumberOfLIS(int[] nums) {
    	
    	int[] dp = new int[nums.length];
    	int[] dpc = new int[nums.length];
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
    	
    	dpc[0] = 1;
    	int counter = 0;
    	for(int i = 0; i < dpc.length; i++) {
    		if(dp[i] == 1)
    			dpc[i] = 1;
    		else {
	    		for(int j = i-1; j >= 0; j--) {
	    			if(nums[j]<nums[i] && dp[j] == dp [i]-1)
	    				dpc[i]+=dpc[j];
	    			
	    		}
    		}
    		if(dp[i] == result)
    			counter+=dpc[i];
    		
    	}
    	return counter;
    	
    	
    }
    
    
    
    
    
    
    
    
}
