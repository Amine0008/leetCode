package dynamicProgramming;

public class MaximumProductSubarrayN152 {
    
	
	public int maxProduct(int[] nums) {
    	int[] dp = new int[nums.length];
    	dp[0] = nums[0];
    	int maxProduct = dp[0];
    	for(int i = 1; i < dp.length; i++) {
    		dp[i] = Math.max(nums[i], dp[i-1]*nums[i]);
    		if(dp[i] > maxProduct)
    			maxProduct = dp[i];
    	}
    	return maxProduct;
    }
	
	public int maxProduct2(int[] nums) {
		int cmp = nums[0];
		int icm;
		for(int i = 0; i<nums.length; i++) {
			icm = 1;
			for(int j = i;j<nums.length; j++) {
				icm*=nums[j];
				if(cmp<icm)
					cmp=icm;
			}
		}
		return cmp;
	}
	
	public int maxProduct3(int[] nums) {
		int[][] dp = new int[nums.length][2];
		dp[0][0] = nums[0];
		dp[0][1] = nums[1];
		
		for(int i = 1; i < dp.length; i++) {
			dp[i][0] = minOfThree(nums[i],dp[i-1][0]*nums[i],dp[i-1][1]*nums[i]);
			dp[i][1] = maxOfThree(nums[i],dp[i-1][0]*nums[i],dp[i-1][1]*nums[i]);
			
		}
		int result = dp[0][0];
		for(int i = 0; i<dp.length; i++) {
			if(dp[i][0]>result)
				result =dp[i][0];
			if(dp[i][1]>result)
				result =dp[i][1];
		}
		return result;
		
	}
	int minOfThree(int a, int b, int c) {
		return Math.min(Math.min(a, b),c);
	}
	int maxOfThree(int a, int b, int c) {
		return Math.max(Math.max(a, b),c);
	}
	
	
	
	
	
	
	
	
}
