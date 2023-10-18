package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class MinimumCostForTicketsN983 {
	public static void main(String[] args) {
		MinimumCostForTicketsN983 obj = new MinimumCostForTicketsN983();
		obj.mincostTickets(new int[] {1,4,6,7,8,20}, new int[] {2,7,15});
	}
	
    public int mincostTickets(int[] days, int[] costs) {
    	int[] dp = new int[days[days.length-1]+1];
    	Map<Integer,Integer> travelDates  =new HashMap<>();
    	for(int i = 0; i < days.length; i++ ) {
    		travelDates.put(days[i],i);
    	}
    		
    	dp[0] = 0;
    	for(int i = 1; i < dp.length; i++) {
    		if(!travelDates.containsKey(i)) {
    			dp[i] = dp[i-1];
    			continue;
    		}
    		if(i-30 > 0) {
    			dp[i] = Math.min(Math.min(dp[i-1] + costs[0], dp[i - 7] + costs[1]),dp[i - 30] + costs[2]); 
    		}
    		else if(i-7 > 0) {
    			dp[i] = Math.min(Math.min(dp[i-1] + costs[0], dp[i- 7] + costs[1]),costs[2]); 

    		}
    		else {
    			dp[i] = Math.min(Math.min(dp[i-1] + costs[0],costs[1]),costs[2]); 
        		
    		}
    	}
    	return dp[dp.length-1];
    }
    
}
