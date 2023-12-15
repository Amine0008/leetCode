package graphs.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindEventualSafeStatesN802 {
	
    public List<Integer> eventualSafeNodes(int[][] graph) {
        Boolean[] nodeIsSafe = new Boolean[graph.length ] ;  
        Arrays.fill(nodeIsSafe, null);
        List<Integer> result = new ArrayList<>();
        
        for(int i = 0; i < graph.length; i++) {
    		dfs(i,graph,nodeIsSafe);
    		if(nodeIsSafe[i] == true)
    			result.add(i);
        }
        return result;
    }
    
    public boolean dfs(int nodeIndex, int[][] graph,Boolean[] nodeIsSafe) {
    	if(nodeIsSafe[nodeIndex] != null)
    		return nodeIsSafe[nodeIndex];
    	
    	nodeIsSafe[nodeIndex] = false;
    	for(Integer neighbor: graph[nodeIndex]) {
    		if(dfs(neighbor,graph,nodeIsSafe) == false)
    			return false;
    	}
    	nodeIsSafe[nodeIndex] = true;
    	return true;
    	
    	
    }
    
    
    
    
    
 
}
