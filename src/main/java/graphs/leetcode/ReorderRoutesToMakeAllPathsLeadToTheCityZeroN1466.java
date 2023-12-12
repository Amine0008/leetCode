package graphs.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReorderRoutesToMakeAllPathsLeadToTheCityZeroN1466 {

    public int minReorder(int n, int[][] connections) {
    	Map<Integer,List<int[]>> graphMap = new HashMap<>(n);
    		
    	for(int[] connection: connections) {
    		if(!graphMap.containsKey((connection[0])))
    			graphMap.put(connection[0], new ArrayList<>());
    		
    		if(!graphMap.containsKey((connection[1])))
    			graphMap.put(connection[1], new ArrayList<>());
    		
    		graphMap.get(connection[0]).add(connection);
    		graphMap.get(connection[1]).add(connection);
        	
    	}
    	
    	boolean[] dp = new boolean[n];
    	dp[0] = true;
    	int[] counter = new int[] {0};
    	bfs(0,graphMap,dp,counter);
    	return counter[0];
    }
    
    public void bfs(int node, Map<Integer,List<int[]>> graphMap, boolean[] dp, int[] counter) {
    	List<int[]> connections = graphMap.get(node);
    	for(int[] connection: connections) {
    		if(dp[connection[0]] && dp[connection[1]])
    			continue;
    		if(!dp[connection[1]]) {
    			counter[0]++;
    			dp[connection[1]] = true;
    			bfs(connection[1],graphMap,dp,counter);
    		}
    		else {
    			dp[connection[0]] = true;
    			bfs(connection[0],graphMap,dp,counter);
    		}
    	}
    }
    
    
    
    
    
    
    
    
}
