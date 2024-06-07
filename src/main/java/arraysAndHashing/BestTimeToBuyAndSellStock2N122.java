package arraysAndHashing;

import java.util.HashMap;
import java.util.Map;

public class BestTimeToBuyAndSellStock2N122 {

    public int maxProfit(int[] prices) {
        int profitHolder = 0;
        Map<Integer, Integer> dayProfitMap = new HashMap<>();

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] >= prices[i]) {
                    profitHolder = prices[j] - prices[i];
                    if(!dayProfitMap.containsKey(j))
                        dayProfitMap.put(j,profitHolder);
                    if(profitHolder > dayProfitMap.get(j))
                        dayProfitMap.put(j,profitHolder);

                    break;
                }
            }
        }
        int result = 0;
        for(Integer profit: dayProfitMap.values()){
            result+=profit;
        }
        return result;
    }
}
