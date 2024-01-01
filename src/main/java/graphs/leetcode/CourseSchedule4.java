package graphs.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CourseSchedule4 {
	
	
    
	public List<Boolean> checkIfPrerequisite(int numCourses, 
			int[][] preq, 
			int[][] queries) {
    	int[] topSort = new int[numCourses];
    	int[] nextIndex = new int[] {numCourses-1};
    	HashMap<Integer,Set<Integer>> graphMap = new HashMap<>();
    	for(int i = 0; i < preq.length; i++) {
    		if(!graphMap.containsKey(preq[i][0]))
    			graphMap.put(preq[i][0], new HashSet<>());
    		graphMap.get(preq[i][0]).add(preq[i][1]); 
    	}
    	for(int i = 0; i < numCourses; i++) {
    		if(!graphMap.containsKey(i))
    			graphMap.put(i, new HashSet<>());
    	}
    	
    	boolean[] visited = new boolean[numCourses];
    	for(Integer key: graphMap.keySet()) {
    		dfs(key,graphMap,visited,topSort,nextIndex);
    	}
    	for(int key: graphMap.keySet()) {
    		System.out.println(key+" --> "+graphMap.get(key));
    	}
    	
    	Map<Integer,Set<Integer>> preqMap = new HashMap<>();
    	for(Integer course: topSort) {
    		if(!preqMap.containsKey(course))
    			preqMap.put(course, new HashSet<>());
    		for(Integer directChild: graphMap.get(course)) {
        		if(!preqMap.containsKey(directChild))
        			preqMap.put(directChild, new HashSet<>());
        		preqMap.get(directChild).add(course);
        		for(Integer currentCourseDep: preqMap.get(course)) {
        			preqMap.get(directChild).add(currentCourseDep);
        		}
    		}
    	}
    	
    	List<Boolean> result = new ArrayList<>();
    	for(int[] query: queries) {
    		if(preqMap.get(query[1]).contains(query[0]))
    			result.add(true);
    		else
    			result.add(false);
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

}
