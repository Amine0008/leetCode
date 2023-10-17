package dynamicProgramming;

import java.util.Arrays;

public class DeleteAndEarnN740 {
	public static void main(String[] args) {
		DeleteAndEarnN740 x = new DeleteAndEarnN740();
		x.deleteAndEarn(new int[] {8,10,4,9,1,3,5,9,4,10});
	}
	
	public int deleteAndEarn(int[] nums) {
		int[] dp = new int[nums.length];
		Arrays.sort(nums);
		dp[0]= nums[0];
		
		
		int result = dp[0];
		
		int maxHolder;
		for(int i = 1; i < nums.length; i++) {
			maxHolder = 0;
			for(int j = 0; j < i; j++) {
				if(nums[j]== nums[i]-1)
					continue;
				if(dp[j] > maxHolder)
					maxHolder = dp[j];
			}
			dp[i] = nums[i] + maxHolder;
			if(dp[i] > result)
				result = dp[i];
		}
		return result;
		
	}
	
}
