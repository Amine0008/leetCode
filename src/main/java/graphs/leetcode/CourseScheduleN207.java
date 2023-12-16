package graphs.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseScheduleN207 {
    
	public boolean canFinish(int numCourses, int[][] preq) {
        Map<Integer,List<Integer>> graphList = new HashMap<>();
        
        for(int i = 0; i < preq.length; i++) {
        	if(!graphList.containsKey(preq[i][1]))
        		graphList.put(preq[i][1], new ArrayList<>());
        	graphList.get(preq[i][1]).add(preq[i][0]);
        }
        Boolean[] nodeIsAcyclic = new Boolean[numCourses];
        Arrays.fill(nodeIsAcyclic, null);
	
        for(int i = 0; i < numCourses; i++) {
        	if(!dfsIsAcyclic(i,graphList,nodeIsAcyclic))
        		return false;
        }
        return true;
        
	}
	
	
	public boolean dfsIsAcyclic(int node, Map<Integer,List<Integer>>graphList,  Boolean[] nodeIsAcyclic){
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