
package ArraysAndHashing;

public class BestTimeToBuyAndSellStockN121 {
	
	
	public static void main(String[] args) {
	}
	
	//brute force
    public static int maxProfit(int[] prices) {
    	int minValueSeenSoFar = prices[0];
    	int maxProfit = 0;
    	
    	for(int i = 0; i < prices.length; i++) {
    		if(prices[i] < minValueSeenSoFar)
    			minValueSeenSoFar = prices[i];
    		if(prices[i] - minValueSeenSoFar > maxProfit)
    			maxProfit = prices[i] - minValueSeenSoFar;
    	}
    	return maxProfit;
    }
	
	
}
