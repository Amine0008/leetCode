package arraysAndHashing.twoPointers.run2;

public class BestTimeToBuyAndSellStockN121 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n];
        dp[n-1] = prices[n-1];
        for(int i  = prices.length-2; i >= 0; i--){
            if(prices[i] > dp[i+1])
                dp[i] = prices[i];
            else
                dp[i] = dp[i+1];
        }
        int maxProfit = 0;
        int holder;
        for(int i = 0; i < dp.length-1; i++){
            holder = dp[i+1] - prices[i];
            if( holder > maxProfit)
                maxProfit = dp[i+1] - prices[i];
        }
        return maxProfit;
    }

    public int maxProfit2(int[] prices) {
        int currentMin = prices[0];
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < currentMin)
                currentMin = prices[i];
            if(prices[i] - currentMin > maxProfit)
                maxProfit = prices[i] - currentMin;
        }
        return maxProfit;
    }
}
