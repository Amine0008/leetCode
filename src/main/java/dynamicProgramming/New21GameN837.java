package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class New21GameN837 {
	
    public double new21Game(int n, int k, int maxPts) {
    	Map<Integer, Double> memo = new HashMap<>();
    	return dfs(0,maxPts,k,n,memo);
    
    }
    
    public double dfs(int currentPoints, int maxPts, int k, int n, Map<Integer, Double> memo) {
    	if(memo.containsKey(currentPoints))
    		return memo.get(currentPoints);
    	if(currentPoints >= k) {
    		if(currentPoints <= n) {
    			memo.put(currentPoints, (double)1);
    			return 1;
    		}
    		memo.put(currentPoints, (double)0);
    		return 0;
    	}
    	double holder  = 0;
    	for(int i = 1; i <= maxPts; i++) {
    		holder += dfs(currentPoints+i, maxPts, k, n, memo);
    	}
    	memo.put(currentPoints, holder/(double) maxPts);
    	return memo.get(currentPoints);
    }

}
