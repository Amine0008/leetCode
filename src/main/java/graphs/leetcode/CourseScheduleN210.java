package graphs.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CourseScheduleN210 {
	
    public int[] findOrder(int numCourses, int[][] preq) {
    	int[] result = new int[numCourses];
    	int[] nextIndex = new int[] {numCourses-1};
    	HashMap<Integer,Set<Integer>> graphMap = new HashMap<>();
    	for(int i = 0; i < preq.length; i++) {
    		if(!graphMap.containsKey(preq[i][1]))
    			graphMap.put(preq[i][1], new HashSet<>());
    		graphMap.get(preq[i][1]).add(preq[i][0]); 
    	}
    	for(int i = 0; i < numCourses; i++) {
    		if(!graphMap.containsKey(i))
    			graphMap.put(i, new HashSet<>());
    	}
    	
    	boolean[] visited = new boolean[numCourses];
    	if(!canFinish(numCourses,graphMap))
    		return new int[] {};
    	for(Integer key: graphMap.keySet()) {
    		dfs(key,graphMap,visited,result,nextIndex);
    	}
    	return result;
    }
    
    void dfs(int node, 
    		HashMap<Integer,Set<Integer>> graphMap ,
    		boolean[] visited, 
    		int[] result,
    		int[] nextIndex) {
    	
    	if(visited[node] ) {
    		return;
    	}
    		
    	visited[node] = true;
    	if(graphMap.containsKey(node))
	    	for(Integer childCourse: graphMap.get(node)) {
	    		dfs(childCourse,graphMap,visited,result,nextIndex);
	    	}
		result[nextIndex[0]] = node;
    	nextIndex[0]--;
    	
    
    }
    
    public boolean canFinish(int numCourses,  Map<Integer,Set<Integer>> graphList) {
        Boolean[] nodeIsAcyclic = new Boolean[numCourses];
        Arrays.fill(nodeIsAcyclic, null);
	
        for(int i = 0; i < numCourses; i++) {
        	if(!dfsIsAcyclic(i,graphList,nodeIsAcyclic))
        		return false;
        }
        return true;
        
	}
	
	
	public boolean dfsIsAcyclic(int node, Map<Integer,Set<Integer>>graphList,  Boolean[] nodeIsAcyclic){
		if(nodeIsAcyclic[node] != null)
			return nodeIsAcyclic[node];

		if(!graphList.containsKey(node)) {
			nodeIsAcyclic[node] = true;
			return true;
		}

		
		nodeIsAcyclic[node] = false;
		for(Integer child: graphList.get(node)) {
			if(!dfsIsAcyclic(child, graphList, nodeIsAcyclic))
				return false;
		}
		
		nodeIsAcyclic[node] = true;
		return true;
	
	
	
	
	}
	
    
    
    

}
