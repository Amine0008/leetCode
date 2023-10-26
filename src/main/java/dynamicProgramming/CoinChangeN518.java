package dynamicProgramming;

import java.util.Arrays;

public class CoinChangeN518 {
	
    public int change(int amount, int[] coins) {
    	if(amount == 0)
    		return 1;
    	Arrays.sort(coins);
    	int[][] dp = new int[amount+1][coins.length];
    
    	Arrays.fill(dp[0], 1);
    	
    	for(int i = 1; i < dp.length; i++) {
    		if(i % coins[0] == 0)
    			dp[i][0] = 1;
    	}
    	
    	for(int j = 1; j < coins.length; j++) {
    		for(int i = 1; i < dp.length; i++) {
    			dp[i][j] = dp[i][j-1] +( i-coins[j] >= 0 ? dp[i-coins[j]][j] :0);
    		}
    	}
    	return dp[amount][coins.length-1];
    	
    }
    

}
