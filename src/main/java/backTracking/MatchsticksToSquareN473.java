package backTracking;

import java.util.Arrays;
import java.util.Collections;

public class MatchsticksToSquareN473 {
	
    public boolean makesquare(int[] matchsticks) {
    	Integer[] matches = Arrays.stream(matchsticks).boxed().toArray(Integer[]::new);
    	Arrays.sort(matches, Collections.reverseOrder());
    	int sum = 0;
    	
    	for(Integer x : matchsticks) {
    		sum += x;
    	}
    	if(sum % 4 != 0)
    		return false;
    	
    	//target length
    	sum = sum/4;
    		
    	int[] sides = new int[4];
    	return backtracking(sum, 4, sides, matches, 0);
    	
    
    }
    
    public boolean backtracking(int targetLength, int sidesLeft, int[] sides, Integer[] matchsticks, int matchIndex) {
    	if(sidesLeft == 0 && matchIndex == matchsticks.length)
    		return true;
    	if(matchIndex == matchsticks.length)
    		return false;
    	
    	boolean result = false;
    	int sideNewLength;
    	for(int i = 0; i < sides.length; i++) {
    		sideNewLength = sides[i] + matchsticks[matchIndex]; 
    		if(sideNewLength > targetLength)
    			continue;
    		sides[i] = sideNewLength;
    		
    		result = backtracking(targetLength,
	    				sides[i] == targetLength ? sidesLeft - 1:sidesLeft,
						sides,
						matchsticks,
	    				matchIndex + 1 );
    		if(result)
    			return true;
    		sides[i] = sides[i] - matchsticks[matchIndex];
    		
    	}
    	return false;
    }










}
