package dynamicProgramming;

public class CoinChangeN322 {
    public int coinChange(int[] coins, int amount) {
    	if( amount == 0)
    		return 0;
    	int[] dp = new int[amount+1];
    	for(Integer x: coins) {
    		if(x <= amount)
    			dp[x] = 1;
    	}
    	for(int i = 0; i < dp.length; i++) {
    		if(dp[i] == 0)
    			continue;
    		for(Integer x :coins) {
    			if(x >= amount)
    				continue;
    			if(x+i <= amount && (dp[i+x] == 0 || dp[i]+1<dp[i+x]))
    					dp[i+x] = dp[i]+1;
    		}
    	}
    	if(dp[amount] == 0)
    		return -1;
    	return dp[amount];
    }
}
