package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class SolvingQuestionsWithBrainpowerN2140 {
	
    public long mostPoints(int[][] questions) {
     long[][] dp = new long[questions.length][2];   
     	
     long result = 0;
     for(int i = 0; i < dp.length; i++) {
    	 dp[i][0] += questions[i][0];	
    	 dp[i][1] = i + questions[i][1];
    	 long max = 0;
    	 for(int j = i-1; j >= 0; j--) {
    		 if(dp[j][1] < i && dp[j][0] > max)
    			 max = dp[j][0];
    	 }
    	 dp[i][0]+=max;
    	 if(dp[i][0] > result)
    		 result = dp[i][0];
     }
     return result;
    }
    
    public long mostPoints2(int[][] questions) {
    	return dfs(0,questions, new HashMap<>());
    }
    
    
    public long dfs(int currentIndex, int[][] questions, Map<Integer,Long> memo ) {
    	if(currentIndex >= questions.length)
    		return 0;
    	if(memo.containsKey(currentIndex))
    		return memo.get(currentIndex);
    	
    	long left = questions[currentIndex][0] + dfs(currentIndex+questions[currentIndex][1]+1, questions, memo);
    	
    	long right = dfs(currentIndex+1, questions, memo);
    	
    	memo.put(currentIndex, Math.max(left, right));
    	return memo.get(currentIndex);
    	
    	
    }
    
    
    
    
    
    
    

}
