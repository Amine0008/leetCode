package dynamicProgramming;

public class BestTimeToBuyAndSellStockWithCooldownN309 {
	
    public int maxProfit(int[] prices) {
    	int[][] dp = new int[prices.length][prices.length];
    	int[] sells = new int[prices.length];
    		 
    	int result = 0;
    	int maxPreviousSells = 0;
    	for(int j = 0; j < dp.length-1; j++) {
    		for(int x = j-1; x >= 0; x--) {
    			if(sells[x] > maxPreviousSells)
    				maxPreviousSells = sells[x];
    		}
    		for(int i = j+1; i < dp.length; i++) {
    			dp[i][j] = prices[i]-prices[j]+maxPreviousSells;
    			if(dp[i][j] > sells[i])
    				sells[i] = dp[i][j];
    			if(dp[i][j]>result)
    				result = dp[i][j];
    		}
    	}
    	return result;
    }

}
