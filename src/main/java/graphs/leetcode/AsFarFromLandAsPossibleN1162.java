package graphs.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AsFarFromLandAsPossibleN1162 {

  
    public int maxDistance(int[][] grid) {
        boolean foundWater = false;
        boolean foundLand = false;
    	for(int i = 0; i < grid.length; i++) {
    		if(foundWater && foundLand)
    			break;
    		for(int j = 0; j < grid.length; j++) {
    			if(grid[i][j] == 1)
    				foundLand = true;
    			if(grid[i][j] == 0)
    				foundWater = true;
    		}
    	}
    	if(!foundWater || !foundLand)
    		return -1;
    	
    	int currentLargestDistance = -1;
    	int holder;
    	Map<String,Integer> waterNodeNearestLandDistanceMap = new HashMap<>();
    	
    	for(int i = 0; i < grid.length; i++) {
    		for(int j = 0; j < grid.length; j++) {
    			if(grid[i][j] == 0) {
    				holder = bfsDistance(new int[] {i,j},grid,waterNodeNearestLandDistanceMap);
    				if(holder > currentLargestDistance)
    					currentLargestDistance = holder;
    			}
    		}
		}
    	return currentLargestDistance;
    	
    }
    
    public int bfsDistance(int[] originalNode,
    		int[][] grid,
    		Map<String,Integer> map ) {
    	
    	Set<String> visitedNodes = new HashSet<>();
    	visitedNodes.add(originalNode[0]+","+originalNode[1]);
    	Queue<int[]> q = new LinkedList<>();
    	q.add(originalNode);
    	List<int[]> currentWave;
    	int r;
    	int c;
    	int currentShortestDistance = Integer.MAX_VALUE;
    	boolean landFound = false;
    	while(!q.isEmpty()) {
    		currentWave = new ArrayList<>();
    		while(!q.isEmpty()) {
    			currentWave.add(q.poll());
    		}
    		for(int[] node: currentWave) {
    			r = node[0];
    			c = node[1];
    			
    			if(grid[r][c] == 1 || map.containsKey(r+","+c) ) {
    				landFound = true;
    				int distanceHolder = Math.abs(originalNode[0]-r)+Math.abs(originalNode[1]-c);
    				if(distanceHolder < currentShortestDistance)
    					currentShortestDistance = distanceHolder;
    			}
    				
    			for(int[] neighbor: new int[][] {{r-1,c+1},{r-1,c},{r-1,c-1},{r,c-1},{r,c+1},{r+1,c-1},{r+1,c},{r+1,c+1}}) {
    				if(neighbor[0] >= 0 
    						&& neighbor[0] < grid.length 
    						&& neighbor[1] >= 0 
    						&& neighbor[1] < grid.length
    						&& !visitedNodes.contains(neighbor[0]+","+neighbor[1])) {
    					visitedNodes.add(neighbor[0]+","+neighbor[1]);
    					q.add(neighbor);
    				}
    			}
    		}
    		if(landFound)
    			return currentShortestDistance;
    	}
    	return currentShortestDistance;
    
    
    
    }
    
    
    
    
    
    
    
    
    
    
    
}
