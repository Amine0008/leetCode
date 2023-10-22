package dynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestTeamWithNoConflictsN1626 {
	
	public static void main(String[] args) {
		BestTeamWithNoConflictsN1626 x = new BestTeamWithNoConflictsN1626();
		x.bestTeamScore(new int[] {4,5,6,5}, new int[] {2,1,2,1});
	}
	
    public int bestTeamScore(int[] scores, int[] ages) {
    	Map<Integer, List<Integer>> map = new HashMap<>();
    	
    	for(int i = 0; i < ages.length; i++) {
    		if(!map.containsKey(ages[i]))
    			map.put(ages[i], new ArrayList<>());
    		map.get(ages[i]).add(scores[i]);
    	}
    	for(List<Integer> l: map.values()) {
    		Collections.sort(l);
    	}
    	
    	List<Integer> agesList = new ArrayList<>(map.keySet());
    	Collections.sort(agesList);
    	int counter = 0;
    	for(Integer age: agesList) {
    		List<Integer> ageScores = map.get(age);
    		int numberOfPlayers = ageScores.size();
    		
    		for(int i = 0; i < numberOfPlayers; i++) {
    			ages[counter] = age;
    			scores[counter] = ageScores.get(i);
    			counter++;
    		}
    	}
       	int[] dp = new int[scores.length];
    	dp[0] = scores[0];
    	
    	int maxHolder;
    	int result = dp[0];
    	for(int i = 1 ; i < dp.length; i++) {
    		dp[i] = scores[i];
    		maxHolder = 0;
    		for(int j = i-1; j >= 0; j--) {
    			if(ages[j] < ages[i] && scores[j] > scores[i])
    				continue;
    			if(dp[j] > maxHolder)
    				maxHolder = dp[j];
    		}
    		dp[i]+=maxHolder;
    		if(dp[i] > result)
    			result = dp[i];
    	}
    	return result;
    }
    
    
    
    
    
    
    
    
    
    
    

}
